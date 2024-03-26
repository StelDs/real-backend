package ru.real.backend.api.search;

import lombok.Getter;
import ru.real.backend.core.model.BaseSearchDto;

@Getter
public class ApartmentSearchDto extends BaseSearchDto {
    String address;
}
