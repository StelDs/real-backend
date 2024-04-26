package ru.real.backend.impl.repository;

import ru.real.backend.api.dto.ApartmentPicHrefDto;

import java.util.Optional;

public interface JdbcApartmentRepository {

   Optional<ApartmentPicHrefDto> findById(Long externalId);

}
