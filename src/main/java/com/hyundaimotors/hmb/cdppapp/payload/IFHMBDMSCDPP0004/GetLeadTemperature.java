package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadTemperature {
    @Schema(description = "Numero Interaction", example = "2")
    @JsonProperty("TemperatureNum")
    private String temperatureNum;
    @Schema(description = "Description Interaction", example = "04/10/2018 - O cliente fez o testdrive")
    @JsonProperty("Temperature")
    private String temperature;
}
