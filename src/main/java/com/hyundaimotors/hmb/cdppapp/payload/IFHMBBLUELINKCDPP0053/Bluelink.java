package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Bluelink")
@Getter
@Setter
public class Bluelink {
    @Schema(description = "Id from the Partner", example = "1-U1V4")
    @JsonProperty("IntegrationId")
    private String integrationId;
    @Schema(description = "Valid values: Assignee, Driver, Family, First owner, Mechanic, Other, Owner, Unspecified.", example = "Driver")
    @JsonProperty("ActivationDate")
    private String activationDate;
    @Schema(description = "It is not necessary to inform. It is calculated automatically, setting Y for the oldest record.", example = "Y")
    @JsonProperty("FirstActivation")
    private String firstActivation;
    @Schema(description = "Code from CCS system that means the activation or deactivation mode.", example = "ENROLLMENT (VIA TMU)")
    @JsonProperty("Type")
    private String type;
}
