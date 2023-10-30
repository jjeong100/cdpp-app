package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBBLUELINKCDPP0053Payload {
    
    @Schema(name = "IFHMBBLUELINKCDPP0053Payload.Request")
    @Getter
    @Setter
    public static class Request{
        List<VehicleBluelink> Vehicle;
    }

    @Schema(name = "IFHMBBLUELINKCDPP0053Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String ErrorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String ErrorSpcMessage;

    }
}
