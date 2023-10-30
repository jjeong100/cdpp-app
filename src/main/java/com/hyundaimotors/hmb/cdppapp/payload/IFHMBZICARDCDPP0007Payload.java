package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBZICARDCDPP0007Payload {

    @Schema(name = "IFHMBZICARDCDPP0007Payload.Request")
    @Getter
    @Setter
    public static class Request{

        @NotNull
        @Schema(description = "Contact Asset Id", example = "1-1SJ-92")
        @JsonProperty("AssetId")
        private String assetId;

        @NotNull
        @Schema(description = "Contact Id", example = "1-6T3P3")
        @JsonProperty("ContactId")
        private String contactId;

        @NotNull
        @Schema(description = "RelationShip Contact/asset", example = "Owner")
        @JsonProperty("RelationShip")
        private String relationShip;

        @Schema(description = "Retail Date", example = "2012-12-13")
        @JsonProperty("HKMERetailDate")
        private String hkmeRetailDate;

    }

    @Schema(name = "IFHMBZICARDCDPP0007Payload.Response")
    @Getter
    @Setter
    public static class Response{

        @Schema(description = "errorSpcCode", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;

        @Schema(description = "errorSpcMessage", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        
        @Schema(description = "Number Recors", example = "100")
        @JsonProperty("NumAffRows")
        private String numAffRow;

    }
    
}
