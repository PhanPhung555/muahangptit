package com.example.ecommercebe.mapper.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTOResponse {

    Long id;

    String username;

    String emailUser;

    String numberPhoneUser;

    String password;

    String otp;
}
