package com.hyundaimotors.hmb.cdppapp.payload.IFHMINNOCEANTEST0000;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMINNOCEANTEST0000Payload {
    
    @Schema(name = "IFHMINNOCEANTEST0000Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Date of leads to capture. YYYY-MM-DD", example = "2023-09-25")
        private String rId;
        @Schema(description = "Y or N. If you select Y, then Siebel will retrieve all leads searching them by Created Field. If you select N, then Siebel will retrieve all leads searching them by Updated field.", example = "Y")
        private String rContent;
       
        
    }

    @Schema(name = "IFHMINNOCEANTEST0000Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "errorSpcCode", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "errorSpcMessage", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        // @JsonProperty("rId")
        // String rId;
    }
}
