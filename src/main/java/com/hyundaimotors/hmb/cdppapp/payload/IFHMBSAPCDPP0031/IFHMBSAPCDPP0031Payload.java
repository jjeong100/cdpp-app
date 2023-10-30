package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0031;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPCDPP0031Payload {
    
    @Schema(name = "IFHMBSAPCDPP0031Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Date_Input is null,Informe Data", example = "2023-09-25")
        @JsonProperty("date")
        private String dateInput;
        @Schema(description = "Created Opcion value : scheduled, Created", example = "Y")
        @JsonProperty("created")
        private String created;

    }

    @Schema(name = "IFHMBSAPCDPP0031Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("HMBSearchServiceRequestTDWebservice_Output")
        HMBSearchServiceRequestTDWebserviceOutput hmbSearchServiceRequestTDWebserviceOutput;
    }
}
