package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0032.ServiceRequestTD;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchContactTDDto {
    private String firstName;
    private String lastName;
    private String cpf;
    private String genre;
    private String birthDate;
    private String cellularPhone;
    private String homePhone;
    private String emailAddress;
    private String workPhone;
    private String rowId;
    private String amountFriends;
    private String amountChildren;
    private String cnhexpirationDate;
    private String loyaltyActivationDate;
    private String loyaltyExpirationDate;
    private String loyaltyEngagementIndex;
    private String loyaltySatisfactionLevel;
    private String loyaltyCRMIndex;
    private String loyaltyLifeCycle;
    private String loyaltyTierLevel;
    private String loyaltyStatus;
    private String loyaltyOPTINFla;
    private String hmbPrintedCard;
    private String suppressAllEmails;
    private String suppressAllSMS;
    private String postalCode;
    private String street;
    private String number;
    private String complement;
    private String county;
    private String city;
    private String State;

    private List<ServiceRequestTD> listOfServiceRequest;
}
