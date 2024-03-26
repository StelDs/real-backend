package ru.real.backend.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.ApartmentShortDto;
import ru.real.backend.api.search.ApartmentSearchDto;
import ru.real.backend.core.resource.BaseResource;

@RequestMapping
public interface ApartmentResource extends BaseResource<ApartmentShortDto, ApartmentSearchDto> {
    @PostMapping("/parse")
    ResponseEntity<?> parseFile(@RequestParam("file") MultipartFile file);
}
