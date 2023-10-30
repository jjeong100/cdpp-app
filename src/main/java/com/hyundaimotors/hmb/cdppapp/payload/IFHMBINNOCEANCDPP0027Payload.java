package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0027Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0027Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @NotNull
        @Schema(description = "Contact Id", example = "1-U1VO")
        private String contactId;
        @NotNull
        @Schema(description = "Name of external system : Loyalty Mobile App, Loyalty Web Portal", example = "Loyalty Web Portal")
        private String appSource;
        @Schema(description = "Status of loyalty program : Active, Inactive, Unsubscribed", example = "Active")
        private String appStatus;
        
    }

    @Schema(name = "IFHMBINNOCEANCDPP0027Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @NotNull
        @Schema(description = "Contact Id", example = "1-U1VO")
        private String contactId;
        @Schema(description = "Loyalty Status", example = "Active")
        private String loyaltyStatus;
    }
}
