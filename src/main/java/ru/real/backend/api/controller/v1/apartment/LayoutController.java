package ru.real.backend.api.controller.v1.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.api.resource.DictionaryResource;
import ru.real.backend.api.search.DictionarySearchDto;
import ru.real.backend.impl.service.apartment.LayoutService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/layouts", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LayoutController implements DictionaryResource {
    private final LayoutService service;


    @Override
    public ResponseEntity<DictionaryDto> findById(UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<DictionaryDto> create(DictionaryDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<DictionaryDto> update(DictionaryDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Page<DictionaryDto>> findAll(DictionarySearchDto filter, Pageable pageable) {
        return ResponseEntity.ok(service.findAll(filter, pageable));
    }

    @Override
    public ResponseEntity<List<DictionaryDto>> findByAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
