package com.hyundaimotors.hmb.cdppapp.dto;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0021.ListOfDealers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0021Dto {
    private String serviceName;
    private String source;

    private String errorSpcCode;
    private String errorSpcMessage;
    
    List<ListOfDealers> listOfDealers;
}
