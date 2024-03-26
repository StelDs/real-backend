package ru.real.backend.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.ApartmentParserDto;
import ru.real.backend.api.dto.FileInformationDto;
import ru.real.backend.core.resource.BaseStorageResource;

import java.util.List;

@RequestMapping
public interface StorageResource extends BaseStorageResource<FileInformationDto> {
}
