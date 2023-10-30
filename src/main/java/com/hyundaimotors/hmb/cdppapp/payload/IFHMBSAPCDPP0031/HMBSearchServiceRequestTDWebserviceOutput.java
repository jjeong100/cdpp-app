package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0031;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HMBSearchServiceRequestTDWebserviceOutput {
    @Schema(description = "Connex error code. Code 0 means success.", example = "0")
    @JsonProperty("Error_spcCode")
    private String errorSpcCode;
    @Schema(description = "Connex error message.", example = "OK")
    @JsonProperty("Error_spcMessage")
    private String errorSpcMessage;
    @JsonProperty("ListOfHmbSearchServiceRequestTDIO")
    private List<SearchServiceRequest> listOfHmbSearchServiceRequest;
}
