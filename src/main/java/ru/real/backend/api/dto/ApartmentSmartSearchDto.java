package ru.real.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentSmartSearchDto {
    //Количество комнат
    private List<Integer> quantityRooms;
    private List<Boolean> isEuro;

    //Цена объекта
    private List<Double> price;
    private Double priceWeight;

    //Количество квартир на этаже
    private List<Integer> countOfApartmentsFerFloor;
    private Double countOfApartmentsFerWeight;

    //Ипотека

    //Цена за м²
    private List<Double> squarePrice;
    private Double squarePriceWeight;

    //Площадь общая
    private List<Double> square;
    private Double squareWeight;

    //Площадь жилая
    private List<Double> residentialSquare;
    private Double residentialSquareWeight;

    //Площадь кухни или Площадь кухни-гостиной
    private List<Double> squareKitchen;
    private Double squareKitchenWeight;

    //Этаж
    private List<Integer> floor;
    private Double floorWeight;
    private Boolean isLastFloor;
    private Boolean isNotFirstFloor;
    private Boolean isNotLastFloor;

    //Этажей в доме
    private List<Double> countFloor;
    private Double countFloorWeight;

    //Тип жилья
    private List<String> apartmentType;
    private Double apartmentTypeWeight;

    //Планировка

    //Способ продажи
    private List<String> saleType;
    private Double saleTypeWeight;

    //Срок сдачи

    //Отделка
    private List<String> repair;
    private Double repairWeight;

    //Материал покрытия пола
    //Отделка стен
    //Отделка потолка
    //Меблировка

    //Балкон или лоджия
    private Boolean isBalcony;
    private Boolean isInsulatedBalcony;
    private Boolean isLoggia;
    private Double balconyWeight;

    //Высота потолков
    private List<Double> ceilingHeight;
    private Double ceilingHeightWeight;

    //Санузел
    //Отделка санузла
    //Окна

    //Тип дома
    private List<String> houseType;
    private Double houseTypeWeight;

    //Умный дом
    private List<Boolean> isSmartHome;
    private Double isSmartHomeWeight;


}
