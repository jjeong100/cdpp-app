package com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchAutoVehicleDto {
    private String vehicleId;
    private String relationship;
    private String hmbRenavamCode;
    private String currenMileage;
    private String vehicleLicenseNumber;
    private String serialNumber;
    private String fscOcn;
    private String manufactureYear;
    private String model;
    private String modelYear;
    private String internalColorCode;
    private String externalColorCode;
    private String hexaWarrantyFlag;
    private String dealerId;
    private String retailDt;
    private String salesRepId;
    private String salesRepLastName;
    private String salesReFirstName;
    private String operatingStatus;
}
