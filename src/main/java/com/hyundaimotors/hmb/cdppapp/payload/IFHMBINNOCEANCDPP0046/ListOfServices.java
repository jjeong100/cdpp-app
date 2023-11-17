package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0046;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListOfServices {
    @Schema(description = "Service type code.", example = "1st maintenance")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("service-type")
    private String service_type;
    @Schema(description = "Service length in minutes.", example = "60")
    @NotNull
    @JsonProperty("service-length")
    private int service_length;
}
