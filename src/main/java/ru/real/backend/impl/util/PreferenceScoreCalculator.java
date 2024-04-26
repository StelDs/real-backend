package ru.real.backend.impl.util;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.real.backend.api.dto.ApartmentShortDto;
import ru.real.backend.api.dto.ApartmentSmartSearchDto;
import ru.real.backend.domain.model.apartment.Apartment;
import ru.real.backend.impl.mapper.ApartmentShortMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PreferenceScoreCalculator {
    private final ApartmentShortMapper apartmentShortMapper;
    private static final int MIN_BORDER = -1;
    private static final int MAX_BORDER = 1_000_000_000;

    /**
     * Расчёт процента для списка квартир
     *
     * @param apartments список квартир
     * @param searchDto  фильтры
     * @return dto с расчётом
     */
    public List<ApartmentShortDto> calculate(@NotNull List<Apartment> apartments, @NotNull ApartmentSmartSearchDto searchDto) {
        return apartments.parallelStream()
                .map(apartment -> {
                    ApartmentShortDto dto = apartmentShortMapper.convertToDto(apartment);
                    dto.setPercent(calculate(apartment, searchDto));
                    return dto;
                })
                //.filter(dto -> dto.getPercent() > 50)
                .collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparing(ApartmentShortDto::getPercent).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Расчёт процента для квартиры
     *
     * @param apartment квартира
     * @param searchDto фильтры
     * @return процент
     */
    private Integer calculate(@NotNull Apartment apartment, @NotNull ApartmentSmartSearchDto searchDto) {
        int weightCount = 0;
        double weightSum = 0;
        double sum = 0;

        //Количество комнат
        if (searchDto.getQuantityRooms() != null && !searchDto.getQuantityRooms().isEmpty()) {
            sum += matchQuantityRooms(apartment, searchDto);
            weightSum += 1;
            weightCount++;
        }

        //Цена объекта
        if (searchDto.getPrice() != null && !searchDto.getPrice().isEmpty()) {
            if (apartment.getPrice() != null)
                sum += matchDegree(searchDto.getPrice().get(0),
                        searchDto.getPrice().get(1),
                        searchDto.getPrice().get(2),
                        apartment.getPrice()) * searchDto.getPriceWeight();
            weightSum += searchDto.getPriceWeight();
            weightCount++;
        }

        //Количество квартир на этаже
        if (searchDto.getCountOfApartmentsFerFloor() != null && !searchDto.getCountOfApartmentsFerFloor().isEmpty()) {
            if (apartment.getCountOfApartmentsFerFloor() != null)
                sum += matchDegree(searchDto.getCountOfApartmentsFerFloor().get(0),
                        searchDto.getCountOfApartmentsFerFloor().get(1),
                        searchDto.getCountOfApartmentsFerFloor().get(2),
                        apartment.getCountOfApartmentsFerFloor()) * searchDto.getCountOfApartmentsFerWeight();
            weightSum += searchDto.getCountOfApartmentsFerWeight();
            weightCount++;
        }

        //Цена за м²
        if (searchDto.getSquarePrice() != null && !searchDto.getSquarePrice().isEmpty()) {
            if (apartment.getSquarePrice() != null)
                sum += matchDegree(searchDto.getSquarePrice().get(0),
                        searchDto.getSquarePrice().get(1),
                        searchDto.getSquarePrice().get(2),
                        apartment.getSquarePrice()) * searchDto.getSquarePriceWeight();
            weightSum += searchDto.getSquarePriceWeight();
            weightCount++;
        }

        //Площадь общая
        if (searchDto.getSquare() != null && !searchDto.getSquare().isEmpty()) {
            if (apartment.getSquare() != null)
                sum += matchDegree(searchDto.getSquare().get(0),
                        searchDto.getSquare().get(1),
                        searchDto.getSquare().get(2),
                        apartment.getSquare()) * searchDto.getSquareWeight();
            weightSum += searchDto.getSquareWeight();
            weightCount++;
        }

        //Площадь жилая
        if (searchDto.getResidentialSquare() != null && !searchDto.getResidentialSquare().isEmpty()) {
            if (apartment.getResidentialSquare() != null)
                sum += matchDegree(searchDto.getResidentialSquare().get(0),
                        searchDto.getResidentialSquare().get(1),
                        searchDto.getResidentialSquare().get(2),
                        apartment.getResidentialSquare()) * searchDto.getResidentialSquareWeight();
            weightSum += searchDto.getResidentialSquareWeight();
            weightCount++;
        }

        //Площадь кухни или Площадь кухни-гостиной
        if (searchDto.getSquareKitchen() != null && !searchDto.getSquareKitchen().isEmpty()) {
            if (apartment.getSquareKitchen() != null)
                sum += matchDegree(searchDto.getSquareKitchen().get(0),
                        searchDto.getSquareKitchen().get(1),
                        searchDto.getSquareKitchen().get(2),
                        apartment.getSquareKitchen()) * searchDto.getSquareKitchenWeight();
            if (apartment.getSquareKitchenLivingRoom() != null)
                sum += matchDegree(searchDto.getSquareKitchen().get(0),
                        searchDto.getSquareKitchen().get(1),
                        searchDto.getSquareKitchen().get(2),
                        apartment.getSquareKitchenLivingRoom()) * searchDto.getSquareKitchenWeight();
            weightSum += searchDto.getSquareKitchenWeight();
            weightCount++;
        }

        //Этаж
        if (searchDto.getFloor() != null && !searchDto.getFloor().isEmpty()) {
            if (apartment.getFloor() != null)
                sum += matchDegree(searchDto.getFloor().get(0),
                        searchDto.getFloor().get(1),
                        searchDto.getFloor().get(2),
                        apartment.getFloor()) * searchDto.getFloorWeight();
            weightSum += searchDto.getFloorWeight();
            weightCount++;
        }

        //Этажей в доме
        if (searchDto.getCountFloor() != null && !searchDto.getCountFloor().isEmpty()) {
            if (apartment.getCountFloor() != null)
                sum += matchDegree(searchDto.getCountFloor().get(0),
                        searchDto.getCountFloor().get(1),
                        searchDto.getCountFloor().get(2),
                        apartment.getCountFloor()) * searchDto.getCountFloorWeight();
            weightSum += searchDto.getCountFloorWeight();
            weightCount++;
        }

        //Тип жилья
        if (searchDto.getApartmentType() != null && !searchDto.getApartmentType().isEmpty()) {
            if (apartment.getApartmentType() != null)
                sum += matchString(searchDto.getApartmentType(), apartment.getApartmentType()) * searchDto.getApartmentTypeWeight();
            weightSum += searchDto.getApartmentTypeWeight();
            weightCount++;
        }

        //Способ продажи
        if (searchDto.getSaleType() != null && !searchDto.getSaleType().isEmpty()) {
            if (apartment.getSaleType() != null)
                sum += matchString(searchDto.getSaleType(), apartment.getSaleType()) * searchDto.getSaleTypeWeight();
            weightSum += searchDto.getSaleTypeWeight();
            weightCount++;
        }

        //Отделка
        if (searchDto.getRepair() != null && !searchDto.getRepair().isEmpty()) {
            if (apartment.getRepairType() != null)
                sum += matchString(searchDto.getRepair(), apartment.getRepairType()) * searchDto.getRepairWeight();
            weightSum += searchDto.getRepairWeight();
            weightCount++;
        }

        //Балкон или лоджия
        if (searchDto.getIsBalcony().equals(true)) {
            if (apartment.getSquareBalcony() != null || apartment.getSquareBalcony2() != null) {
                sum += 1.0 * searchDto.getBalconyWeight();
                weightSum += searchDto.getBalconyWeight();
                weightCount++;
            }
        } else if (searchDto.getIsLoggia().equals(true)) {
            if (apartment.getSquareLoggia() != null || apartment.getSquareLoggia2() != null || apartment.getSquareLoggia3() != null) {
                sum += 1.0 * searchDto.getBalconyWeight();
                weightSum += searchDto.getBalconyWeight();
                weightCount++;
            }
        } else {
            sum += 0.0 * searchDto.getBalconyWeight();
            weightSum += searchDto.getBalconyWeight();
            weightCount++;
        }

        //Высота потолков
        if (searchDto.getCeilingHeight() != null && !searchDto.getCeilingHeight().isEmpty()) {
            sum += matchCeilingHeight(apartment, searchDto.getCeilingHeight()) * searchDto.getBalconyWeight();
            weightSum += searchDto.getBalconyWeight();
            weightCount++;
        }

        //Тип дома
        if (searchDto.getHouseType() != null && !searchDto.getHouseType().isEmpty()) {
            if (apartment.getHouseType() != null)
                sum += matchString(searchDto.getHouseType(), apartment.getHouseType()) * searchDto.getHouseTypeWeight();
            weightSum += searchDto.getHouseTypeWeight();
            weightCount++;
        }

        if (searchDto.getIsSmartHome() != null && !searchDto.getIsSmartHome().isEmpty()) {
            if (searchDto.getIsSmartHome().contains(apartment.getIsSmartHome())) {
                sum = 1.0 * searchDto.getIsSmartHomeWeight();
            }
            weightSum += searchDto.getIsSmartHomeWeight();
            weightCount++;
        }

        return (int) (sum / weightSum * 100);
    }

    /**
     * @param min        нижняя граница диапазона значений
     * @param preference наиболее предпочтительное значение
     * @param max        верхняя граница диапазона значений
     * @param value
     * @return
     */
    private double matchDegree(double min, double preference, double max, double value) {
        if (max > min) {
            if ((min >= MIN_BORDER) && (max <= MAX_BORDER)) {
                if ((min < value) && (preference >= value)) {
                    return (value - min) / (preference - min);
                } else if ((preference <= value) && (max > value)) {
                    return (max - value) / (max - preference);
                }
            }
            return 0.0;
        } else if ((min == 0) && (max == 0) && (preference == value)) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    private Double matchQuantityRooms(@NotNull Apartment apartment, ApartmentSmartSearchDto searchDto) {
        if (apartment.getQuantityRooms() != null)
            for (int i = 0; i < searchDto.getQuantityRooms().size(); i++) {
                if (searchDto.getQuantityRooms().get(i).equals(apartment.getQuantityRooms()))
                    if (searchDto.getIsEuro().get(i).equals(apartment.getIsEuro() == null ? false : apartment.getIsEuro()))
                        return 1.0;
            }
        return 0.0;
    }

    private Double matchString(@NotNull List<String> list, String value) {
        if (list.contains(value))
            return 1.0;
        return 0.0;
    }

    private Double matchCeilingHeight(@NotNull Apartment apartment, List<Double> ceilingHeight) {
        if (apartment.getCeilingHeight() == null)
            return 0.0;

        for (Double val : ceilingHeight) {
            if (val == 2.69) {
                if (apartment.getCeilingHeight() <= 2.7)
                    return 1.0;
            } else if (val == 2.7) {
                if (apartment.getCeilingHeight() > 2.7)
                    return 1.0;
            } else if (val == 3.0) {
                if (apartment.getCeilingHeight() >= 3)
                    return 1.0;
            } else if (val == 3.5) {
                if (apartment.getCeilingHeight() >= 3.5)
                    return 1.0;
            }
        }
        return 0.0;
    }
}
