package com.example.ecommercebe.service.user;

import com.example.ecommercebe.mapper.requets.UserDTORequest;
import com.example.ecommercebe.mapper.response.UserDTOResponse;

import java.util.Set;

public interface IUserService {

    UserDTOResponse saveAndUpdateUser(UserDTORequest userDTORequest);

    void handleForgotPassword(String emailOrNumberPhone);

    UserDTOResponse generateAndSendOTP(String emailOrNumberPhone);

    void resetPassword(String email, String otp, String newPassword);

    UserDTOResponse login(String userName, String password);
}
