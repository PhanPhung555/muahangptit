package com.example.ecommercebe.controller;


import com.example.ecommercebe.mapper.requets.UserDTORequest;
import com.example.ecommercebe.mapper.response.ApiResponse;
import com.example.ecommercebe.mapper.response.UserDTOResponse;
import com.example.ecommercebe.service.user.IUserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDTOResponse>> register(@RequestBody @Valid UserDTORequest userDTORequest) {
        System.out.println(userDTORequest);
        ApiResponse<UserDTOResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setMessage("Thêm mới thành công");
        apiResponse.setData(iUserService.saveAndUpdateUser(userDTORequest));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserDTOResponse>> updateUser(@RequestBody @Valid UserDTORequest userDTORequest){
        ApiResponse<UserDTOResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(iUserService.saveAndUpdateUser(userDTORequest));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


    @PostMapping("/forgotPassword")
    public ResponseEntity<ApiResponse<UserDTOResponse>> forgotPassword(@RequestParam String email) {
        UserDTOResponse userDTOResponse = iUserService.generateAndSendOTP(email);
        ApiResponse<UserDTOResponse> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Một OTP đã được gửi đến email của bạn để đặt lại mật khẩu.");
        apiResponse.setData(userDTOResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("email/{email}/otp/{opt}/newpassword/{password}")
    public ResponseEntity<ApiResponse<Void>> authenticateOTP(@PathVariable String opt, @PathVariable String password, @PathVariable String email) {
        iUserService.resetPassword(email,opt,password);
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Lấy tài khoản thành công , mới đăng nhập");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
