package ru.real.backend.impl.repository;

import org.springframework.stereotype.Repository;
import ru.real.backend.core.repository.BaseRepository;
import ru.real.backend.domain.model.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);

    List<User> findAllByEmail(String email);

    List<User> findAllByPhone(String phone);

    void deleteByUsername(String username);
}
