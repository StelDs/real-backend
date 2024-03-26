package ru.real.backend.api.controller.v1.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.api.resource.AuthorityResource;
import ru.real.backend.api.search.DictionarySearchDto;
import ru.real.backend.impl.service.AuthorityService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/authorities", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AuthorityController implements AuthorityResource {
    private final AuthorityService authorityService;

    @Override
    public ResponseEntity<DictionaryDto> findById(UUID id) {
        return ResponseEntity.ok(authorityService.findById(id));
    }

    @Override
    public ResponseEntity<DictionaryDto> create(DictionaryDto dto) {
        return ResponseEntity.ok(authorityService.save(dto));
    }

    @Override
    public ResponseEntity<DictionaryDto> update(DictionaryDto dto) {
        return ResponseEntity.ok(authorityService.update(dto));
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        authorityService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Page<DictionaryDto>> findAll(DictionarySearchDto filter, Pageable pageable) {
        return ResponseEntity.ok(authorityService.findAll(filter, pageable));
    }
}
