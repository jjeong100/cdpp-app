package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0063;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Account")
@Getter
@Setter
public class AccountGetVin {
    @JsonProperty("IdSiebel")
    private String idSiebel;
    @JsonProperty("RelatedType")
    private String relatedType;
    @JsonProperty("RelatedStatus")
    private String relatedStatus;
}
