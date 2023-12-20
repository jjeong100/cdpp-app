package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class IFHMBINNOCEANCDPP0018Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0018Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @NotNull @NotBlank @NotEmpty
        @Schema(description = "Customer document (CPF).", example = "30311079800")
        @NotNull @NotBlank @NotEmpty
        private String cpf;
        @NotNull @NotBlank @NotEmpty
        @Schema(description = "Name of requester system.", example = "Source")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("Source")
        private String Source;

    }

    @Schema(name = "IFHMBINNOCEANCDPP0018Payload.Response")
    @Getter
    @Setter
    @SuperBuilder
    public static class Response{
        @Schema(description = "C00F3digo de erro (em caso de falha no servi 00E7o)", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Detalhe da mensagem de erro (em caso de falha no servi00E7o)", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;

        @JsonProperty("ListOfServices")
        List<ListOfServices> listOfServices;

    }
    @Schema(name = "IFHMBINNOCEANCDPP0018Payload.ListOfServices")
    @Getter
    @Setter
    public static class ListOfServices{
        @JsonProperty("protocol-num")
        private String protocolNum;
        @JsonProperty("protocol-status")
        private String protocolStatus;
        @JsonProperty("service-type")
        private String serviceType;
        @JsonProperty("service-arrivaldate")
        private String serviceArrivaldate;
        @JsonProperty("service-startdate")
        private String serviceStartdate;
        @JsonProperty("service-duration")
        private String serviceDuration;
        @JsonProperty("service-deliverydate")
        private String serviceDeliverydate;
        @JsonProperty("service-status")
        private String serviceStatus;
        @JsonProperty("dealer-code")
        private String dealerCode;
        @JsonProperty("dealer-name")
        private String dealerName;
        @JsonProperty("vehicle-plate")
        private String vehiclePlate;
        @JsonProperty("vehicle-model")
        private String vehicleModel;
        @JsonProperty("vehicle-modelyear")
        private String vehicleModelyear;
        @JsonProperty("vehicle-manufacyear")
        private String vehicleManufacyear;
        @JsonProperty("vehicle-extcolor")
        private String vehicleExtcolor;
        @JsonProperty("vehicle-chassi")
        private String vehicleChassi;
        @JsonProperty("consultant-name")
        private String consultantName;
        @JsonProperty("technician-name")
        private String technicianName;
    }
}
