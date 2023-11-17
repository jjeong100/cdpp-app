package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColorDto {
    private int rowId;
    private String type;
    private String code;
    private String descriptionEM;
    private String descriptionPT;
    private String colorType;
    private String colorDescription;
}
