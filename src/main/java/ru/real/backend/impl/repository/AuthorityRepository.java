package ru.real.backend.impl.repository;

import org.springframework.stereotype.Repository;
import ru.real.backend.core.repository.BaseRepository;
import ru.real.backend.domain.model.user.Authority;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends BaseRepository<Authority> {
    Optional<Authority> findByName(String name);
}
