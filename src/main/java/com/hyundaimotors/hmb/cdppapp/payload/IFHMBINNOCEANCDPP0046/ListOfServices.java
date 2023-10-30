package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0046;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListOfServices {
    @Schema(description = "Service type code.", example = "1st maintenance")
    @JsonProperty("service-type")
    private String service_type;
    @Schema(description = "Service length in minutes.", example = "60")
    @JsonProperty("service-length")
    private int service_length;
}
