package com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0053;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleBluelinkDto {
    private String chassi;
    private String latestMileage;
    List<BluelinkDto> ListOfBluelink;
}
