package ru.real.backend.impl.repository;

import org.springframework.stereotype.Repository;
import ru.real.backend.core.repository.BaseRepository;
import ru.real.backend.domain.model.apartment.parametr.ApartmentType;

import java.util.Optional;

@Repository
public interface ApartmentTypeRepository extends BaseRepository<ApartmentType> {
    Optional<ApartmentType> findByName(String name);
}
