package com.example.ecommercebe.mapper.requets;

import com.example.ecommercebe.entity.role.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTORequest {

    Long id;

    @NotBlank(message = "Username is required")
    String username;

    @NotBlank(message = "Email is required")
    String emailUser;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 digits")
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits")
    String numberPhoneUser;

    @NotBlank(message = "Password is required")
    String password;

    String otp;

    Set<Long> roleIds;
}
