package ru.real.backend.domain.model.apartment.parametr;

import lombok.*;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Материал покрытия пола
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APART_FLOOR_COVERING_MATERIAL")
public class FloorCoveringMaterial extends BaseEntity {
    /**
     * Наименование материала
     */
    @Column(name = "NAME")
    private String name;
}
