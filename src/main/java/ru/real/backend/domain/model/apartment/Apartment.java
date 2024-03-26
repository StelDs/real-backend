package ru.real.backend.domain.model.apartment;

import lombok.*;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Апартаменты
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APARTMENT")
public class Apartment extends BaseEntity {
    /**
     * Внешний ID
     */
    @Column(name = "EXTERNAL_ID")
    private Long externalId;

    /**
     * Внешний UUID
     */
    @Column(name = "EXTERNAL_UUID")
    private String externalUuid;

    /**
     * Номер квартиры
     */
    @Column(name = "APARTMENT_NUMBER", columnDefinition = "int2")
    private Integer apartmentNumber;

    /**
     * Почтовый номер
     */
    @Column(name = "POSTAL_NUMBER")
    private String postalNumber;

    /**
     * Общий номер лота
     */
    @Column(name = "GENERAL_LOT_NUMBER")
    private String generalLotNumber;

    /**
     * Количество комнат
     */
    @Column(name = "QUANTITY_ROOMS", columnDefinition = "int2")
    private Integer quantityRooms;

    /**
     * Студия/Евро (Да/Нет)
     */
    @Column(name = "IS_EURO")
    private Boolean isEuro;

    /**
     * Подъезд
     */
    @Column(name = "ENTRANCE", columnDefinition = "int2")
    private Integer entrance;

    /**
     * Секция
     */
    @Column(name = "SECTION", columnDefinition = "int2")
    private Integer section;

    /**
     * Этаж
     */
    @Column(name = "FLOOR", columnDefinition = "int2")
    private Integer floor;

    /**
     * Номер стояка
     * FIXME: type
     */
    @Column(name = "RISER_NUMBER")
    private String riserNumber;

    /**
     * Стороны света стояка
     * FIXME: type
     */
    @Column(name = "RISER_CARDINAL_DIRECTIONS")
    private String riserCardinalDirections;

    /**
     * Группа планировки
     */
    @Column(name = "PLANNING_GROUP")
    private String planningGroup;

    /**
     * Код планировки
     */
    @Column(name = "PLANNING_CODE")
    private String planningCode;

    /**
     * Класс квартиры
     */
    @Column(name = "APARTMENT_CLASS")
    private String apartmentClass;

    /**
     * Площадь общая, м²
     */
    @Column(name = "SQUARE", columnDefinition = "float8")
    private Double square;

    /**
     * Полная площадь, м²
     */
    @Column(name = "SQUARE_FULL", columnDefinition = "float8")
    private Double squareFull;

    /**
     * Цена объекта, ₽
     */
    @Column(name = "PRICE", columnDefinition = "float8")
    private Double price;

    /**
     * Предыдущая цена, ₽
     */
    @Column(name = "PREVIOUS_PRICE", columnDefinition = "float8")
    private Double previousPrice;

    /**
     * Юридическая цена, ₽
     */
    @Column(name = "LEGAL_PRICE", columnDefinition = "float8")
    private Double legalPrice;

    /**
     * Цена за м², ₽
     */
    @Column(name = "SQUARE_PRICE", columnDefinition = "float8")
    private Double squarePrice;

    /**
     * Цена по специальному предложению
     */
    @Column(name = "SPECIAL_OFFER_PRICE", columnDefinition = "float8")
    private Double specialOfferPrice;

    /**
     * Произвольная цена 1
     */
    @Column(name = "ARBITRARY_PRICE", columnDefinition = "float8")
    private Double arbitraryPrice;

    /**
     * Произвольная цена 2
     */
    @Column(name = "ARBITRARY_PRICE_2", columnDefinition = "float8")
    private Double arbitraryPrice2;

    /**
     * Произвольная цена 3
     */
    @Column(name = "ARBITRARY_PRICE_3", columnDefinition = "float8")
    private Double arbitraryPrice3;

    /**
     * Залоговая стоимость
     */
    @Column(name = "COLLATERAL_PRICE", columnDefinition = "float8")
    private Double collateralPrice;

    /**
     * Оценочная стоимость
     */
    @Column(name = "ESTIMATED_PRICE", columnDefinition = "float8")
    private Double estimatedPrice;

    /**
     * Статус
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * Горячее предложение
     */
    @Column(name = "IS_HOT_OFFER")
    private Boolean isHotOffer;

    /**
     * Теги
     */
    @Column(name = "TAGS")
    private String tags;

    /**
     * Код объекта
     */
    @Column(name = "OBJECT_CODE")
    private String objectCode;

    /**
     * Апартаменты?
     */
    @Column(name = "IS_APARTMENTS")
    private Boolean isApartments;

    /**
     * Пентхаус?
     */
    @Column(name = "IS_PENTHOUSE")
    private Boolean isPenthouse;

    /**
     * ID Контакта продавца
     */
    @Column(name = "SELLER_ID")
    private Long sellerId;

    /**
     * Код планировки для ДДУ
     */
    @Column(name = "PLANNING_CODE_DDY")
    private String planningCodeDDY;

    /**
     * Площадь БТИ, м²
     */
    @Column(name = "SQUARE_BTI", columnDefinition = "float8")
    private Double squareBTI;

    /**
     * Площадь БТИ (коэффициент.), м²
     */
    @Column(name = "SQUARE_COEFFICIENT_BTI", columnDefinition = "float8")
    private Double squareCoefficientBTI;

    /**
     * Площадь БТИ без ЛП, м²
     */
    @Column(name = "SQUARE_BTI_WITHOUT_LP", columnDefinition = "float8")
    private Double squareBTIWithoutLP;

    /**
     * Площадь жилая БТИ, м²
     */
    @Column(name = "RESIDENTIAL_SQUARE_BTI", columnDefinition = "float8")
    private Double residentialSquareBTI;

    /**
     * Площадь лоджии БТИ, м²
     */
    @Column(name = "SQUARE_LOGGIA_BTI", columnDefinition = "float8")
    private Double squareLoggiaBTI;

    /**
     * Площадь балкона БТИ, м²
     */
    @Column(name = "SQUARE_BALCONY_BTI", columnDefinition = "float8")
    private Double squareBalconyBTI;

    /**
     * Площадь для ДДУ, м²
     */
    @Column(name = "SQUARE_DDY", columnDefinition = "float8")
    private Double squareDDY;

    /**
     * Площадь без ЛП, м²
     */
    @Column(name = "SQUARE_WITHOUT_LP", columnDefinition = "float8")
    private Double squareWithoutLP;

    /**
     * Приведенная площадь, м²
     */
    @Column(name = "SQUARE_REDUCED", columnDefinition = "float8")
    private Double squareReduced;

    /**
     * Площадь проектная, м²
     */
    @Column(name = "SQUARE_PROJECT", columnDefinition = "float8")
    private Double squareProject;

    /**
     * Произвольная площадь 1, м²
     */
    @Column(name = "SQUARE_ARBITRARY", columnDefinition = "float8")
    private Double squareArbitrary;

    /**
     * Произвольная площадь 2, м²
     */
    @Column(name = "SQUARE_ARBITRARY_2", columnDefinition = "float8")
    private Double squareArbitrary2;

    /**
     * Произвольная площадь 3, м²
     */
    @Column(name = "SQUARE_ARBITRARY_3", columnDefinition = "float8")
    private Double squareArbitrary3;

    /**
     * Площадь жилая, м²
     */
    @Column(name = "RESIDENTIAL_SQUARE", columnDefinition = "float8")
    private Double residentialSquare;

    /**
     * Площадь комнаты 1, м²
     */
    @Column(name = "SQUARE_ROOM", columnDefinition = "float8")
    private Double squareRoom;

    /**
     * Площадь комнаты 2, м²
     */
    @Column(name = "SQUARE_ROOM_2", columnDefinition = "float8")
    private Double squareRoom2;

    /**
     * Площадь комнаты 3, м²
     */
    @Column(name = "SQUARE_ROOM_3", columnDefinition = "float8")
    private Double squareRoom3;

    /**
     * Площадь комнаты 4, м²
     */
    @Column(name = "SQUARE_ROOM_4", columnDefinition = "float8")
    private Double squareRoom4;

    /**
     * Площадь кухни, м²
     */
    @Column(name = "SQUARE_KITCHEN", columnDefinition = "float8")
    private Double squareKitchen;

    /**
     * Площадь кухни-гостиной, м²
     */
    @Column(name = "SQUARE_KITCHEN_LIVING_ROOM", columnDefinition = "float8")
    private Double squareKitchenLivingRoom;

    /**
     * Площадь гостиной, м²
     */
    @Column(name = "SQUARE_LIVING_ROOM", columnDefinition = "float8")
    private Double squareLivingRoom;

    /**
     * Площадь спальни 1, м²
     */
    @Column(name = "SQUARE_BEDROOM", columnDefinition = "float8")
    private Double squareBedroomRoom;

    /**
     * Площадь спальни 2, м²
     */
    @Column(name = "SQUARE_BEDROOM_2", columnDefinition = "float8")
    private Double squareBedroomRoom2;

    /**
     * Площадь спальни 3, м²
     */
    @Column(name = "SQUARE_BEDROOM_3", columnDefinition = "float8")
    private Double squareBedroomRoom3;

    /**
     * Площадь спальни 4, м²
     */
    @Column(name = "SQUARE_BEDROOM_4", columnDefinition = "float8")
    private Double squareBedroomRoom4;

    /**
     * Площадь гардероба 1, м²
     */
    @Column(name = "SQUARE_WARDROBE", columnDefinition = "float8")
    private Double squareWardrobe;

    /**
     * Площадь гардероба 2, м²
     */
    @Column(name = "SQUARE_WARDROBE_2", columnDefinition = "float8")
    private Double squareWardrobe2;

    /**
     * Площадь гардероба 3, м²
     */
    @Column(name = "SQUARE_WARDROBE_3", columnDefinition = "float8")
    private Double squareWardrobe3;

    /**
     * Площадь прихожей/коридора, м²
     */
    @Column(name = "SQUARE_HALLWAY", columnDefinition = "float8")
    private Double squareHallway;

    /**
     * Санузел
     */
    @Column(name = "BATHROOM")
    private String bathroom;

    /**
     * Площадь санузла, м²
     */
    @Column(name = "SQUARE_BATHROOM", columnDefinition = "float8")
    private Double squareBathroom;

    /**
     * Площадь санузла 2, м²
     */
    @Column(name = "SQUARE_BATHROOM_2", columnDefinition = "float8")
    private Double squareBathroom2;

    /**
     * Площадь санузла 3, м²
     */
    @Column(name = "SQUARE_BATHROOM_3", columnDefinition = "float8")
    private Double squareBathroom3;

    /**
     * Площадь лоджии 1, м²
     */
    @Column(name = "SQUARE_LOGGIA", columnDefinition = "float8")
    private Double squareLoggia;

    /**
     * Площадь лоджии 1 (произвольная), м²
     */
    @Column(name = "SQUARE_LOGGIA_ARBITRARY", columnDefinition = "float8")
    private Double squareLoggiaArbitrary;

    /**
     * Площадь лоджии 2, м²
     */
    @Column(name = "SQUARE_LOGGIA_2", columnDefinition = "float8")
    private Double squareLoggia2;

    /**
     * Площадь лоджии 2 (произвольная), м²
     */
    @Column(name = "SQUARE_LOGGIA_ARBITRARY_2", columnDefinition = "float8")
    private Double squareLoggiaArbitrary2;

    /**
     * Площадь лоджии 3, м²
     */
    @Column(name = "SQUARE_LOGGIA_3", columnDefinition = "float8")
    private Double squareLoggia3;

    /**
     * Площадь лоджии 3 (произвольная), м²
     */
    @Column(name = "SQUARE_LOGGIA_ARBITRARY_3", columnDefinition = "float8")
    private Double squareLoggiaArbitrary3;

    /**
     * Площадь балкона 1, м²
     */
    @Column(name = "SQUARE_BALCONY", columnDefinition = "float8")
    private Double squareBalcony;

    /**
     * Площадь балкона 1 (произвольная), м²
     */
    @Column(name = "SQUARE_BALCONY_ARBITRARY", columnDefinition = "float8")
    private Double squareBalconyArbitrary;

    /**
     * Площадь балкона 2, м²
     */
    @Column(name = "SQUARE_BALCONY_2", columnDefinition = "float8")
    private Double squareBalcony2;

    /**
     * Площадь балкона 2 (произвольная), м²
     */
    @Column(name = "SQUARE_BALCONY_ARBITRARY_2", columnDefinition = "float8")
    private Double squareBalconyArbitrary2;

    /**
     * Высота ограждения балкона
     */
    @Column(name = "BALCONY_FENCE_HEIGHT", columnDefinition = "float8")
    private Double balconyFenceHeight;

    /**
     * Высота балкона
     */
    @Column(name = "BALCONY_HEIGHT", columnDefinition = "float8")
    private Double balconyHeight;

    /**
     * Площадь террасы 1, м²
     */
    @Column(name = "SQUARE_TERRACE", columnDefinition = "float8")
    private Double squareTerrace;

    /**
     * Площадь террасы 1 (произвольная), м²
     */
    @Column(name = "SQUARE_TERRACE_ARBITRARY", columnDefinition = "float8")
    private Double squareTerraceArbitrary;

    /**
     * Площадь террасы 2, м²
     */
    @Column(name = "SQUARE_TERRACE_2", columnDefinition = "float8")
    private Double squareTerrace2;

    /**
     * Площадь террасы 2 (произвольная), м²
     */
    @Column(name = "SQUARE_TERRACE_ARBITRARY_2", columnDefinition = "float8")
    private Double squareTerraceArbitrary2;

    /**
     * Площадь кладовки, м²
     */
    @Column(name = "SQUARE_PANTRY", columnDefinition = "float8")
    private Double squarePantry;

    /**
     * Площадь помещений вспомогательного назначения, м²
     */
    @Column(name = "SQUARE_AUXILIARY_PREMISES", columnDefinition = "float8")
    private Double squareAuxiliaryPremises;

    /**
     * Количество помещений вспомогательного назначения,
     */
    @Column(name = "AUXILIARY_PREMISES_COUNT", columnDefinition = "int2")
    private Integer auxiliaryPremisesCount;

    /**
     * Есть отделка?
     */
    @Column(name = "IS_REPAIR")
    private Boolean isRepair;

    /**
     * Вид отделки
     */
    @Column(name = "REPAIR_TYPE")
    private String repairType;

    /**
     * Качество отделки
     */
    @Column(name = "REPAIR_QUALITY")
    private String repairQuality;

    /**
     * Вид из окон
     */
    @Column(name = "WINDOWS_VIEW")
    private String windowsView;

    /**
     * Строительные оси
     * FIXME: type
     */
    @Column(name = "CONSTRUCTION_AXES")
    private String constructionAxes;

    /**
     * Высота потолка, м
     */
    @Column(name = "CEILING_HEIGHT")
    private Double ceilingHeight;

    /**
     * Кадастровый номер объекта
     */
    @Column(name = "CADASTRAL_NUMBER")
    private String cadastralNumber;

    /**
     * Сумма по договору-основания
     */
    @Column(name = "AGREEMENT_BASED_AMOUNT", columnDefinition = "float8")
    private Double agreementBasedAmount;

    /**
     * Площадь по договору-основания, м²
     */
    @Column(name = "AGREEMENT_BASED_SQUARE", columnDefinition = "float8")
    private Double agreementBasedSquare;

    /**
     * Предуст. номер договора
     */
    @Column(name = "PRE_INSTALLED_AGREEMENT_NUMBER")
    private String preInstalledAgreementNumber;

    /**
     * Предуст. номер договора-основания
     */
    @Column(name = "PRE_INSTALLED_BASED_AGREEMENT_NUMBER")
    private String preInstalledAgreementBasedNumber;

    /**
     * Предуст. дата договора-основания
     */
    @Column(name = "PRE_INSTALLED_BASED_AGREEMENT_DATE")
    private LocalDate preInstalledAgreementBasedDate;

    /**
     * Предустановленный контакт Договора-основания
     */
    @Column(name = "PRE_INSTALLED_BASED_AGREEMENT_CONTACT")
    private String preInstalledAgreementBasedContact;

    /**
     * Предуст. дата регистрации договора-основания
     */
    @Column(name = "PRE_INSTALLED_BASED_AGREEMENT_REGISTRATION_DATE")
    private LocalDate preInstalledAgreementBasedRegistrationDate;

    /**
     * Предуст. номер регистрации договора основания
     */
    @Column(name = "PRE_INSTALLED_BASED_AGREEMENT_REGISTRATION_NUMBER")
    private String preInstalledAgreementBasedRegistrationNumber;

    /**
     * Плановый график платежей по договору-основанию
     */
    @Column(name = "AGREEMENT_BASED_SCHEDULED_PAYMENT_SCHEDULE")
    private String agreementBasedScheduledPaymentSchedule;

    /**
     * Плановый график платежей по основному договору
     */
    @Column(name = "PRE_INSTALLED_AGREEMENT_REGISTRATION_NUMBER")
    private String agreementScheduledPaymentSchedule;

    /**
     * Депонированная сумма по договору-основанию
     */
    @Column(name = "AGREEMENT_BASED_DEPOSITED_AMOUNT")
    private String agreementBasedDepositedAmount;

    /**
     * Способ обеспечения
     */
    @Column(name = "PROVIDING_METHOD")
    private String providingMethod;

    /**
     * Дата окончания брони
     */
    @Column(name = "RESERVATION_END_DATE")
    private LocalDate reservationEndDate;

    /**
     * Служебные отметки
     */
    @Column(name = "SERVICE_MARKS")
    private String serviceMarks;

    /**
     * Произвольный текст 1
     */
    @Column(name = "CUSTOM_TEXT")
    private String customText;

    /**
     * Произвольный текст 2
     */
    @Column(name = "CUSTOM_TEXT_2")
    private String customText2;

    /**
     * Произвольный текст 3
     */
    @Column(name = "CUSTOM_TEXT_3")
    private String customText3;

    /**
     * Эксклюзив
     */
    @Column(name = "IS_EXCLUSIVE")
    private Boolean isExclusive;

    /**
     * Уровней
     */
    @Column(name = "LEVELS_COUNT", columnDefinition = "int2")
    private Integer levelsCount;

    /**
     * Тип комнат
     */
    @Column(name = "ROOMS_TYPE")
    private String roomsType;

    /**
     * Тип продажи
     */
    @Column(name = "SALE_TYPE")
    private String saleType;

    /**
     * Ссылка на виртуальный тур
     */
    @Column(name = "VIRTUAL_TOUR_LINK")
    private String virtualTourLink;

    /**
     * Комиссии агента, %
     */
    @Column(name = "AGENT_FEES")
    private Double agentFees;

    /**
     * Продающее название
     */
    @Column(name = "SELLING_NAME")
    private String sellingName;

    /**
     * Плановая дата готовности объекта к передаче
     */
    @Column(name = "READY_FOR_TRANSFER_OBJECT_PLANNED_DATE")
    private LocalDate readyForTransferObjectPlannedDate;

    /**
     * Фактическая дата готовности объекта к передаче
     */
    @Column(name = "READY_FOR_TRANSFER_OBJECT_ACTUAL_DATE")
    private LocalDate readyForTransferObjectActualDate;

    /**
     * Адрес объекта
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * Название планировки
     */
    @Column(name = "PLANNING_NAME")
    private String planningName;

    /**
     * Описание планировки
     */
    @Column(name = "PLANNING_DESCRIPTION")
    private String planningDescription;

    /**
     * СМАРТ-Планировка Да/Нет
     */
    @Column(name = "SMART_PLANNING")
    private Boolean smartPlanning;
    /**
     * Дата и время создания
     */
    @Column(name = "DATE_TIME_CREATED")
    private ZonedDateTime dateTimeCreated;
}
