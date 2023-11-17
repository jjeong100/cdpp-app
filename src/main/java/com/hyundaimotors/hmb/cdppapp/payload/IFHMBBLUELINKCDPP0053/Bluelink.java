package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Bluelink")
@Getter
@Setter
public class Bluelink {
    @Schema(description = "Id from the Partner", example = "1-U1V4")
    @JsonProperty("IntegrationId")
    private String integrationId;
    @Schema(description = "Activation Date", example = "2023-05-10T10:12:34-0300")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("ActivationDate")
    private String activationDate;
    @Schema(description = "It is not necessary to inform. It is calculated automatically, setting Y for the oldest record.", example = "Y")
    @JsonProperty("FirstActivation")
    private String firstActivation;
    @Schema(description = "Code from CCS system that means the activation or deactivation mode.", example = "ENROLLMENT (VIA TMU)")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("Type")
    private String type;
}
