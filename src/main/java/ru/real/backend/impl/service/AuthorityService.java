package ru.real.backend.impl.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.real.backend.api.dto.apartment.DictionaryDto;
import ru.real.backend.api.search.DictionarySearchDto;
import ru.real.backend.core.exception.DataNotFoundException;
import ru.real.backend.core.util.SpecificationUtils;
import ru.real.backend.domain.model.user.Authority;
import ru.real.backend.impl.mapper.AuthorityMapper;
import ru.real.backend.impl.repository.AuthorityRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityRepository repository;
    private final AuthorityMapper mapper;


    public DictionaryDto findById(UUID id) {
        return mapper.convertToDto(repository.findById(id).orElseThrow(() -> new DataNotFoundException(
                "authority.type.not.found",
                "Данные не найдены",
                String.format("Authority с id: %s не найден!", id)
        )));
    }

    public DictionaryDto save(@NotNull DictionaryDto dto) {
        AtomicReference<DictionaryDto> toReturn = new AtomicReference<>();
        repository.findByName(dto.getName()).ifPresentOrElse(it -> toReturn.set(mapper.convertToDto(it)), () -> {
            Authority toSave = mapper.convertToEntity(dto);
            toSave.setId(UUID.randomUUID());
            toReturn.set(mapper.convertToDto(repository.save(toSave)));
        });
        return toReturn.get();
    }

    public DictionaryDto update(@NotNull DictionaryDto dto) {
        return mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Page<DictionaryDto> findAll(DictionarySearchDto filter, Pageable pageable) {
        return repository.findAll(getSpecification(filter), pageable)
                .map(mapper::convertToDto);
    }

    public List<DictionaryDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    private Specification<Authority> getSpecification(DictionarySearchDto filter) {
        if (Objects.isNull(filter))
            return SpecificationUtils.emptySpecification();

        return SpecificationUtils.like("name", filter.getName(), true);
    }
}
