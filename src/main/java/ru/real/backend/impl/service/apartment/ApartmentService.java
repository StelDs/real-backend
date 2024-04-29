package ru.real.backend.impl.service.apartment;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.*;
import ru.real.backend.api.search.ApartmentSearchDto;
import ru.real.backend.core.exception.DataNotFoundException;
import ru.real.backend.core.util.SpecificationUtils;
import ru.real.backend.domain.model.apartment.Apartment;
import ru.real.backend.impl.mapper.ApartmentFullMapper;
import ru.real.backend.impl.mapper.ApartmentMapper;
import ru.real.backend.impl.mapper.ApartmentShortMapper;
import ru.real.backend.impl.mapper.ApartmentParserMapper;
import ru.real.backend.impl.repository.ApartmentRepository;
import ru.real.backend.impl.util.ApartmentExcelParser;
import ru.real.backend.impl.util.PreferenceScoreCalculator;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository repository;
    private final ApartmentParserMapper parserMapper;
    private final ApartmentShortMapper shortMapper;

    private final ApartmentMapper apartMapper;
    private final ApartmentFullMapper fullMapper;
    private final ApartmentExcelParser excelParser;
    private final PreferenceScoreCalculator calculator;


    public ApartmentShortDto findById(UUID id) {
        return shortMapper.convertToDto(repository.findById(id).orElseThrow(() -> new DataNotFoundException(
                "apartment.not.found", "Data not found", String.format("Apartment с id %s не найден", id))));
    }

    public ApartmentFullDto findByIdFull(UUID id) {
        Apartment apartment = repository.findById(id).orElseThrow(() ->
                new DataNotFoundException(
                        "apartment.not.found",
                        "Data not found",
                        String.format("Apartment с id %s не найден", id)
                )
        );


        return fullMapper.convertToDto(apartment);

    }

    public ApartmentShortDto save(ApartmentShortDto dto) {
        Apartment apartment = shortMapper.convertToEntity(dto);
        apartment.setId(UUID.randomUUID());
        apartment.setDateTimeCreated(ZonedDateTime.now());
        return shortMapper.convertToDto(repository.save(apartment));
    }


    public ApartmentShortDto save(@NotNull Apartment dto) {
        AtomicReference<ApartmentShortDto> toReturn = new AtomicReference<>();
        repository.findByExternalId(dto.getExternalId()).ifPresentOrElse(it -> toReturn.set(shortMapper.convertToDto(it)), () -> {
            dto.setId(UUID.randomUUID());
            dto.setDateTimeCreated(ZonedDateTime.now());
            toReturn.set(shortMapper.convertToDto(repository.save(dto)));
        });
        return toReturn.get();
    }


    public ApartmentDto save(@NotNull Apartment dto, String status) {
        ApartmentDto toReturn = null;

        if (status.equals("ok")) {
            Optional<Apartment> existingEntity = repository.findByExternalId(dto.getExternalId());

            if (existingEntity.isPresent()) {
                toReturn = apartMapper.convertToDto(existingEntity.get());
                toReturn.setStatus("Warning");
                toReturn.setInfo("Объект  уже сушествует в базе.");
            } else {
                dto.setId(UUID.randomUUID());
                dto.setDateTimeCreated(ZonedDateTime.now());
                toReturn = apartMapper.convertToDto(repository.save(dto));
                toReturn.setInfo("Объект добавлен в базу.");
                toReturn.setStatus("Ok");
            }
        } else {
            toReturn = ApartmentDto.builder().status("Error").info("Не хватает ключевых полей.").build();
        }


        return toReturn;
    }

    public ApartmentShortDto update(ApartmentShortDto dto) {
        return shortMapper.convertToDto(repository.save(shortMapper.convertToEntity(dto)));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Page<ApartmentShortDto> findAll(ApartmentSearchDto filter, Pageable pageable) {
        return repository.findAll(getSpecification(filter), pageable)
                .map(shortMapper::convertToDto);
    }

//    public List<ApartmentShortDto> parseAndSave(MultipartFile file) {
//        return excelParser.parse(file).stream()
//                .map(parserMapper::convertToEntity)
//                .map(this::save)
//                .collect(Collectors.toList());
//    }


    public List<ApartmentDto> parseAndSave(MultipartFile file) {
        List<ApartmentParserDto> parsedList = excelParser.parse(file);
        List<ApartmentDto> savedList = new ArrayList<>();

        for (ApartmentParserDto model : parsedList) {

            Apartment entity = parserMapper.convertToEntity(model);
            ApartmentDto savedDto = save(entity, model.getStatusParse());
            savedList.add(savedDto);

        }


        return savedList;
    }


    public Page<ApartmentShortDto> smartSearch(ApartmentSmartSearchDto filter, @NotNull Pageable pageable) {
        List<ApartmentShortDto> allItems = calculator.calculate(repository.findAll(), filter);
        List<ApartmentShortDto> toPage = allItems.stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .collect(Collectors.toList());
        return new PageImpl<>(toPage, pageable, allItems.size());
    }

    private Specification<Apartment> getSpecification(ApartmentSearchDto filter) {
        if (Objects.isNull(filter))
            return SpecificationUtils.emptySpecification();
        return SpecificationUtils.<Apartment, String>like("address", filter.getAddress(), true);
    }
}
