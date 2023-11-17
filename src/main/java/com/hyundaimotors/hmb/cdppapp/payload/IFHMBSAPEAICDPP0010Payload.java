package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0010Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0010Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "This tag was deactivated. serialNumber should be used instead.", example = "9BHBG51DADP011617")        
        private String integrationId;
        @Schema(description = "Valid values:Dealer Owned, Customer Owned, Cancelled.", example = "Customer Owned")
        private String status;
        @Schema(description = "Chassis number.Unique code for the asset record to be added. It is used as key field for this integration, to determine if a existing record should be updated or a new record should be inserted.", example = "9BHBH41DBGP633658")
        @NotNull @NotBlank @NotEmpty
        private String serialNumber;
        @Schema(description = "Renavam code.", example = "497269414")
        private String renavamCode;
        @Schema(description = "Engine number.", example = "F3LACU001831")
        private String engineNumber;
        @Schema(description = "Vehicle Plate.", example = "FCK1760")
        private String vehicleLicenseNumber;
        @Schema(description = "Product FSC OCN Name", example = "092214A000")        
        private String fscOcn;
        @Schema(description = "Product description.", example = "ELANTRA")
        private String modelName;
        @Schema(description = "Internal color code.", example = "9P")
        private String internalColorCode;
        @Schema(description = "External color code.", example = "R5S")
        private String externalColorCode;
        @Schema(description = "SAP fuel type.", example = "F")
        private String fuel;
        @Schema(description = "Purchase price.", example = "50000")
        private int purchasePrice;
        @Schema(description = "Manufacture year.", example = "2012")
        private String manufactureYear;
        @Schema(description = "modelYear", example = "2015")
        private int modelYear;
        @Schema(description = "Mileage.", example = "1000")
        private int mileage;
        @Schema(description = "Sale to dealer date. Format: MM/DD/YYYY", example = "2012-10-25")
        private String saleToDealerDate;
        @Schema(description = "Warranty's start date. Format: MM/DD/YYYY", example = "2023-11-07T00:00:00-0300")
        private String warrantyStartDate;
        @Schema(description = "Billing date. Format: MM/DD/YYYY", example = "2023-11-07T11:45:05-0300")
        private String billingDate;
        @Schema(description = "Deliver to customer date. Format: MM/DD/YYYY", example = "2023-06-09T00:00:00-0300")
        private String deliverToCustomerDate;
        @Schema(description = "Dealer code.", example = "B05AM19029")
        private String sellingDealerCode;
        @Schema(description = "Negotiation type.", example = "ZV01")
        private String negotiationType;
        @Schema(description = "Subscription type.", example = "KU")
        private String subscriptionType;
        @Schema(description = "Fiscal receipt.", example = "120109")
        private String fiscalReceipt;
        @Schema(description = "Integration Id (CPF) for the sales representative.", example = "23351")
        private String salesrepId;
        @Schema(description = "First name for the sales representative.", example = "Carlos")
        private String salesrepFirstName;
        @Schema(description = "Last name for the sales representative.", example = "Soto")
        private String salesrepLastName;
        @Schema(description = "url Photo", example = "https://meuhyundai.com.br/static/momento_especial/1660764424478--1-EU7NVW7.jpg")
        private String urlPhoto;
        @Schema(description = "url Photo Date", example = "2023-06-09T00:00:00-0300")
        private String urlphotoDate;
        @Schema(description = "url Auth Piblication", example = "2022.08.08")
        private String urlauthPublication;
        @Schema(description = "Vehicle License Date", example = "2023-06-09T00:00:00-0300")
        @JsonProperty("VehicleLicenseDate")
        private String vehicleLicenseDate;
        @Schema(description = "Digital Sales", example = "N")
        private String digitalSales;
        @Schema(description = "deliveryatHome", example = "N")
        private String deliveryatHome;
        @Schema(description = "TD at Home", example = "Y")
        @JsonProperty("TDatHome")
        private String tdatHome;
        @Schema(description = "ccs_flg", example = "N")
        private String ccs_flg;
        @JsonProperty("ListOfContact")
        List<AutoVehicleWebserviceWFContactPayload> contact;
        @JsonProperty("ListOfAccount")
        List<AutoVehicleWebserviceWFAccountPayload> account;
    }

    @Schema(name = "IFHMBSAPEAICDPP0010Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}
