package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "UpdateContactOutput")
@Getter
@Setter
public class ContactData {
        @JsonProperty("ContactId")
        private String contactId;
        @JsonProperty("CNHExpirationDate")
        private String cnheXpirationDate;
        @JsonProperty("FirstName")
        private String firstName;
        @JsonProperty("LastName")
        private String lastName;
        @JsonProperty("BirthDate")
        private String birthDate;
        @JsonProperty("Genre")
        private String gender;
        @JsonProperty("HKMERetailDate")
        private String retailDate;
        @JsonProperty("HomePhone")
        private String homePhone;
        @JsonProperty("WorkPhone")
        private String workPhone;
        @JsonProperty("CellularPhone")
        private String cellPhone;
        @JsonProperty("EmailAddress")
        private String emailAddress;
        @JsonProperty("AmountFriends")
        private String amountFriends;
        @JsonProperty("AmountChildren")
        private String amountChildren;
        @JsonProperty("LoyaltyOPTINFlag")
        private String loyaltyOPTINFla;
        @JsonProperty("StreetAddress")
        private String streetAddress;
        @JsonProperty("AddressNumber")
        private String streetAddress2;
        @JsonProperty("AddressComplement")
        private String streetAddress3;
        @JsonProperty("AddressCountry")
        private String country;
        @JsonProperty("AddressCounty")
        private String county;
        @JsonProperty("AddressCity")
        private String city;
        @JsonProperty("AddressState")
        private String state;
        @JsonProperty("AddressPostalCode")
        private String postalCode;
        @JsonProperty("SuppressAllEmails")
        private String suppressAllEmails;
        @JsonProperty("SuppressAllMailings")
        private String suppressAllMailings;
        @JsonProperty("SuppressAllCalls")
        private String suppressAllCalls;
        @JsonProperty("SuppressAllWhatsapp")
        private String suppressAllWhatsapp;
        @JsonProperty("SuppressAllMobile")
        private String suppressAllMobile;
        @JsonProperty("SuppressAllVideoCall")
        private String suppressAllVideoCall;
        @JsonProperty("SuppressAllSMS")
        private String suppressAllSMS;
        @JsonProperty("HMBPrintedCard")
        private String hmbPrintedCard;

        @JsonProperty("ListOfAutoVehicle")
        List<AutoVehicle> listOfAutoVehicle;
        @JsonProperty("ListOfContactSocialMedia")
        List<ContactSocialMedia> listOfContactSocialMedia;
}
