package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0021;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListOfDealers{
    @JsonProperty("dealer-code")
    private String dealerCode;
}
