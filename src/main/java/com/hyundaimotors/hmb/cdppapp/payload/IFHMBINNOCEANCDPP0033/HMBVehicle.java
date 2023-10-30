package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0033;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "HMBVehicle")
@Getter
@Setter
public class HMBVehicle {
    private String assetId;
    @JsonProperty("Vin")
    private String vin;
    private String engineNumber;
    private String licenseNumber;
    private String renavamCode;
    @JsonProperty("fsc_ocn")
    private String fscOcn;
    private String description;
    private String manufactureYear;
    @JsonProperty("ModelYear")
    private String modelYear;
    private String vehicleLicenseNumber;
    private String internalColorCode;
    private String externalColorCode;
    @JsonProperty("Fuel")
    private String fuel;
    @JsonProperty("Status")
    private String status;
    private String saleToDealerDate;
    private String billingDate;
    @JsonProperty("CCSFlg")
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
    @JsonProperty("ListOfContact")
    List<Contact> listOfContact;
    @JsonProperty("ListOfAccount")
    List<Account> listOfAccount;
}
