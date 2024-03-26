package ru.real.backend.impl.service.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Перечень методов по взаимодействию с хранилищем на сервере
 */
public interface StorageService {
    /**
     * Метод, создающий директорию, согласно указанному расположению
     */
    void init();

    /**
     * Сохраняет файл в хранилище сервера
     *
     * @param file Файл в виде экземпляра {@link MultipartFile}
     * @return Имя сохраненного файла
     */
    String store(MultipartFile file);

    /**
     * Поиск расположения файла на сервере
     *
     * @param filename Название файла
     * @return Местоположение искомого файла на сервере
     */
    Path load(String filename);

    /**
     * Поиск файла и его возврат в виде экземпляра {@link Resource}
     *
     * @param filename Название файла
     * @return Файл в виде экземпляра {@link Resource}
     */
    Resource loadAsResource(String filename);

    /**
     * Получение всех файлов из хранилища сервера
     *
     * @return Поток(набор) всех файлов из хранилища сервера
     */
    Stream<Path> loadAll();

    /**
     * Удаление всех файлов из хранилища сервера
     */
    void deleteAll();
}
