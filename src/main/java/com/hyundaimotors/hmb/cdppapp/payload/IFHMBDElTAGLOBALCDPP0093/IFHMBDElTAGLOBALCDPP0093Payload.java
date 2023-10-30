package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDElTAGLOBALCDPP0093;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBDElTAGLOBALCDPP0093Payload {
    
    @Schema(name = "IFHMBDElTAGLOBALCDPP0093Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @JsonProperty("ListOfRentalResult")
        List<RentalResult> listOfRentalResult;
    }

    @Schema(name = "IFHMBDElTAGLOBALCDPP0093Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "errorSpcCode", example = "SBL-12Z3Z")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "errorSpcMessage", example = "Erro ao executar a tarefa  X do Connex.")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
