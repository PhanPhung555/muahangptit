package com.example.ecommercebe.controller;


import com.example.ecommercebe.mapper.response.ApiResponse;
import com.example.ecommercebe.mapper.response.UserDTOResponse;
import com.example.ecommercebe.service.user.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    IUserService iUserService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserDTOResponse>> login(@RequestParam String username, @RequestParam String password){
         iUserService.login(username,password);
        ApiResponse<UserDTOResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setMessage("Đăng nhập thành công");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
