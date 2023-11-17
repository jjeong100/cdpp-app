package com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBDMSCDPP0004Dto {
    private String rowId;
    private String date;
    private String dealerCode;
    private String apiKey;
    private String statusLead;
    private String protocol;
    private String status;
    private String errorspcCode;
    private String errorspcMessage;
    List<GetLeadDto> listOfLead;
}
