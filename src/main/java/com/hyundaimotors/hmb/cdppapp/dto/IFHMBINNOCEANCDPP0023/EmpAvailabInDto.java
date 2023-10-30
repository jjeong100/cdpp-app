package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0023;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0023.IFHMBINNOCEANCDPP0023Day;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpAvailabInDto {
    private int rowId;
    private String source;
    private String employeeCPF;
    private String dealerCode;
    List<IFHMBINNOCEANCDPP0023Day>listOfDays;
}
