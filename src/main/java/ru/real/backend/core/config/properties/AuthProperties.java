package ru.real.backend.core.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Свойства Auth
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "auth.jwt")
public class AuthProperties {
    /**
     * Секрет для генерации токена
     */
    private String secret;
    /**
     * Время истечения токена
     */
    private Long expiration;
}
