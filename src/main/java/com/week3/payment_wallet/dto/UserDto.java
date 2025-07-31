package com.week3.payment_wallet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    private String password;

    public @NotBlank String getUsername() {
        return username;
    }

    public @Email String getEmail() {
        return email;
    }

    public @NotBlank String getPassword() {
        return password;
    }
}
