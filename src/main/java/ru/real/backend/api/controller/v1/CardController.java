package ru.real.backend.api.controller.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.real.backend.api.dto.ApartmentFullDto;
import ru.real.backend.api.resource.CardResource;
import ru.real.backend.api.search.ApartmentSearchDto;
import ru.real.backend.impl.service.apartment.ApartmentService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/apartments/card", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CardController implements CardResource {
    private final ApartmentService apartmentService;

    @Override
    public ResponseEntity<ApartmentFullDto> findById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<ApartmentFullDto> create(ApartmentFullDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApartmentFullDto> update(ApartmentFullDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<ApartmentFullDto>> findAll(ApartmentSearchDto filter, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<ApartmentFullDto> findByIdFull(UUID id) {
        return ResponseEntity.ok(apartmentService.findByIdFull(id));
    }
}
