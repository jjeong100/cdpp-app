package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HMBSearchServiceRequestTDWebserviceOutputDto {
    private String errorSpcCode;
    private String errorSpcMessage;
    private List<SearchServiceRequestDto> listOfHmbSearchServiceRequest;
}
