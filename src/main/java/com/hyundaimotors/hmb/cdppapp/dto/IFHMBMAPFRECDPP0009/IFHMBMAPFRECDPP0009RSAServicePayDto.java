package com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBMAPFRECDPP0009RSAServicePayDto {
    private String rowId;
    private String serviceId;
    private String createDate;
    private String serviceCode;
    private String specialty;
    private String provider;
    private String vehicleProblem;
    private String problemDescription;
    private int tmcPredicted;
    private String important;
    private String requestStatus;
    private String actuationStatus;
    private String addressName;
    private String addressNumber;
    private String addressComplement;
    private String county;
    private String city;
    private String state;
    private int latitude;
    private int longitude;
    private String reference;
    private String zipCode;
    private String dealerName;
    private String dealerNickname;
    private String expense;
}
