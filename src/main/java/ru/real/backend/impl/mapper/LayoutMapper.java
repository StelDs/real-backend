package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.apartment.parametr.Layout;

@Mapper(componentModel = "spring")
public interface LayoutMapper extends BaseMapper<Layout, DictionaryDto> {
}
