package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0062;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "TotalTemperature")
@Getter
@Setter
public class TotalTemperature {
    @Schema(description = "Temperature created Date,  yyyy-MM-DDThh24:mi:ssZ", example = "2020-05-02T09:07:48-0300")
    @JsonProperty("Created")
    private String created;
    @Schema(description = "Sequential number", example = "1996-02-22")
    @JsonProperty("Name")
    private String name;
    @Schema(description = "Temperature: Hot, Warm, Cold", example = "Hot")
    @JsonProperty("Temperature")
    private String temperature;
}
