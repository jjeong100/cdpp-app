package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Temperature")
@Getter
@Setter
public class Temperature {
    @Schema(description = "Numero de Temperature", example = "1")
    @JsonProperty("TemperatureNum")
    private String temperatureNum;
    @Schema(description = "Valor Temperature", example = "F")
    @JsonProperty("Temperature")
    private String temperature;
}
