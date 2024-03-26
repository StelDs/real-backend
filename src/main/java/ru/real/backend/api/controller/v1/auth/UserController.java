package ru.real.backend.api.controller.v1.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.real.backend.api.dto.UserDto;
import ru.real.backend.api.resource.UserResource;
import ru.real.backend.api.search.UserSearchDto;
import ru.real.backend.impl.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController implements UserResource {
    private final UserService service;

    @Override
    public ResponseEntity<UserDto> findById(UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<UserDto> create(UserDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<UserDto>> findAll(UserSearchDto filter, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> findByUsername(String username) {
        return ResponseEntity.ok(service.findByUsername(username));
    }

    @Override
    public ResponseEntity<Void> deleteByUsername(String username) {
        service.deleteByUsername(username);
        return ResponseEntity.ok().build();
    }
}
