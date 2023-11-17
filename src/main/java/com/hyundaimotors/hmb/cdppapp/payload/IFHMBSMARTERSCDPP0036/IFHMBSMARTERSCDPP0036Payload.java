package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSMARTERSCDPP0036Payload {
    
    @Schema(name = "IFHMBSMARTERSCDPP0036Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Valid @JsonProperty("ServiceRequest")
        ServiceRequestChatInput serviceRequestChatInput;
        
    }

    @Schema(name = "IFHMBSMARTERSCDPP0036Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "errorSpcCode", example = "SBL-12Z3Z")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "errorSpcMessage", example = "Erro ao executar a tarefa  X do Connex.")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @Schema(description = "Owner By Id", example = "1-3LHJF40")
        @JsonProperty("OwnedById")
        private String ownedById;
        @Schema(description = "Protocol unique identifier. If an update is needed, value on this tag must be provided.", example = "HMB98949022323")
        @JsonProperty("Protocol")
        private String protocol;
    }
}
