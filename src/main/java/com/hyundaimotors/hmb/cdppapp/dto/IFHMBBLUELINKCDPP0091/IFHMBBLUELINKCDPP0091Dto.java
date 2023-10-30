package com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBBLUELINKCDPP0091Dto {
    private String dateInput;
    private String vin;
    private String ErrorSpcCode;
    private String ErrorSpcMessage;
    List<GetBluelinkDto> listOfBluelink;
}
