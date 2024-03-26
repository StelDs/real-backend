package ru.real.backend.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.api.search.DictionarySearchDto;
import ru.real.backend.core.resource.BaseResource;

import java.util.List;

@RequestMapping
public interface DictionaryResource extends BaseResource<DictionaryDto, DictionarySearchDto> {
    @GetMapping()
    public ResponseEntity<List<DictionaryDto>> findByAll();
}
