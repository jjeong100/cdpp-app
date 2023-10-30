package com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCSISurveyDto {
    private String integrationId;
    private String assetId;
    private String assetVin;
    private String dealerCustomerSap;
    private String date;
    private String status;
    private String description;
    private String srId;
    private String srNumber;
}
