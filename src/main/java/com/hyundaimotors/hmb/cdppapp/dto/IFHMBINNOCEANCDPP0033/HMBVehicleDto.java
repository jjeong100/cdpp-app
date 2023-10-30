package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HMBVehicleDto {
    private String assetId;
    private String vin;
    private String engineNumber;
    private String licenseNumber;
    private String renavamCode;
    private String fscOcn;
    private String description;
    private String manufactureYear;
    private String modelYear;
    private String vehicleLicenseNumber;
    private String internalColorCode;
    private String externalColorCode;
    private String fuel;
    private String status;
    private String saleToDealerDate;
    private String billingDate;
    private String ccsFlg;
    private String warrantyStartDate;
    private String fiscalReceipt;
    private String dealerId;
    private String dealerCode;
    private String dealerName;
    private String dealerNickname;
    private String salesManName;
    private String model;
    private String negotiationType;
    private String salesManId;
    private int mileage;
    private String contactSearchId;
    private String AccountSearchId;
    List<ContactDto> listOfContact;
    List<AccountAssetDto> listOfAccount;
}
