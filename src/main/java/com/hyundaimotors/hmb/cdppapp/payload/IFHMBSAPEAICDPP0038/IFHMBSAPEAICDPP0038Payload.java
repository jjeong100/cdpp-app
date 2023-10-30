package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0038Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0038Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "SR Number", example = "HMB8761468242")
        @JsonProperty("Protocol")
        private String protocol;
        @Schema(description = "Result Interaction", example = "Aten 00E7 00E3o!! Sua concession 00E1ria acaba de receber uma Oportunidade de Vendas")
        @JsonProperty("Result")
        private String result;
        @Schema(description = "Activity UID", example = "1-6789YU")
        private String ntegrationId;
        @Schema(description = "Status Sales", example = "Sold")
        @JsonProperty("SalesStatus")
        private String salesStatus;
        @Schema(description = "Sales CPF", example = "83336664853")
        @JsonProperty("SaleCPF")
        private String saleCPF;
        @Schema(description = "Status", example = "Open")
        @JsonProperty("Status")
        private String status;
        @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "2018-01-10  8:00:00 AM")
        @JsonProperty("FirstInteractionDate")
        private String firstInteractionDate;
        @Schema(description = "Reason Interaction", example = "Gave up the purchase right now")
        @JsonProperty("SaleReason")
        private String saleReason;
        @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "2018-10-17 16:30:00")
        @JsonProperty("EndDate")
        private String endDate;
        @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "2018-10-15 16:30:00")
        @JsonProperty("DlrReceiveDate")
        private String dlrReceiveDate;
        @Schema(description = "Dealer Responde", example = "2018-10-16 16:30:00")
        @JsonProperty("DlrResponseTime")
        private String dlrResponseTime;
        @Schema(description = "PNE Flag", example = "Y")
        private String pcd;
        @Schema(description = "Source", example = "Source")
        private String source;
        @Schema(description = "Scheduled Visit Date", example = "2018-10-17 16:30:00")
        private String schedvisit;
        @Schema(description = "Conducted Visit Date", example = "2018-10-17 16:30:00")
        private String visitdate;
        @Schema(description = "Visit Status", example = "Canceled")
        private String visitstat;
        List<Temperature> listOfTemperature;
        List<Interaction> listOfInteraction;
    }

    @Schema(name = "IFHMBSAPEAICDPP0038Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Action Id", example = "1-34O5WD")
        @JsonProperty("ActionId")
        private String actionId;
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String ErrorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String ErrorSpcMessage;
    }
}
