package ru.real.backend.core.mapper;

public interface BaseMapper<Entity, Dto> {
    Entity convertToEntity(Dto dto);
    Dto convertToDto(Entity Entity);
}
