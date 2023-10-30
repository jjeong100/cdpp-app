package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0010;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0010Dto {
        private String productRowId;
        private String rowId;
        private String integrationId;
        private String status;
        private String serialNumber;
        private String renavamCode;
        private String engineNumber;
        private String vehicleLicenseNumber;
        private String fscOcn;
        private String modelName;
        private String internalColorCode;
        private String externalColorCode;
        private String fuel;
        private int purchasePrice;
        private String manufactureYear;
        private int modelYear;
        private int mileage;
        private String saleToDealerDate;
        private String warrantyStartDate;
        private String billingDate;
        private String deliverToCustomerDate;
        private String sellingDealerCode;
        private String negotiationType;
        private String subscriptionType;
        private String fiscalReceipt;
        private String salesrepId;
        private String salesrepFirstName;
        private String salesrepLastName;
        private String urlPhoto;
        private String urlphotoDate;
        private String urlauthPublication;
        private String vehicleLicenseDate;
        private String digitalSales;
        private String deliveryatHome;
        private String tdatHome;
        private String ccs_flg;
        private String contactId;
        private String errorSpcCode;
        private String errorSpcMessage;

        List<AutoVehicleWebserviceWFContactDto> contact;
        List<AutoVehicleWebserviceWFAccountDto> account;
}
