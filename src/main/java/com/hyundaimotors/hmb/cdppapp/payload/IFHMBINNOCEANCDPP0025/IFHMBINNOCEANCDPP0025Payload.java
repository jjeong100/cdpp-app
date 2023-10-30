package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0025;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0025Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0025Payload.Request")
    @Getter
    @Setter
    public static class Request{
        ScheduleMaintenanceIN ScheduleMaintenanceIN;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0025Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Returns 0 when success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String ErrorSpcCode;
        @Schema(description = "Returns OK when success.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String ErrorSpcMessage;
        @Schema(description = "Protocol number.", example = "HMB8761468242")
        private String srNumber;
    }
}
