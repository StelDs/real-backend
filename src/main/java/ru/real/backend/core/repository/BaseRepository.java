package ru.real.backend.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.real.backend.core.model.BaseEntity;

import java.util.UUID;

public interface BaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, UUID>, JpaSpecificationExecutor<Entity> {
}