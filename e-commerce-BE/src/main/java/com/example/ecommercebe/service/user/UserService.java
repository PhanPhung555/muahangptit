package com.example.ecommercebe.service.user;

import com.example.ecommercebe.entity.role.Role;
import com.example.ecommercebe.entity.user.User;
import com.example.ecommercebe.exception.AppException;
import com.example.ecommercebe.exception.ErrorCode;
import com.example.ecommercebe.mapper.requets.UserDTORequest;
import com.example.ecommercebe.mapper.response.ApiResponse;
import com.example.ecommercebe.mapper.response.UserDTOResponse;
import com.example.ecommercebe.repository.role.IRoleRepository;
import com.example.ecommercebe.repository.user.IUserRepository;
import com.example.ecommercebe.service.email.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService{

    IUserRepository iUserRepository;

    IRoleRepository roleRepository;

    ModelMapper modelMapper;

    PasswordEncoder passwordEncoder;

    EmailService emailService;

    @Override
    public UserDTOResponse saveAndUpdateUser(UserDTORequest userDTORequest) {

        if(userDTORequest.getId() != null){

           var  existingUser  = iUserRepository.findById(userDTORequest.getId()).orElse(null);

            if(existingUser == null){
                throw new AppException(ErrorCode.ACCOUNT_EXITS);
            }

            if(!userDTORequest.getUsername().equals(existingUser.getUsername())){
                throw new AppException(ErrorCode.ACCOUNT_NAME_CANNOT_BE_CHANGED);
            }
        }

        if(userDTORequest.getId() == null && iUserRepository.existsByUsername(userDTORequest.getUsername())){
           throw new AppException(ErrorCode.USERNAME_EXITS);
        }

        if(userDTORequest.getId() == null && iUserRepository.existsByEmailUser(userDTORequest.getEmailUser())){
            throw new AppException(ErrorCode.EMAIL_EXITS);
        }

        if(userDTORequest.getRoleIds() == null) {
            userDTORequest.setRoleIds(Set.of(1L));
        }

        User user = modelMapper.map(userDTORequest, User.class);

        Set<Role> roles = roleRepository.findByIdIn(userDTORequest.getRoleIds());

        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        iUserRepository.save(user);

        UserDTOResponse userDTOResponse = modelMapper.map(user, UserDTOResponse.class);

        return userDTOResponse ;
    }

    @Override
    public void handleForgotPassword(String emailOrNumberPhone) {

        if(iUserRepository.existsByEmailUser(emailOrNumberPhone)){
            throw new AppException(ErrorCode.EMAIL_NOT_FOUND);
        }

    }

    @Override
    public UserDTOResponse generateAndSendOTP(String emailOrNumberPhone) {
        User user = iUserRepository.findByEmailUser(emailOrNumberPhone);

        if(user == null){
            throw new AppException(ErrorCode.EMAIL_NOT_FOUND);
        }

        String otp = generateOTP();

        user.setOtp(otp);

        emailService.sendPasswordResetOTP(emailOrNumberPhone,otp);

        iUserRepository.save(user);

        return modelMapper.map(user, UserDTOResponse.class);

    }

    @Override
    public void resetPassword(String email, String otp, String newPassword) {
        User user = iUserRepository.findByEmailUser(email);

        if(user == null){
            throw new AppException(ErrorCode.EMAIL_NOT_FOUND);
        }

        if(!user.getOtp().equals(otp)){
            throw new AppException(ErrorCode.ERROR_OTP);
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setOtp(null);
        iUserRepository.save(user);
    }

    @Override
    public UserDTOResponse login(String userName, String password) {

        Optional<User> userAccountOptional = Optional.ofNullable(iUserRepository.findByUsername(userName))
                .or(() -> Optional.ofNullable(iUserRepository.findByEmailUser(userName)));

        User user = userAccountOptional.orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));

        if(!passwordEncoder.matches(password, user.getPassword()) ){
            throw new AppException(ErrorCode.ACCOUNT_NOT_FOUND);
        }
        return modelMapper.map(user, UserDTOResponse.class);

    }

    private String generateOTP() {
        // Generate a 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

}
