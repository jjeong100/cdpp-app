package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequestTDDto {
    private String searchspec;
    private String codigoSAPTD;
    private String protocol;
    private String status;
    private String dealer;
    private String model;
    private String salesRepFirstName;
    private String salesRepLastName;
    private String testDriveDate;
    private String testDriveTime;
    private String testDriveConfirmed;
    private String area;
}
