package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBCSUCDPP0087Payload {
    
    @Schema(name = "IFHMBCSUCDPP0087Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Serial Number", example = "9BHBG51DAEP171603")
        //@NotNull @NotBlank @NotEmpty
        @JsonProperty("SerialNumber")
        private String serialNumber;
        @Schema(description = "Interface", example = "Source")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("Interface")
        private String interfaces;
        @Schema(description = "Contact Id", example = "1-LK2UJ")
        //@NotNull @NotBlank @NotEmpty
        @JsonProperty("ContactId")
        private String contactId;
        @Schema(description = "Campaing Name", example = "HMB Evento After Sales BH")
        //@NotNull @NotBlank @NotEmpty
        @JsonProperty("CampaignName")
        private String campaignName;
        @Schema(description = "CPF", example = "02377363814")
        @JsonProperty("CPF")
        private String cpf;
    }

    @Schema(name = "IFHMBCSUCDPP0087Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Name of requester system.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @JsonProperty("ListOfContact_Output")
        List<SearchContactOutput> listOfContactOutput;
    }
}
