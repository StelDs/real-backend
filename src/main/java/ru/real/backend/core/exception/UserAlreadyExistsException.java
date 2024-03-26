package ru.real.backend.core.exception;

public class UserAlreadyExistsException extends BasicBeingHandledException {
    private static final long serialVersionUID = 6351033652842919842L;

    public UserAlreadyExistsException() {
        this("user.already.exists", "User already exists", "Пользователь уже существует");
    }

    public UserAlreadyExistsException(String code, String title, String message) {
        this(code, title, message, null);
    }

    public UserAlreadyExistsException(String code, String title, String message, Throwable cause) {
        super(code, title, message, cause);
    }
}
