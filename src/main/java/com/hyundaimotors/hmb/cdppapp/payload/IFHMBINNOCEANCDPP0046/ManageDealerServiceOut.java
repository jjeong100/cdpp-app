package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0046;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageDealerServiceOut {
    
    @Schema(description = "Return the same dealer-code passed as input parameter for this web service, for redundancy verification purposes in the other end.", example = "INT_COMPANY_ID")
    @JsonProperty("dealer-code")
    private String dealerCode;
}
