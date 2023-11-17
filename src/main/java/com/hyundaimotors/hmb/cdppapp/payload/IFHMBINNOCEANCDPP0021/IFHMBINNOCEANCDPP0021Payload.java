package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0021;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0021Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0021Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Service Name. Possible values are:", example = "1st maintenance")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("service-name")
        private String serviceName;

        //@NotNull @NotBlank @NotEmpty
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Source")
        private String source;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0021Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @JsonProperty("service-name")
        private String serviceName;
        @JsonProperty("ListOfDealers")
        List<ListOfDealers> listOfDealers;
    }
    
    
}
