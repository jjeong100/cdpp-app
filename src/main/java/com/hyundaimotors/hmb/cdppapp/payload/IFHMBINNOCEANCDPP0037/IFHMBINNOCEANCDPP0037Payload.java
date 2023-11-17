package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.UpdateContactInputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0037Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0037Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Contact Id", example = "1-40O0EX4")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("ContactId")
        private String contactId;
        @Schema(description = "CNH Expiration Date", example = "2025-10-05T00:00:00-0300")
        @JsonProperty("CNHExpirationDate")
        private String cnheXpirationDate;
        @Schema(description = "Contact first name", example = "Jose")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("FirstName")
        private String firstName;
        @Schema(description = "Contact last name", example = "Ciclano")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("LastName")
        private String lastName;
        @Schema(description = "Contact birth date. Format: YYYY-MM-DD", example = "1996-02-22T00:00:00-0300")
        @JsonProperty("BirthDate")
        private String birthDate;
        @Schema(description = "Contact gender. Valid values: Uninformed, Female, Male", example = "Male")
        @JsonProperty("Genre")
        private String genre;
        @Schema(description = "HKMERetailDate", example = "2020-05-10T00:00:00-0300")
        @JsonProperty("HKMERetailDate")
        private String hkmeRetailDate;
        @Schema(description = "Contact home phone.", example = "+551141319501")
        @JsonProperty("HomePhone")
        private String homePhone;
        @Schema(description = "Contact work phone.", example = "+551141319501")
        @JsonProperty("WorkPhone")
        private String workPhone;
        @Schema(description = "Contact cell phone.", example = "+5511941319501")
        @JsonProperty("CellularPhone")
        private String cellularPhone;
        @Schema(description = "Contact email address.", example = "kilosolution2s@gmail.com")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("EmailAddress")
        private String emailAddress;
        @Schema(description = "Amount Friends", example = "5")
        @JsonProperty("AmountFriends")
        private int amountFriends;
        @Schema(description = "Amount Children", example = "2")
        @JsonProperty("AmountChildren")
        private int amountChildren;
        @Schema(description = "Loyalty OPTINFla", example = "N")
        @JsonProperty("LoyaltyOPTINFlag")
        private String loyaltyOPTINFlag;
        @Schema(description = "Address street name.", example = "Rua Tutoia")
        @JsonProperty("StreetAddress")
        private String streetAddress;
        @Schema(description = "Address house number", example = "380")
        @JsonProperty("AddressNumber")
        private String addressNumber;
        @Schema(description = "Address complement.", example = "Andar 3")
        @JsonProperty("AddressComplement")
        private String addressComplement;
        @Schema(description = "Address Country", example = "counrty")
        @JsonProperty("AddressCountry")
        private String addressCountry;
        @Schema(description = "Address county.", example = "Paraiso")
        @JsonProperty("AddressCounty")
        private String addressCounty;
        @Schema(description = "Address city.", example = "Brasil")
        @JsonProperty("AddressCity")
        private String addressCity;
        @Schema(description = "Address state.", example = "Sao Paulo")
        @JsonProperty("AddressState")
        private String addressState;
        @Schema(description = "Address zip code.", example = "4007001")
        @JsonProperty("AddressPostalCode")
        private String addressPostalCode;
        @Schema(description = "Flag to define if customer wants all emails suppressed.", example = "Y")
        @JsonProperty("SuppressAllEmails")
        private String suppressAllEmails;
        @Schema(description = "Flag to define if customer wants all mailing suppressed.", example = "Y")
        @JsonProperty("SuppressAllMailings")
        private String suppressAllMailings;
        @Schema(description = "Flag to define if customer wants all calls suppressed.", example = "N")
        @JsonProperty("SuppressAllCalls")
        private String suppressAllCalls;
        @Schema(description = "Flag to define if customer wants all whatsapp suppressed.", example = "N")
        @JsonProperty("SuppressAllWhatsapp")
        private String suppressAllWhatsapp;
        @Schema(description = "Flag to define if customer wants all mobile suppressed.", example = "N")
        @JsonProperty("SuppressAllMobile")
        private String suppressAllMobile;
        @Schema(description = "Flag to define if customer wants all videocall suppressed.", example = "N")
        @JsonProperty("SuppressAllVideoCall")
        private String suppressAllVideoCall;
        @Schema(description = "Flag to define if customer wants all sms suppressed.", example = "Y")
        @JsonProperty("SuppressAllSMS")
        private String suppressAllSMS;
        @Schema(description = "Printed card flag. Valid values: true, false", example = "true")
        @JsonProperty("HMBPrintedCard")
        private String hmbPrintedCard;

        @Valid @JsonProperty("ListOfAutoVehicle")
        List<ListOfAutoVehicle> listOfAutoVehicle;
        @JsonProperty("ListOfContactSocialMedia")
        List<ListOfContactSocialMedia> listOfContactSocialMedia;

    }

    @Schema(name = "IFHMBINNOCEANCDPP0037Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("ContactId")
        private String contactId;
        @JsonProperty("Error_spcCode")
        private String error_spcCode;
        @JsonProperty("Error_spcMessage")
        private String error_spcMessage;

        @JsonProperty("UpdateContact_Input")
        UpdateContactInputDto UpdateContactInput;

        @JsonProperty("Contact")
        ContactData updateContactOutput;

    }
}
