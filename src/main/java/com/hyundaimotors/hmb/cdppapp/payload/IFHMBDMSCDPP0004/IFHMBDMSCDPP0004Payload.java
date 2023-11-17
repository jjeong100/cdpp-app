package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBDMSCDPP0004Payload {
    
    @Schema(name = "IFHMBDMSCDPP0004Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "YYYY-MM-DD", example = "2019-09-10")
        @NotNull @NotBlank @NotEmpty
        private String date;
        @Schema(description = "It should be a pre-existing Dealer Code in CRM.", example = "B05AM26057")
        private String dealerCode;
        @Schema(description = "It should be an existing Api Key in CRM.", example = "4ectZfEIGhrAFoLyAUVq0HzuZ5GBMevx")
        private String apiKey;
        @Schema(description = "Open or Done", example = "Open")
        @NotNull @NotBlank @NotEmpty
        private String statusLead;
    }

    @Schema(name = "IFHMBDMSCDPP0004Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorspcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorspcMessage;
        @JsonProperty("ListOfLead")
        List<GetLead> listOfLead;
        
    }
}
