package ru.real.backend.api.controller.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.real.backend.api.dto.ApartmentParserDto;
import ru.real.backend.api.dto.FileInformationDto;
import ru.real.backend.api.resource.StorageResource;
import ru.real.backend.impl.service.storage.StorageService;
import ru.real.backend.impl.util.ApartmentExcelParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Предоставляет возможность взаимодействия с хранилищем на сервере
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/storage/files", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StorageController implements StorageResource {
    private final StorageService storageService;

    /**
     * Реализует загрузку файлов с сервера
     *
     * @param filename Название файла
     * @return Результат загрузки файла с сервера
     */
    @Override
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource resource = storageService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /**
     * Реализует загрузку одного файла на сервер
     *
     * @param file Файл
     * @return Информация о загруженном на сервер файле
     */
    @Override
    public FileInformationDto uploadFile(@RequestParam("file") MultipartFile file) {
        String name = storageService.store(file);
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/storage/files/download/")
                .path(name)
                .toUriString();
//        return new FileInformationDto(name, uri, file.getContentType(), file.getSize());
        return null;
    }

    /**
     * Реализует множественную загрузку файлов на сервер
     *
     * @param files Массив файлов
     * @return Информация о загруженных на сервер файлах
     */
    @Override
    public List<FileInformationDto> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }
}
