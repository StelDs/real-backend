package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import ru.real.backend.api.dto.ApartmentShortDto;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.apartment.Apartment;

@Mapper(componentModel = "spring")
public interface ApartmentShortMapper extends BaseMapper<Apartment, ApartmentShortDto> {
}
