package com.example.ecommercebe.exception;

import com.example.ecommercebe.mapper.response.ApiResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> runtimeExceptionHandler(AppException appException) {

        ApiResponse apiResponse = new ApiResponse();
        ErrorCode errorCode = appException.getErrorCode();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return  ResponseEntity.badRequest().body(apiResponse);

    }


}
