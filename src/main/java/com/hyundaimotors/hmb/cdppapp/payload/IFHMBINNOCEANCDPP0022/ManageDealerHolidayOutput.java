package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0022;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageDealerHolidayOutput {

    @Schema(description = "Returns 0 when success.", example = "0")
    @JsonProperty("Error_spcCode")
    private String ErrorSpcCode;
    @Schema(description = "Returns OK when success.", example = "OK")
    @JsonProperty("Error_spcMessage")
    private String ErrorSpcMessage;

    
}
