package ru.real.backend.api.dto;

import ru.real.backend.core.dto.BaseDto;

public class FileInformationDto extends BaseDto {
    /**
     * Имя
     */
    private String name;
    /**
     * Унифицированный идентификатор ресурса
     */
    private String uri;
    /**
     * Тип
     */
    private String type;
    /**
     * Размер
     */
    private Long size;
}
