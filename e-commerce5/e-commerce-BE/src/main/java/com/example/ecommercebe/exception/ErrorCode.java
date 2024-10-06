package com.example.ecommercebe.exception;



public enum ErrorCode {
    ERROR_EXITS_EXCEPTION( 9999 ,"Lỗi không xác định , kiểm tra lại"),
    ERROR_OTP( 9998 ,"OTP không chính xác"),
    USERNAME_EXITS( 1001 ,"Tên tài khoản không được trùng lặp"),
    EMAIL_EXITS( 1002 ,"Email không được trùng lặp"),
    EMAIL_NOT_FOUND( 1004 ,"Không tìm thấy email"),
    ACCOUNT_EXITS( 1003 ,"Không tìm thấy tài khoản hoặc mật khẩu không đúng"),
    ACCOUNT_NAME_CANNOT_BE_CHANGED( 1004 ,"Tên tài khoản không thể thay đổi"),
    ACCOUNT_NOT_FOUND( 1005 ,"Tên đăng nhập hoặc mật khẩu không đúng"),
    ;


    private int code;

    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
