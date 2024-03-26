package ru.real.backend.domain.model.apartment.parametr;

import lombok.*;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Отделка потолка
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APART_CEILING_DECORATION")
public class CeilingDecoration extends BaseEntity {
    /**
     * Наименование отделки
     */
    @Column(name = "NAME")
    private String name;
}
