package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadResult {
    @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "2018-01-10  8:00:00 AM")
    @JsonProperty("FirstInteractionDate")
    private String firstInteractionDate;
    @Schema(description = "Sattaus Sales", example = "Sold")
    @JsonProperty("SaleStatus")
    private String saleStatus;
    @Schema(description = "Reason Interaction", example = "Gave up the purchase right now")
    @JsonProperty("Reason")
    private String reason;
    @Schema(description = "Result Interaction", example = "Aten 00E7 00E3o!! Sua concession 00E1ria acaba de receber uma Oportunidade de Vendas")
    @JsonProperty("Result")
    private String result;
    @Schema(description = "Sales CPF", example = "83336664853")
    @JsonProperty("SaleCPF")
    private String saleCPF;
    @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "17/10/2018 16:30:00")
    @JsonProperty("EndDate")
    private String endDate;
    @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "15/10/2018 16:30:00")
    @JsonProperty("DlrReceiveDate")
    private String dlrReceiveDate;
    @Schema(description = "Dealer Responde", example = "16/10/2018 16:30:00")
    @JsonProperty("DlrResponseTime")
    private String dlrResponseTime;
}
