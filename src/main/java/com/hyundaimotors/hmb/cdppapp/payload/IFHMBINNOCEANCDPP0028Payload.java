package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0028Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0028Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Contact Id", example = "1-U1VO")
        private String contactId;
        @Schema(description = "Partner Name", example = "MSC CRUZEIROS")
        private String partnerName;
        @Schema(description = "Partner CNPJ", example = "05102954000129")
        private String partnerCNPJ;
        @Schema(description = "Partner External Id", example = "1-41EHQH")
        private String partnerExternalId;
        @Schema(description = "Benefit Name", example = "Mais conforto e 60% de desconto para a sua locomo\u00E7\u00E3o pela cidade. Se beber, v\u00E1 de taxi!")
        private String benefitName;
        @Schema(description = "Benefit URL", example = "<Long>")
        private String benefitURL;
        @Schema(description = "Name of external system.", example = "Loyalty Web Portal")
        private String appSource;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0028Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
