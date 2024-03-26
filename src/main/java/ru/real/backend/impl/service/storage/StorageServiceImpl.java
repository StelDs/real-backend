package ru.real.backend.impl.service.storage;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.core.config.properties.StorageProperties;
import ru.real.backend.core.exception.storage.FileNotFoundException;
import ru.real.backend.core.exception.storage.StorageException;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {
    /**
     * Расположение хранилища на сервере
     */
    private final Path rootLocation;

    /**
     * Конструктор, инициализирующий поле {@link StorageServiceImpl#rootLocation} значением {@code properties}
     *
     * @param properties Экземпляр {@link StorageProperties}
     */
    public StorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    /**
     * Пре-инит метод, создающий директорю, согласно указанному расположению {@link StorageServiceImpl#rootLocation}
     */
    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException(
                    "storage.not.initialize", "Хранилище не инициализируется", "Не удалось инициализировать место хранения", e);
        }
    }

    /**
     * Сохраняет файл в хранилище сервера
     *
     * @param file Файл в виде экземпляра {@link MultipartFile}
     * @return Имя сохраненного файла
     */
    @Override
    public String store(MultipartFile file) {
        String filename = RandomStringUtils.randomAlphanumeric(25) + "-" + StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (file.isEmpty()) {
                throw new StorageException("file.is.empty", "Пустой файл",
                        "Не удалось сохранить пустой файл " + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException("", "",
                        "Невозможно сохранить файл с относительным путем вне текущего каталога " + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("file.failed.to.store", "Не удалось сохранить файл",
                    "Не удалось сохранить файл " + filename, e);
        }
        return filename;
    }

    /**
     * Поиск расположения файла на сервере
     *
     * @param filename Название файла
     * @return Местоположение искомого файла на сервере
     */
    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    /**
     * Поиск файла и его возврат в виде экземпляра {@link Resource}
     *
     * @param filename Название файла
     * @return Файл в виде экземпляра {@link Resource}
     */
    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("file.not.read", "Не удалось прочитать файл",
                        "Не удалось прочитать файл: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("file.not.read", "Не удалось прочитать файл",
                    "Не удалось прочитать файл: " + filename, e);
        }
    }

    /**
     * Получение всех файлов из хранилища сервера
     *
     * @return Поток(набор) всех файлов из хранилища сервера
     */
    @Override
    public Stream<Path> loadAll() {
        try (Stream<Path> paths = Files.walk(this.rootLocation, 1)) {
            return paths
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("files.field.read.stored", "Не удалось прочитать",
                    "Не удалось прочитать сохраненные файлы", e);
        }
    }

    /**
     * Удаление всех файлов из хранилища сервера
     */
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
