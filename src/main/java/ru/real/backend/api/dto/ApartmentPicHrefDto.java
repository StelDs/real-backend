package ru.real.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.real.backend.core.dto.BaseDto;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentPicHrefDto  {

    private UUID id;
    private String picHrefs;


}
