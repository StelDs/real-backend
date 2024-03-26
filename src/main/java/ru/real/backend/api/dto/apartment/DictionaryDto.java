package ru.real.backend.api.dto.apartment;

import lombok.*;
import ru.real.backend.core.dto.BaseDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryDto extends BaseDto {
    private String name;
}
