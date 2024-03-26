package ru.real.backend.domain.model.apartment.parametr;

import lombok.*;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Планировка
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APART_LAYOUT")
public class Layout extends BaseEntity {
    /**
     * Наименование планировки
     */
    @Column(name = "NAME")
    private String name;
}
