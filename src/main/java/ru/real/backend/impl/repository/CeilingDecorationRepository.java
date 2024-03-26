package ru.real.backend.impl.repository;

import org.springframework.stereotype.Repository;
import ru.real.backend.core.repository.BaseRepository;
import ru.real.backend.domain.model.apartment.parametr.CeilingDecoration;

import java.util.Optional;

@Repository
public interface CeilingDecorationRepository extends BaseRepository<CeilingDecoration> {
    Optional<CeilingDecoration> findByName(String name);
}
