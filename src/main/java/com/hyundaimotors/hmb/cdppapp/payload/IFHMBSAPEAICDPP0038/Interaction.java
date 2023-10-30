package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Interaction")
@Getter
@Setter
public class Interaction {
    @Schema(description = "Numero Interaction", example = "2")
    @JsonProperty("InteractionNum")
    private String interactionNum;
    @Schema(description = "Description Interaction", example = "04/10/2018 - O cliente fez o testdrive")
    @JsonProperty("Description")
    private String description;
    @Schema(description = "Interaction Date", example = "2018-04-10")
    @JsonProperty("Date")
    private String date;
    @Schema(description = "Contact Flag", example = "Y")
    @JsonProperty("ContactCustomer")
    private String contactCustomer;
}
