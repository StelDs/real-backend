package ru.real.backend.impl.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.real.backend.api.dto.ApartmentParserDto;
import ru.real.backend.core.util.DefaultParser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ApartmentExcelParser extends DefaultParser<MultipartFile, ApartmentParserDto> {
    private String address;

    @Override
    public List<ApartmentParserDto> parse(MultipartFile file) {
        List<ApartmentParserDto> apartments = new ArrayList<>();
        try (InputStream inputStream = new BufferedInputStream(file.getInputStream())) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            //Пропуск шапки
            rowIterator.next();


            while (rowIterator.hasNext()) {
                apartments.add(getApartment(rowIterator.next()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return apartments;
    }

    @Override
    protected ApartmentParserDto getApartment(@NotNull Row row) {
        ApartmentParserDto dto = ApartmentParserDto.builder()
                .externalId(getLongValue(row.getCell(0)))
                .apartmentNumber(getIntegerValue(row.getCell(1)))
                .postalNumber(getStringValue(row.getCell(2)))
                .generalLotNumber(getStringValue(row.getCell(3)))
                .quantityRooms(getIntegerValue(row.getCell(4)))
                .isEuro(getBooleanValue(row.getCell(5)))
                .entrance(getIntegerValue(row.getCell(6)))
                .section(getIntegerValue(row.getCell(7)))
                .floor(getIntegerValue(row.getCell(8)))
                .riserNumber(getStringValue(row.getCell(9)))
                .riserCardinalDirections(getStringValue(row.getCell(10)))
                .planningGroup(getStringValue(row.getCell(11)))
                .planningCode(getStringValue(row.getCell(12)))
                .apartmentClass(getStringValue(row.getCell(13)))
                .square(getDoubleValue(row.getCell(14)))
                .squarePrice(getDoubleValue(row.getCell(15)))
                .price(getDoubleValue(row.getCell(16)))
                .specialOfferPrice(getDoubleValue(row.getCell(17)))
                .status(getStringValue(row.getCell(18)))
                .isHotOffer(getBooleanValue(row.getCell(19)))
                .tags(getStringValue(row.getCell(20)))
                .externalUuid(getStringValue(row.getCell(21)))
                .objectCode(getStringValue(row.getCell(22)))
                .isApartments(getBooleanValue(row.getCell(23)))
                .isPenthouse(getBooleanValue(row.getCell(24)))
                .sellerId(getLongValue(row.getCell(25)))
                .planningCodeDDY(getStringValue(row.getCell(26)))
                .squareFull(getDoubleValue(row.getCell(27)))
                .squareBTI(getDoubleValue(row.getCell(28)))
                .squareCoefficientBTI(getDoubleValue(row.getCell(29)))
                .squareBTIWithoutLP(getDoubleValue(row.getCell(30)))
                .residentialSquareBTI(getDoubleValue(row.getCell(31)))
                .squareLoggiaBTI(getDoubleValue(row.getCell(32)))
                .squareBalconyBTI(getDoubleValue(row.getCell(33)))
                .previousPrice(getDoubleValue(row.getCell(34)))
                .legalPrice(getDoubleValue(row.getCell(35)))
                .isRepair(getBooleanValue(row.getCell(36)))
                .repairType(getStringValue(row.getCell(37)))
                .repairQuality(getStringValue(row.getCell(38)))
                .windowsView(getStringValue(row.getCell(39)))
                .squareDDY(getDoubleValue(row.getCell(40)))
                .constructionAxes(getStringValue(row.getCell(41)))
                .ceilingHeight(getDoubleValue(row.getCell(42)))
                .squareRoom(getDoubleValue(row.getCell(43)))
                .squareRoom2(getDoubleValue(row.getCell(44)))
                .squareRoom3(getDoubleValue(row.getCell(45)))
                .squareRoom4(getDoubleValue(row.getCell(46)))
                .residentialSquare(getDoubleValue(row.getCell(47)))
                .squareKitchen(getDoubleValue(row.getCell(48)))
                .squareKitchenLivingRoom(getDoubleValue(row.getCell(49)))
                .squareLivingRoom(getDoubleValue(row.getCell(50)))
                .squareBedroomRoom(getDoubleValue(row.getCell(51)))
                .squareBedroomRoom2(getDoubleValue(row.getCell(52)))
                .squareBedroomRoom3(getDoubleValue(row.getCell(53)))
                .squareBedroomRoom4(getDoubleValue(row.getCell(54)))
                .squareWardrobe(getDoubleValue(row.getCell(55)))
                .squareWardrobe2(getDoubleValue(row.getCell(56)))
                .squareWardrobe3(getDoubleValue(row.getCell(57)))
                .squareHallway(getDoubleValue(row.getCell(58)))
                .bathroom(getStringValue(row.getCell(59)))
                .squareBathroom(getDoubleValue(row.getCell(60)))
                .squareBathroom2(getDoubleValue(row.getCell(61)))
                .squareBathroom3(getDoubleValue(row.getCell(62)))
                .squareLoggia(getDoubleValue(row.getCell(63)))
                .squareBalcony(getDoubleValue(row.getCell(64)))
                .squareLoggia2(getDoubleValue(row.getCell(65)))
                .squareBalcony2(getDoubleValue(row.getCell(66)))
                .squareLoggia3(getDoubleValue(row.getCell(67)))
                .squarePantry(getDoubleValue(row.getCell(68)))
                .squareTerrace(getDoubleValue(row.getCell(69)))
                .squareTerrace2(getDoubleValue(row.getCell(70)))
                .squareAuxiliaryPremises(getDoubleValue(row.getCell(71)))
                .auxiliaryPremisesCount(getIntegerValue(row.getCell(72)))
                .squareLoggiaArbitrary(getDoubleValue(row.getCell(73)))
                .squareLoggiaArbitrary2(getDoubleValue(row.getCell(74)))
                .squareLoggiaArbitrary3(getDoubleValue(row.getCell(75)))
                .squareBalconyArbitrary(getDoubleValue(row.getCell(76)))
                .squareBalconyArbitrary2(getDoubleValue(row.getCell(77)))
                .squareTerraceArbitrary(getDoubleValue(row.getCell(78)))
                .squareTerraceArbitrary2(getDoubleValue(row.getCell(79)))
                .cadastralNumber(getStringValue(row.getCell(80)))
                .agreementBasedSquare(getDoubleValue(row.getCell(81)))
                .agreementBasedAmount(getDoubleValue(row.getCell(82)))
                .preInstalledAgreementNumber(getStringValue(row.getCell(83)))
                .preInstalledAgreementBasedNumber(getStringValue(row.getCell(84)))
                .preInstalledAgreementBasedDate(getDateValue(row.getCell(85)))
                .preInstalledAgreementBasedContact(getStringValue(row.getCell(86)))
                .preInstalledAgreementBasedRegistrationDate(getDateValue(row.getCell(87)))
                .preInstalledAgreementBasedRegistrationNumber(getStringValue(row.getCell(88)))
                .providingMethod(getStringValue(row.getCell(89)))
                .reservationEndDate(getDateValue(row.getCell(90)))
                .serviceMarks(getStringValue(row.getCell(91)))
                .squareWithoutLP(getDoubleValue(row.getCell(92)))
                .squareReduced(getDoubleValue(row.getCell(93)))
                .squareProject(getDoubleValue(row.getCell(94)))
                .squareArbitrary(getDoubleValue(row.getCell(95)))
                .squareArbitrary2(getDoubleValue(row.getCell(96)))
                .squareArbitrary3(getDoubleValue(row.getCell(97)))
                .arbitraryPrice(getDoubleValue(row.getCell(98)))
                .arbitraryPrice2(getDoubleValue(row.getCell(99)))
                .arbitraryPrice3(getDoubleValue(row.getCell(100)))
                .customText(getStringValue(row.getCell(101)))
                .customText2(getStringValue(row.getCell(102)))
                .customText3(getStringValue(row.getCell(103)))
                .collateralPrice(getDoubleValue(row.getCell(104)))
                .estimatedPrice(getDoubleValue(row.getCell(105)))
                .balconyFenceHeight(getDoubleValue(row.getCell(106)))
                .balconyHeight(getDoubleValue(row.getCell(107)))
                .isExclusive(getBooleanValue(row.getCell(108)))
                .levelsCount(getIntegerValue(row.getCell(109)))
                .roomsType(getStringValue(row.getCell(110)))
                .saleType(getStringValue(row.getCell(111)))
                .virtualTourLink(getStringValue(row.getCell(112)))
                .agentFees(getDoubleValue(row.getCell(113)))
                .agreementBasedScheduledPaymentSchedule(getStringValue(row.getCell(114)))
                .agreementScheduledPaymentSchedule(getStringValue(row.getCell(115)))
                .agreementBasedDepositedAmount(getStringValue(row.getCell(116)))
                .sellingName(getStringValue(row.getCell(117)))
                .readyForTransferObjectPlannedDate(getDateValue(row.getCell(118)))
                .readyForTransferObjectActualDate(getDateValue(row.getCell(119)))
                .build();
        String intendedAddress = getStringValue(row.getCell(120));
        if (intendedAddress != null && !intendedAddress.isEmpty())
            this.address = intendedAddress;
        dto.setAddress(address);

        dto.setPicHrefs(getStringValue(row.getCell(121)));

        if (dto.getQuantityRooms() == null || dto.getPrice() == null || dto.getSquare() == null || dto.getFloor() == null)
            dto.setStatusParse("error");
        else
            dto.setStatusParse("ok");

        return dto;
    }

    @Override
    protected String getStringValue(Cell cell) {
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case STRING:
                return cell.getStringCellValue();
            default:
                return null;
        }
    }

    @Override
    protected Integer getIntegerValue(Cell cell) {
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            case STRING:
                return Integer.valueOf(cell.getStringCellValue());
            default:
                return null;
        }
    }

    @Override
    protected Long getLongValue(Cell cell) {
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return (long) cell.getNumericCellValue();
            case STRING:
                return Long.valueOf(cell.getStringCellValue());
            default:
                return null;
        }
    }

    @Override
    protected Double getDoubleValue(Cell cell) {
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                return Double.valueOf(cell.getStringCellValue());
            default:
                return null;
        }
    }

    @Override
    protected Boolean getBooleanValue(Cell cell) {
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return null;
            case STRING:
                switch (cell.getStringCellValue()) {
                    case "Нет":
                        return false;
                    case "Да":
                        return true;
                    default:
                        return null;
                }
        }
        return null;
    }

    @Override
    protected LocalDate getDateValue(Cell cell) {
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return null;
            case STRING:
                String value = cell.getStringCellValue();
                if (value != null && !value.isEmpty())
                    return Date.valueOf(value).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            default:
                return null;
        }
    }
}
