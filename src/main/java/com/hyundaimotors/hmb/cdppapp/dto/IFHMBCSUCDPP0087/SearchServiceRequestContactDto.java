package com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchServiceRequestContactDto {
    private String srCreated;
    private String srNumber;
    private String dealerCode;
    private String modelCar;
    private String vehicleVersion;
    private String vehicleColor;
    private String engTrans;
    private String area;
}
