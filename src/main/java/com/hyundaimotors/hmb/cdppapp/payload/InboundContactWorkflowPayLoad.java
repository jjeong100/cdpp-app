package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class InboundContactWorkflowPayLoad {
    
    @Schema(name = "InboundContactWorkflowPayLoad.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "External system unique identifier.", example = "B05AM99999")
        @JsonProperty(value="IntegrationId")
        private String IntegrationId;
        @Schema(description = "Company document number (numbers only)", example = "78753880000164")
        @JsonProperty(value="CPF")
        private String CPF;
        @Schema(description = "FirstName", example = "asmrsfo")
        @JsonProperty(value="FirstName")
        private String FirstName;
        @Schema(description = "LastName", example = "lastasmrfo")
        @JsonProperty(value="LastName")
        private String LastName;
        @Schema(description = "BirthDate", example = "2015-10-10")
        @JsonProperty(value="BirthDate")
        private String BirthDate;
        @Schema(description = "Gender", example = "man")
        @JsonProperty(value="Gender")
        private String Gender;
        @Schema(description = "Source", example = "Call Center")
        @JsonProperty(value="Source")
        private String Source;
        @Schema(description = "HomePhone", example = "2345678")
        @JsonProperty(value="HomePhone")
        private String HomePhone;
        @Schema(description = "HomePhone", example = "3456789")
        @JsonProperty(value="WorkPhone")
        private String WorkPhone;
        @Schema(description = "Contact cell phone.", example = "11941319501")
        @JsonProperty(value="CellPhone")
        private String CellPhone;
        @Schema(description = "Contact email address.", example = "kilosolution2s@gmail.com")
        @JsonProperty(value="EmailAddress")
        private String EmailAddress;
        @Schema(description = "Contact preferred way of contact. Valid values: Uninformed, Email, Mail, Sms, Home phone, Mobile phone, Work phone ", example = "Email")
        @JsonProperty(value="WayOfContact")
        private String WayOfContact;
        @Schema(description = "Contact occupation. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty(value="Occupation")
        private String Occupation;
        @Schema(description = "Contact preferred way of contact. Valid values: Uninformed, Divorced, Married, Partner, Separated, Single, Stable union, Widowed, Others", example = "Single")
        @JsonProperty(value="MaritalStatus")
        private String MaritalStatus;
        @Schema(description = "Contact's income.", example = "R$1.000 or less")
        @JsonProperty(value="Income")
        private String Income;
        @Schema(description = "Contact's car of interest. Valid values: HB20, HB20 FOR YOU, HB20 Spicy, HB20 World Cup, HB20S", example = "HB20")
        @JsonProperty(value="CarOfInterest")
        private String CarOfInterest;
        @Schema(description = "The way contact prefer to be called.", example = "Complete primaty")
        @JsonProperty(value="CalledBy")
        private String CalledBy;
        @Schema(description = "Contact literacy. Valid values: Uninformed, Illiterate, Complete primary", example = "Uniinformed")
        @JsonProperty(value="Literacy")
        private String Literacy;
        @Schema(description = "Behavioral Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty(value="BehavioralSegment")
        private String BehavioralSegment;
        @Schema(description = "Value Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty(value="ValueSegment")
        private String ValueSegment;
        @Schema(description = "Google Segment. Valid values: ", example = "Uniinformed")
        @JsonProperty(value="GoogleSegment")
        private String GoogleSegment;
        @Schema(description = "Facebook Segment. Valid values: ", example = "Uniinformed")
        @JsonProperty(value="FacebookSegment")
        private String FacebookSegment;
        @Schema(description = "Life Cycle Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty(value="LifeCycleSegment")
        private String LifeCycleSegment;
        @Schema(description = "Interest Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty(value="InterestSegment")
        private String InterestSegment;
        @Schema(description = "Opt in defines if contact wants to receive news about retail and services. Valid values: Y, N", example = "Y")
        @JsonProperty(value="ContactOptIn")
        private String ContactOptIn;
        @Schema(description = "Address street name.", example = "Rua Tutoia")
        @JsonProperty(value="StreetAddress")
        private String StreetAddress;
        @Schema(description = "Address house number", example = "380")
        @JsonProperty(value="StreetAddress2")
        private String StreetAddress2;
        @Schema(description = "Address complement.", example = "Andar 3")
        @JsonProperty(value="StreetAddress3")
        private String StreetAddress3;
        @Schema(description = "Address county.", example = "Paraiso")
        @JsonProperty(value="County")
        private String County;
        @Schema(description = "Address city.", example = "Brasil")
        @JsonProperty(value="City")
        private String City;
        @Schema(description = "Address state.", example = "S 00E3o Paulo ")
        @JsonProperty(value="State")
        private String State;
        @Schema(description = "Address zip code.", example = "4007001")
        @JsonProperty(value="PostalCode")
        private String PostalCode;
        @Schema(description = "Flag to define if customer wants all calls suppressed.", example = "Y")
        @JsonProperty(value="SuppressAllCalls")
        private String SuppressAllCalls;
        @Schema(description = "Flag to define if customer wants all mailing suppressed.", example = "Y")
        @JsonProperty(value="SuppressAllMailings")
        private String SuppressAllMailings;
        @Schema(description = "Flag to define if customer wants all emails suppressed.", example = "Y")
        @JsonProperty(value="SuppressAllEmails")
        private String SuppressAllEmails;
        @Schema(description = "Flag to define if customer wants all sms suppressed.", example = "Y")
        @JsonProperty(value="SuppressAllSMS")
        private String SuppressAllSMS;
        @Schema(description = "Printed card flag. Valid values: true, false", example = "True")
        @JsonProperty(value="PrintedCard")
        private String PrintedCard;
        @Schema(description = "Flag to define if customer is already a customer. Valid values: Y, N", example = "N")
        @JsonProperty(value="already_customer")
        private String already_customer;
        @JsonProperty(value="ListOfCurrentCars")
        private List<InboundContactWorkflowCarPayLoad> ListOfCurrentCars;
        @JsonProperty(value="ListOfApps")
        private List<InboundContactWorkflowAppPayLoad> ListOfApps;
        @JsonProperty(value="ListOfSocialMedia")
        private List<InboundContactWorkflowSnsPayLoad> ListOfSocialMedia;
        @JsonProperty(value="ListOfHobby")
        private List<InboundContactWorkflowHobbyPayLoad> ListOfHobby;
        @JsonProperty(value="ListOfSoccerTeam")
        private List<InboundContactWorkflowSoccerTeamPayLoad> ListOfSoccerTeam;
    }
    
    @Schema(name = "InboundContactWorkflowPayLoad.Response")
    @Getter
    @Setter
    public static class Response{
        private String ContactId;
        private String Error_spcCode;
        private String Error_spcMessage;
    }
}
