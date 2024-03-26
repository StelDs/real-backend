package ru.real.backend.core.exception.storage;

import ru.real.backend.core.exception.BasicBeingHandledException;

public class StorageException extends BasicBeingHandledException {

    public StorageException(String code, String title, String message) {
        this(code, title, message, null);
    }

    public StorageException(String code, String title, String message, Throwable cause) {
        super(code, title, message, cause);
    }
}
