package ru.real.backend.core.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.real.backend.core.dto.BaseDto;
import ru.real.backend.core.model.BaseSearchDto;

import java.util.UUID;

public interface BaseResource<Dto extends BaseDto, Search extends BaseSearchDto> {
    @GetMapping("/{id}")
    ResponseEntity<Dto> findById(@PathVariable("id") UUID id);

    @PostMapping("/")
    ResponseEntity<Dto> create(@RequestBody Dto dto);

    @PutMapping("/")
    ResponseEntity<Dto> update(@RequestBody Dto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") UUID id);

    @PostMapping("/all")
    ResponseEntity<Page<Dto>> findAll(@RequestBody(required = false) Search filter, Pageable pageable);
}
