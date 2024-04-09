package ru.real.backend.api.controller.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.ApartmentShortDto;
import ru.real.backend.api.dto.ApartmentSmartSearchDto;
import ru.real.backend.api.resource.ApartmentResource;
import ru.real.backend.api.search.ApartmentSearchDto;
import ru.real.backend.impl.service.apartment.ApartmentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/apartments", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class ApartmentController implements ApartmentResource {
    private final ApartmentService apartmentService;

    @Override
    public ResponseEntity<ApartmentShortDto> findById(UUID id) {
        return ResponseEntity.ok(apartmentService.findById(id));
    }

    @Override
    public ResponseEntity<ApartmentShortDto> create(ApartmentShortDto dto) {
        return ResponseEntity.ok(apartmentService.save(dto));
    }

    @Override
    public ResponseEntity<ApartmentShortDto> update(ApartmentShortDto dto) {
        return ResponseEntity.ok(apartmentService.update(dto));
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        apartmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Page<ApartmentShortDto>> findAll(ApartmentSearchDto filter, Pageable pageable) {
        return ResponseEntity.ok(apartmentService.findAll(filter, pageable));
    }

    @Override
    public ResponseEntity<List<ApartmentShortDto>> parseFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(apartmentService.parseAndSave(file));
    }

    @PostMapping("/smart-search")
    public ResponseEntity<Page<ApartmentShortDto>> smartSearch(@RequestBody ApartmentSmartSearchDto filter, Pageable pageable) {
        return ResponseEntity.ok(apartmentService.smartSearch(filter, pageable));
    }
}
