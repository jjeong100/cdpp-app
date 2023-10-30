package com.hyundaimotors.hmb.cdppapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0024Dto {
    private int rowId;
    private String operation;
    private String excpId;
    private String employeeCPF;
    private String dealerCode;
    private String excpStartDate;
    private String excpEndDate;
    private String absencePeriod;
    private String period1Start;
    private String period1End;
    private String period2Start;
    private String period2End;
    private String period3Start;
    private String period3End;
    private String excpDesc;
    private String source;
    private String errorSpcCode;
    private String errorSpcMessage;
}
