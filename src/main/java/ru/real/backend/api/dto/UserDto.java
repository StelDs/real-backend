package ru.real.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.real.backend.core.dto.BaseDto;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String phone;
    private String username;
    private LocalDate dateOfBirth;
}
