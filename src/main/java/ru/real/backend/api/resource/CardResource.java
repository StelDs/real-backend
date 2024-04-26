package ru.real.backend.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.ApartmentFullDto;
import ru.real.backend.api.dto.ApartmentShortDto;
import ru.real.backend.api.search.ApartmentSearchDto;
import ru.real.backend.core.resource.BaseResource;

import java.util.UUID;

@RequestMapping
public interface CardResource extends BaseResource<ApartmentFullDto, ApartmentSearchDto> {

    @GetMapping("/card/{id}")
    ResponseEntity<ApartmentFullDto> findByIdFull(@PathVariable("id") UUID id);

}
