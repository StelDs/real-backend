package ru.real.backend.domain.model.apartment.parametr;

import lombok.*;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Тип жилья
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APART_APARTMENT_TYPE")
public class ApartmentType extends BaseEntity {
    /**
     * Наименование типа жилья
     */
    @Column(name = "NAME")
    private String name;
}
