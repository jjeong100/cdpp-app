package com.hyundaimotors.hmb.cdppapp.payload.IFHMBMAPFRECDPP0009;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBMAPFRECDPP0009Payload {
    
    @Schema(name = "IFHMBMAPFRECDPP0009Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "RSA Integration Id", example = "MONDIAL29130301")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("ClaimId")
        @NotNull @NotBlank @NotEmpty
        private String claimId;
        @Schema(description = "Source", example = "Telephone")
        @JsonProperty("Source")
        private String source;
        @Schema(description = "Id from Contact (Personal Account)", example = "1-12RT54")
         @JsonProperty("ContactId")
        private String contactId;
        @Schema(description = "Id from Account (Business Account)", example = "1-PR546FG")
         @JsonProperty("AccountId")
        private String accountId;
        @Schema(description = "RSA Requester First Name", example = "BIBIANA")
        @JsonProperty("requesterFirstName")
        private String requesterFirstName;
        @Schema(description = "RSA Requester Last Name", example = "CESARIO DE OLIVEIRA MORENO")
        @JsonProperty("requesterLastName")
        private String requesterLastName;
        @Schema(description = "RSA Requester Document", example = "28728923898")
        @JsonProperty("requesterDocument")
        private String requesterDocument;
        @Schema(description = "RSA Requester Vehicle Rel", example = "Driver")
        @JsonProperty("requesterRelationship")
        private String requesterRelationship;
        @Schema(description = "RSA Claim Date", example = "2015-08-06")
        @JsonProperty("CreateDate")
        private String createDate;
        @Schema(description = "RSA Reason", example = "PANE")
        @JsonProperty("Reason")
        private String reason;
        @Schema(description = "RSA Breakdown Description", example = "PANE")
        @JsonProperty("BreakdownDescription")
        private String breakdownDescription;
        @Schema(description = "RSA Breakdown Code", example = "31")
        @JsonProperty("BreakdownCode")
        private String breakdownCode;
        @Schema(description = "RSA Breakdown Nature", example = "PANE")
        @JsonProperty("BreakdownNature")
        private String breakdownNature;
        @Schema(description = "RSA Status", example = "INTERVEN 00C7 00C3O")
        @JsonProperty("ClaimStatus")
        private String claimStatus;
        @Schema(description = "Auto Vehicle Serial Number", example = "9BHBH41DBGP633658")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("SerialNumber")
        @NotNull @NotBlank @NotEmpty
        private String serialNumber;
        @Schema(description = "RSA Effective Start Date", example = "2015-08-06")
        @JsonProperty("EffectiveStartDate")
        private String effectiveStartDate;
        @Schema(description = "RSA Effective End Date", example = "2015-10-06")
        @JsonProperty("EffectiveEndDate")
        private String effectiveEndDate;
        @Schema(description = "RSA Exchange Date", example = "2015-08-06")
        @JsonProperty("ExchangeDate")
        private String exchangeDate;
        @Schema(description = "Vehicle License Number", example = "FCK1760")
        @JsonProperty("VehiclePlate")
        private String vehiclePlate;
        @Schema(description = "RSA Mileage", example = "900")
        @JsonProperty("vehicleMileage")
        private int vehicleMileage;
        @Valid @JsonProperty("ListOfService")
        List<IFHMBMAPFRECDPP0009RSAServicePayload> listOfRSASetvice;
    }

    @Schema(name = "IFHMBMAPFRECDPP0009Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Protocol Numer", example = "HMB8761468242")
        @JsonProperty("Protocol")
        private String protocol;
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
         @JsonProperty("error_code")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
         @JsonProperty("error_message")
        private String errorSpcMessage;

    }
}
