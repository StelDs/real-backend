package ru.real.backend.core.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.jetbrains.annotations.NotNull;
import ru.real.backend.api.dto.ApartmentParserDto;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public abstract class DefaultParser<File, Dto> {
    public abstract List<Dto> parse(File file);

    protected abstract ApartmentParserDto getApartment(@NotNull Row row);

    protected abstract String getStringValue(Cell cell);

    protected abstract Integer getIntegerValue(Cell cell);

    protected abstract Long getLongValue(Cell cell);

    protected abstract Double getDoubleValue(Cell cell);

    protected abstract Boolean getBooleanValue(Cell cell);

    protected abstract LocalDate getDateValue(Cell cell);
}
