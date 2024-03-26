package ru.real.backend.domain.model.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Разрешения/полномочия
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SEC_AUTHORITY")
public class Authority extends BaseEntity implements GrantedAuthority {
    /**
     * Наименование разрешения/полномочия
     */
    @Column(name = "NAME")
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
