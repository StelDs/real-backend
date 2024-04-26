package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import ru.real.backend.api.dto.ApartmentFullDto;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.apartment.Apartment;

@Mapper(componentModel = "spring")
public interface ApartmentFullMapper extends BaseMapper<Apartment, ApartmentFullDto> {
}
