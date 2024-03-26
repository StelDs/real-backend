package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import ru.real.backend.api.dto.UserDto;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.user.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {
}
