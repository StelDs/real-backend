package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.apartment.parametr.ApartmentType;

@Mapper(componentModel = "spring")
public interface ApartmentTypeMapper extends BaseMapper<ApartmentType, DictionaryDto> {
}
