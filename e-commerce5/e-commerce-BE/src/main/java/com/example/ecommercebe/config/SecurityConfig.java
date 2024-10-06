package com.example.ecommercebe.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityConfig {

    private final String[] EXCLUDED_PATHS = {"/api/**"};


    @Bean
    SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(request ->
                /** Cho phép tất cả đường dẫn EXCLUDED_PATHS có thể truy cập mà không cần xác thực với method POST
                 * với method GET - đường dẫn /list thì cần quyền ADMIN
                 */
                request.requestMatchers(EXCLUDED_PATHS).permitAll()
                        .anyRequest().authenticated());

        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
