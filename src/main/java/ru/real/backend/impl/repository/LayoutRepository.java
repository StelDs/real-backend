package ru.real.backend.impl.repository;

import org.springframework.stereotype.Repository;
import ru.real.backend.core.repository.BaseRepository;
import ru.real.backend.domain.model.apartment.parametr.Layout;

import java.util.Optional;

@Repository
public interface LayoutRepository extends BaseRepository<Layout> {
    Optional<Layout> findByName(String name);
}
