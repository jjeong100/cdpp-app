package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfContactSocialMedia;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ContactData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0037Dto {
    private int rowId;
    private String contactId;
    private String cnheXpirationDate;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String genre;
    private String hkmeRetailDate;
    private String homePhone;
    private String workPhone;
    private String cellularPhone;
    private String emailAddress;
    private int amountFriends;
    private int amountChildren;
    private String loyaltyOPTINFlag;
    private String streetAddress;
    private String addressNumber;
    private String addressComplement;
    private String addressCountry;
    private String addressCounty;
    private String addressCity;
    private String addressState;
    private String addressPostalCode;
    private String suppressAllEmails;
    private String suppressAllMailings;
    private String suppressAllCalls;
    private String suppressAllWhatsapp;
    private String suppressAllMobile;
    private String suppressAllVideoCall;
    private String suppressAllSMS;
    private String hmbPrintedCard;

    private String processAccountRowId;
    private String processContactRowId;
    private String error_spcCode;
    private String error_spcMessage;
    UpdateContactInputDto updateContactInput;

    List<ListOfAutoVehicleDto> listOfAutoVehicle;
    List<ListOfContactSocialMedia> listOfContactSocialMedia;

    ContactData updateContactOutput;

}
