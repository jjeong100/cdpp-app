package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPCDPP0079Payload {
    
    @Schema(name = "IFHMBSAPCDPP0079Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @JsonProperty("Repair")
        InboundRepair repair;
    }

    @Schema(name = "IFHMBSAPCDPP0079Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "errorSpcCode", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "errorSpcMessage", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
