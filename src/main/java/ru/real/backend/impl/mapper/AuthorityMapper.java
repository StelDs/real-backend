package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.user.Authority;

@Mapper(componentModel = "spring")
public interface AuthorityMapper extends BaseMapper<Authority, DictionaryDto> {
}
