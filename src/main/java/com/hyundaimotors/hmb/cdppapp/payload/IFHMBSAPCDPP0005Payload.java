package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPCDPP0005Payload {
    
    @Schema(name = "IFHMBZICARDCDPP0005Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "External system unique identifier.", example = "695938")
        private String integrationId;
        @Schema(description = "Company document number (numbers only)", example = "2038025000614")
        private String cnpjNumber;
        @Schema(description = "Company name", example = "AUTO POSTO ITATIAIA LTDA SUL")
        @NotNull @NotBlank @NotEmpty
        private String name;
        @Schema(description = "Company nickname", example = "POSTO ITATIAIA")
        private String nickname;
        @Schema(description = "Parent Company if belongs to a group.", example = "AUTO POSTO ITATIAIA LTDA")
//        @NotNull @NotBlank @NotEmpty
        private String parentAccountName;
        @Schema(description = "agencyCode", example = "HQ")
        private String agencyCode;
        @Schema(description = "fleet account type", example = "Large fleets")
        private String fleetAccontType;
        @Schema(description = "Service, transport, Energy, Steel and metallurgy, Textiles\u2026..", example = "Technology and computing")
        private String industryTrend;
        @Schema(description = "Number of Employee", example = "10")
        private String numberOfEmployee;
        @Schema(description = "Total Fleet Size", example = "0")
        private int totalFleetSize;
        @Schema(description = "Contracted Since", example = "2010-01-20")
        private String contractedSince;
        @Schema(description = "External source. Valid values: X Call Center , X Dealer , X Home Page , X Marketing , X Sap ", example = "Call Center")
        private String source;
        @Schema(description = "National or International", example = "National")
        private String organizationType;
        @Schema(description = "Main phone.", example = "2345678")
        private String mainPhoneNumber;
        @Schema(description = "Main Fax phone.", example = "3456789")
        private String mainFaxNumber;
        @Schema(description = "Company email address.", example = "kilosolution2s@gmail.com")
        private String mainEmailAddress;
        @Schema(description = "URL ", example = "http://www.prueba.com.br/")
        private String homepage;
        @Schema(description = "Address street name.", example = "Rua Tutoia")
        private String streetAddress;
        @Schema(description = "Address house number", example = "380")
        private String streetAddress2;
        @Schema(description = "Address complement.", example = "Andar 3")
        private String streetAddress3;
        @Schema(description = "Address county.", example = "Paraiso")
        private String county;
        @Schema(description = "Address city.", example = "Brasil")
        private String city;
        @Schema(description = "Address state.", example = "S00E3o Paulo ")
        private String state;
        @Schema(description = "Address zip code.", example = "4007001")
        private String postalCode;
        @Schema(description = "Description", example = "Description")
        private String description;
    }

    @Schema(name = "IFHMBZICARDCDPP0005Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Company document number (numbers only)", example = "2038025000614")
        @JsonProperty("AccountId")
        private String contactId;
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
