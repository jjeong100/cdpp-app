package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0013Dto {
    private int rowId;
    private String integrationId;
    private String cnpj;
    private String name;
    private String nickname;
    private String accountStatus;
    private String reasonStatus;
    private String dealerType;
    private String dealerCode;
    private String mainPhone;
    private String fax;
    private String mainEmailAddress;
    private String workEmailAddress;
    private String salesDealerFlag;
    private String serviceDealerFlag;
    private String partnerStartDate;
    private String partnerEndDate;
    private String region;
    private String workingHours;
    private String facebookPage;
    private String homepage;
    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String county;
    private String city;
    private String state;
    private int latitude;
    private int longitude;
    private String postalCode;

    private String dealerGroup;
    private String salesGroup;
    private String salesManager;
    private String serviceManager;
    private String serviceWhatsAppNumber;
    private String salesWhatsAppNumber;
    private String salesDistrict;
    private String salesOffice;
    private String division;

    private String procRowId;

    private String errorSpcCode;
    private String errorSpcMessage;
    List<ListOfContactsDto> contactList;

    List<String> listOfProcContactRowId;
}
