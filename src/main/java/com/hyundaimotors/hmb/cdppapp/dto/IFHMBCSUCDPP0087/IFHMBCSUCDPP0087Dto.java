package com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBCSUCDPP0087Dto {
    private String serialNumber;
    private String interfaces;
    private String contactId;
    private String campaignName;
    private String errorSpcCode;
    private String errorSpcMessage;
    List<SearchContactOutputDto> listOfContactOutput;
}
