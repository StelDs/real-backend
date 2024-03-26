package ru.real.backend.domain.model.apartment.parametr;

import lombok.*;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Меблировка
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APART_FURNITURE")
public class Furniture extends BaseEntity {
    /**
     * Наименование меблировки
     */
    @Column(name = "NAME")
    private String name;
}
