package ru.real.backend.impl.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.real.backend.api.dto.UserDto;
import ru.real.backend.api.dto.auth.RegistrationRequest;
import ru.real.backend.domain.model.user.User;
import ru.real.backend.impl.mapper.UserMapper;
import ru.real.backend.impl.mapper.UserRegistrationMapper;
import ru.real.backend.impl.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserRegistrationMapper registrationMapper;

    public Boolean isExists(String username) {
        return repository.findByUsername(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким username не найден"));
    }

    public UserDetails save(RegistrationRequest request) {
        return repository.save(registrationMapper.convertToEntity(request));
    }

    public UserDto findById(UUID id) {
        return mapper.convertToDto(repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким username не найден")));
    }

    public UserDto findByUsername(String username) {
        return mapper.convertToDto(repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким username не найден")));
    }

    public UserDto update(@NotNull UserDto dto) {
        User user = repository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким username не найден"));
        if (!user.getEmail().equals(dto.getEmail()))
            repository.findAllByEmail(dto.getEmail()).stream()
                    .findAny()
                    .ifPresent(s -> {
                        throw new RuntimeException("found");
                    });
        if (!user.getPhone().equals(dto.getPhone()))
            repository.findAllByPhone(dto.getPhone()).stream()
                    .findAny()
                    .ifPresent(s -> {
                        throw new RuntimeException("found");
                    });
        User toSave = mapper.convertToEntity(dto);
        toSave.setId(user.getId());
        toSave.setDateTimeCreated(user.getDateTimeCreated());
        toSave.setUsername(user.getUsername());
        toSave.setPassword(user.getPassword());
        return mapper.convertToDto(repository.save(toSave));
    }

    public void deleteByUsername(String username) {
        repository.findByUsername(username).stream()
                .findFirst()
                .ifPresent(it -> repository.deleteById(it.getId()));
    }
}
