package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0085;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBCSUCDPP0085Payload {
    
    @Schema(name = "IFHMBCSUCDPP0085Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "CEP ", example = "2012110")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("vCEP")
        private String vcep;
        @Schema(description = "Service Dealer Flag", example = "N")
        @JsonProperty("vService")
        private String vService;
        @Schema(description = "Sales Dealer Flag", example = "N")
        @JsonProperty("vSales")
        private String vSales;
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Source")
        private String source;

    }

    @Schema(name = "IFHMBCSUCDPP0085Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Object_spcId")
        private String objectSpcId;
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Process_spcInstance_spcId")
        private String processSpcInstanceSpcId;
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Connex_spcOperation_spcObject_spcId")
        private String connexSpcOperationSpcObjectSpcId;
        @JsonProperty("HmbChannelPartnerCtiDealer")
        private ChannelPartnerCSUD channelPartner;
    }
}
