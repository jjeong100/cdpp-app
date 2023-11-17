package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0012Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0012Payload.Request")
    @Getter
    @Setter
    public static class Request{
        
        @Schema(description = "Name of requester system.", example = "Sap")
        @NotNull @NotBlank @NotEmpty
        private String source;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0012Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;

        @JsonProperty("ChannelPartner")
        private List<ChannelPartner> channelPartner;
    }
}
