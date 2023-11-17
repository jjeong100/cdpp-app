package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0035Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0035Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "URL", example = "C:/windows")
        @NotNull @NotBlank @NotEmpty       
        @JsonProperty("URL") 
        private String url;
        @Schema(description = "SR Number", example = "HMB8739974017")   
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("SrNumber") 
        private String srNumber;        
    }
    
    @Schema(name = "IFHMBSAPEAICDPP0035Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Attachment Id", example = "1-U1VO")  
        @JsonProperty("AttachmentId")  
        private String attachmentId;
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")   
        @JsonProperty("Error_spcCode") 
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")   
        @JsonProperty("Error_spcMessage") 
        private String errorSpcMessage;      
    }
}
