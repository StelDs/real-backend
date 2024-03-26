package ru.real.backend.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.real.backend.api.dto.auth.RegistrationRequest;
import ru.real.backend.core.mapper.BaseMapper;
import ru.real.backend.domain.model.user.User;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", imports = {ZonedDateTime.class})
public abstract class UserRegistrationMapper implements BaseMapper<User, RegistrationRequest> {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "surname", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "patronymic", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "dateTimeCreated", expression = "java(ZonedDateTime.now())")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(registrationRequest.getPassword()))")
    @Override
    public abstract User convertToEntity(RegistrationRequest registrationRequest);

    @Override
    public abstract RegistrationRequest convertToDto(User Entity);
}
