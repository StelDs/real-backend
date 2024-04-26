package ru.real.backend.api.dto;

import lombok.*;
import ru.real.backend.core.dto.BaseDto;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentFullDto extends BaseDto {
    private UUID id;
    private Double price;
    private Double squarePrice;
    private Integer quantityRooms;
    private String picHrefs;
    private String address;
    private Integer entrance;
    private Integer apartmentNumber;
    private Integer floor;
    private Double square;
    private Double squareKitchen;
    private Double squareKitchenLivingRoom;
    private Integer percent;


}
