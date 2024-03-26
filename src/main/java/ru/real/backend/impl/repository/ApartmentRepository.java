package ru.real.backend.impl.repository;

import org.springframework.stereotype.Repository;
import ru.real.backend.core.repository.BaseRepository;
import ru.real.backend.domain.model.apartment.Apartment;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends BaseRepository<Apartment> {
    Optional<Apartment> findByExternalId(Long externalId);
}
