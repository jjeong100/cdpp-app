package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadInteraction {
    @Schema(description = "InteractionNum", example = "1")
    @JsonProperty("InteractionNum")
    private String interactionNum;
    @Schema(description = "yyyy-MM-ddThh24:mi:ss", example = "2023-10-02T10:47:32")
    @JsonProperty("Date")
    private String date;
    @Schema(description = "Description", example = "Teste")
    @JsonProperty("Description")
    private String description;
    @Schema(description = "ContactCustomer", example = "Y")
    @JsonProperty("ContactCustomer")
    private String contactCustomer;
}
