package com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0053;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBBLUELINKCDPP0053Dto {
    List<VehicleBluelinkDto> Vehicle;
    private String ErrorSpcCode;
    private String ErrorSpcMessage;
}
