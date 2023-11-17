package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0026;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0026Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0026Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Valid @JsonProperty("ListOfProduct")
        private List<ListOfProduct> listOfProduct;
    }

    @Schema(name = "IFHMBSAPEAICDPP0026Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Returns 0 when success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String error_spcCode;
        @Schema(description = "Returns OK when success.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String error_spcMessage;
    }
    
}
