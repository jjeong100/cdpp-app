package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0022;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0022Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0022Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Name of requester system.", example = "SAP")
        @NotNull @NotBlank @NotEmpty
        private String source;
        @Schema(description = "Holiday description.", example = "Proclama 00E7 00E3o da Rep 00FAblica")
        @JsonProperty("holiday-description")
        private String holidayDescription;
        @Schema(description = "Holiday date. Format: MM/DD/YYYY", example = "2016-11-15")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("holiday-date")
        private String holidayDate;
        @Schema(description = "Dealer Code", example = "B05AM99999")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("dealer-code")
        private String dealerCode;
        @Schema(description = "Requested operation. Possible values are: UPSERT for update or insert. DELETE for deletion.", example = "DELETE")
        @NotNull @NotBlank @NotEmpty
        private String operation;
    }
    
    @Schema(name = "IFHMBINNOCEANCDPP0022Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Returns 0 when success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String ErrorSpcCode;
        @Schema(description = "Returns OK when success.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String ErrorSpcMessage;
    }
}
