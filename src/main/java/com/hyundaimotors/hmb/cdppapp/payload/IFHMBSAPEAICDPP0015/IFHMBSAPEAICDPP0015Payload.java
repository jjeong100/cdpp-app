package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0015Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0015Payload.Request")
    @Getter
    @Setter
    public static class Request{

        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Source")
        private String source;
        @JsonProperty("ListOfColors")
        List<Color> listOfColor;
    }

    @Schema(name = "IFHMBSAPEAICDPP0015Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
