package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0024;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0024Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0024Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @NotNull @NotBlank @NotEmpty
        @Schema(description = "DELETE/UPSERT", example = "UPSERT")
        private String operation;
        @Schema(description = "Record identifier.", example = "1")
        @JsonProperty("excp-id")
        private String excpId;
        @NotNull @NotBlank @NotEmpty
        @Schema(description = "Employee Cpf", example = "30311079800")
        @JsonProperty("employee-cpf")
        private String employeeCPF;
        @Schema(description = "Dealer code where the consultant will be available.", example = "B05AM99999")
        @JsonProperty("dealer-code")
        private String dealerCode;
        @Schema(description = "Exception's start date.Format: MM/DD/YYYY", example = "2016-10-12T00:00:00-0300")
        @JsonProperty("excp-start-date")
        private String excpStartDate;
        @Schema(description = "Exception's end date.Format: MM/DD/YYYY", example = "2016-12-12T00:00:00-0300")
        @JsonProperty("excp-end-date")
        private String excpEndDate;
        @Schema(description = "Absence period flag. Possible values are:", example = "N")
        @JsonProperty("absence-period")
        private String absencePeriod;
        @Schema(description = "First working period start time.Format: HH:MM:SS", example = "08:00:00")
        @JsonProperty("period1-start")
        private String period1Start;
        @Schema(description = "First working period end time. Format: HH:MM:SS", example = "12:00:00")
        @JsonProperty("period1-end")
        private String period1End;
        @Schema(description = "Second working period start time.Format: HH:MM:SS", example = "13:00:00")
        @JsonProperty("period2-start")
        private String period2Start;
        @Schema(description = "Second working period end time.Format: HH:MM:SS", example = "17:00:00")
        @JsonProperty("period2-end")
        private String period2End;
        @Schema(description = "Third working period start time.Format: HH:MM:SS", example = "14:00:00")
        @JsonProperty("period3-start")
        private String period3Start;
        @Schema(description = "Third working period end time.Format: HH:MM:SS", example = "19:00:00")
        @JsonProperty("period3-end")
        private String period3End;
        @Schema(description = "Exception's description.", example = "description")
        @JsonProperty("excp-desc")
        private String excpDesc;
        @Schema(description = "Name of requester system.", example = "Source")
        @NotNull @NotBlank @NotEmpty
        private String source;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0024Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
