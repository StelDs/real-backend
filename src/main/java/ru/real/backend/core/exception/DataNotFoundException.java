package ru.real.backend.core.exception;

import lombok.Getter;

/**
 * DataNotFoundException - это класс технических исключений, которые могут быть выброшены во время работы приложения в
 * случае, когда данные не найдены. Смотреть {@link BasicBeingHandledException}
 */
@Getter
public class DataNotFoundException extends BasicBeingHandledException {
    private static final long serialVersionUID = 6351033652842919842L;

    public DataNotFoundException(String code, String title, String message) {
        this(code, title, message, null);
    }

    public DataNotFoundException(String code, String title, String message, Throwable cause) {
        super(code, title, message, cause);
    }
}
