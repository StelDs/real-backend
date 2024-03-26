package ru.real.backend.api.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.real.backend.core.model.BaseSearchDto;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionarySearchDto extends BaseSearchDto {
    private UUID id;
    private String name;
}
