package com.hyundaimotors.hmb.cdppapp.dto.IFHMBDElTAGLOBALCDPP0093;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalResultDto {
    private int rowId;
    private String name;
    private String rentalStatus;
    private String deltaProtocolNumber;
    private String confirmedModelofRentalCar;
    private String confirmedRentalStartDate;
    private String confirmedRentalEndDate;
}
