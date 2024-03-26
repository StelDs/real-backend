package ru.real.backend.core.resource;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.core.dto.BaseDto;

import java.util.List;

public interface BaseStorageResource<Dto extends BaseDto> {
    @GetMapping("/download/{filename:.+}")
    ResponseEntity<Resource> downloadFile(@PathVariable String filename);

    @PostMapping("/upload-file")
    Dto uploadFile(@RequestParam("file") MultipartFile file);

    @PostMapping("/upload-multiple-files")
    List<Dto> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files);
}
