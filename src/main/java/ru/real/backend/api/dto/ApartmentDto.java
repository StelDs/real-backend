package ru.real.backend.api.dto;

import lombok.*;
import ru.real.backend.core.dto.BaseDto;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentDto extends BaseDto {
    private UUID id;
    private Long externalId;

    private Integer quantityRooms;
    private Double price;
    private String address;
    private String picHrefs;

    private String status;

    private String info;
}
