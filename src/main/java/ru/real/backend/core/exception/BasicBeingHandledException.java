package ru.real.backend.core.exception;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Базовое исключение
 */
@Getter
public abstract class BasicBeingHandledException extends RuntimeException {
    private static final long serialVersionUID = 8384207723970493949L;
    private final String code;
    private final String title;
    private final String errorTraceId = UUID.randomUUID().toString();
    private final LocalDateTime time = LocalDateTime.now();

    public BasicBeingHandledException(String code, String title, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.title = title;
    }
}
