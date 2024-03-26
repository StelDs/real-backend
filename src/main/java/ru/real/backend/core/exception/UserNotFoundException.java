package ru.real.backend.core.exception;

public class UserNotFoundException extends BasicBeingHandledException {
    private static final long serialVersionUID = 6351033652842919842L;

    public UserNotFoundException() {
        this("user.not.found", "User not found", "Пользователь не найден");
    }

    public UserNotFoundException(String code, String title, String message) {
        this(code, title, message, null);
    }

    public UserNotFoundException(String code, String title, String message, Throwable cause) {
        super(code, title, message, cause);
    }
}
