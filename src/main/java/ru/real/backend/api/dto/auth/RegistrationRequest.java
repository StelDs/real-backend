package ru.real.backend.api.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.real.backend.core.util.validation.constraints.ContactNumber;
import ru.real.backend.core.util.validation.constraints.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationRequest {
    @NotBlank
    @Size(min = 5, max = 256)
    private String username;

    @NotBlank
//    @ContactNumber
    private String phone;

    @Email
    @NotBlank
    private String email;

    @NotBlank
//    @Password
    private String password;
}
