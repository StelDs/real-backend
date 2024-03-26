package ru.real.backend.impl.service.apartment;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.ApartmentShortDto;
import ru.real.backend.api.search.ApartmentSearchDto;
import ru.real.backend.core.exception.DataNotFoundException;
import ru.real.backend.core.util.SpecificationUtils;
import ru.real.backend.domain.model.apartment.Apartment;
import ru.real.backend.impl.mapper.ApartmentMapper;
import ru.real.backend.impl.mapper.ApartmentParserMapper;
import ru.real.backend.impl.repository.ApartmentRepository;
import ru.real.backend.impl.util.ApartmentExcelParser;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository repository;
    private final ApartmentParserMapper parserMapper;
    private final ApartmentMapper mapper;
    private final ApartmentExcelParser excelParser;

    public ApartmentShortDto findById(UUID id) {
        return mapper.convertToDto(repository.findById(id).orElseThrow(() -> new DataNotFoundException(
                "apartment.not.found", "Data not found", String.format("Apartment с id %s не найден", id))));
    }

    public ApartmentShortDto save(ApartmentShortDto dto) {
        Apartment apartment = mapper.convertToEntity(dto);
        apartment.setId(UUID.randomUUID());
        apartment.setDateTimeCreated(ZonedDateTime.now());
        return mapper.convertToDto(repository.save(apartment));
    }

    public ApartmentShortDto save(@NotNull Apartment dto) {
        AtomicReference<ApartmentShortDto> toReturn = new AtomicReference<>();
        repository.findByExternalId(dto.getExternalId()).ifPresentOrElse(it -> toReturn.set(mapper.convertToDto(it)), () -> {
            dto.setId(UUID.randomUUID());
            dto.setDateTimeCreated(ZonedDateTime.now());
            toReturn.set(mapper.convertToDto(repository.save(dto)));
        });
        return toReturn.get();
    }

    public ApartmentShortDto update(ApartmentShortDto dto) {
        return mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Page<ApartmentShortDto> findAll(ApartmentSearchDto filter, Pageable pageable) {
        return repository.findAll(getSpecification(filter), pageable)
                .map(mapper::convertToDto);
    }

    public List<ApartmentShortDto> parseAndSave(MultipartFile file) {
        return excelParser.parse(file).stream()
                .map(parserMapper::convertToEntity)
                .map(this::save)
                .collect(Collectors.toList());
    }

    private Specification<Apartment> getSpecification(ApartmentSearchDto filter) {
        if (Objects.isNull(filter))
            return SpecificationUtils.emptySpecification();
//
        return SpecificationUtils.<Apartment, String>like("address", filter.getAddress(), true);
    }
}
