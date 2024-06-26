package ru.real.backend.api.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
