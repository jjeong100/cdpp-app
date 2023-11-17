package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0002Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0002Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "External system unique identifier.", example = "1-7890WX")
        @JsonProperty("IntegrationId")
        private String integrationId;
        @Schema(description = "Individual's document number (numbers only)", example = "12337343006")
        @JsonProperty("CPF")
        private String cpf;
        @NotNull @NotBlank @NotEmpty
        @Schema(description = "Contact first name", example = "Jose")
        @JsonProperty("FirstName")
        private String firstName;
        @NotNull @NotBlank @NotEmpty
        @Schema(description = "Contact last name", example = "Ciclano")
        @JsonProperty("LastName")
        private String lastName;
        @Schema(description = "Contact birth date - Format: MM/DD/YYYY", example = "2005-11-24")
        @JsonProperty("BirthDate")
        private String birthDate;
        @Schema(description = "Contact gender. Valid values: Uninformed, Female, Male", example = "Male")
        @JsonProperty("Gender")
        private String gender;
        @Schema(description = "External source. Valid values: Call Center, Dealer, Home Page, Marketing, Sap ", example = "Call Center")
        @JsonProperty("Source")
        private String source;
        @Schema(description = "Contact home phone.", example = "2345678")
        @JsonProperty("HomePhone")
        private String homePhone;
        @Schema(description = "Contact work phone.", example = "3456789")
        @JsonProperty("WorkPhone")
        private String workPhone;
        @Schema(description = "Contact cell phone.", example = "11941319501")
        @JsonProperty("CellPhone")
        private String cellPhone;        
        @Schema(description = "Contact email address.", example = "kilosolution2s@gmail.com")
        @JsonProperty("EmailAddress")
        private String emailAddress;
        @Schema(description = "Contact preferred way of contact. Valid values: Uninformed, Email, Mail, Sms, Home phone, Mobile phone, Work phone ", example = "Email")
        @JsonProperty("WayOfContact")
        private String wayOfContact;
        @Schema(description = "Contact occupation. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty("Occupation")
        private String occupation;
        @Schema(description = "Contact preferred way of contact. Valid values: Uninformed, Divorced, Married, Partner, Separated, Single, Stable union, Widowed, Others", example = "Single")
        @JsonProperty("MaritalStatus")
        private String maritalStatus;
        @Schema(description = "Contact's income.", example = "R$1.000 or less")
        @JsonProperty("Income")
        private String income;
        @Schema(description = "Contact's car of interest. Valid values: HB20, HB20 FOR YOU, HB20 Spicy, HB20 World Cup, HB20S", example = "HB20")
        @JsonProperty("CarOfInterest")
        private String carOfInterest;
        @Schema(description = "The way contact prefer to be called.", example = "Complete primaty")
        @JsonProperty("CalledBy")
        private String calledBy;
        @Schema(description = "Contact literacy. Valid values: Uninformed, Illiterate, Complete primary", example = "Uniinformed")
        @JsonProperty("Literacy")
        private String literacy;
        @Schema(description = "Behavioral Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty("BehavioralSegment")
        private String behavioralSegment;
        @Schema(description = "Value Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty("ValueSegment")
        private String valueSegment;
        @Schema(description = "Google Segment. Valid values: ", example = "Uniinformed")
        @JsonProperty("GoogleSegment")
        private String googleSegment;
        @Schema(description = "Facebook Segment. Valid values: ", example = "Uniinformed")
        @JsonProperty("FacebookSegment")
        private String facebookSegment;
        @Schema(description = "Life Cycle Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty("LifeCycleSegment")
        private String lifeCycleSegment;
        @Schema(description = "Interest Segment. Valid values: Uninformed", example = "Uniinformed")
        @JsonProperty("InterestSegment")
        private String interestSegment;
        @Schema(description = "Opt in defines if contact wants to receive news about retail and services. Valid values: Y, N", example = "Y")
        @JsonProperty("ContactOptIn")
        private String contactOptIn;
        @Schema(description = "Address street name.", example = "Rua Tutoia")
        @JsonProperty("StreetAddress")
        private String streetAddress;
        @Schema(description = "Address house number", example = "380")
        @JsonProperty("StreetAddress2")
        private String streetAddress2;
        @Schema(description = "Address complement.", example = "Andar 3")
        @JsonProperty("StreetAddress3")
        private String streetAddress3;
        @Schema(description = "Address county.", example = "Paraiso")
        @JsonProperty("County")
        private String county;
        @Schema(description = "Address city.", example = "Brasil")
        @JsonProperty("City")
        private String city;
        @Schema(description = "Address state.", example = "S\u00E3o Paulo ")
        @JsonProperty("State")
        private String state;
        @Schema(description = "Address zip code.", example = "4007001")
        @JsonProperty("PostalCode")
        private String postalCode;
        @Schema(description = "Flag to define if customer wants all calls suppressed.", example = "Y")
        @JsonProperty("SuppressAllCalls")
        private String suppressAllCalls;
        @Schema(description = "Flag to define if customer wants all mailing suppressed.", example = "Y")
        @JsonProperty("SuppressAllMailings")
        private String suppressAllMailings;
        @Schema(description = "Flag to define if customer wants all emails suppressed.", example = "Y")
        @JsonProperty("SuppressAllEmails")
        private String suppressAllEmails;
        @Schema(description = "Flag to define if customer wants all sms suppressed.", example = "Y")
        @JsonProperty("SuppressAllSMS")
        private String suppressAllSMS;
        @Schema(description = "Flag to define if customer wants all videocall suppressed.", example = "Y")
        @JsonProperty("SuppressAllVideoCall")
        private String suppressAllVideoCall;
        @Schema(description = "Flag to define if customer wants all whatsapp suppressed.", example = "Y")
        @JsonProperty("SuppressAllWhatsapp")
        private String suppressAllWhatsapp;
        @Schema(description = "Flag to define if customer wants all mobile suppressed.", example = "Y")
        @JsonProperty("SuppressAllMobile")
        private String suppressAllMobile;
        // 20231110 테이블 char 1 example = "true" => "Y" 변경
        @Schema(description = "Printed card flag. Valid values: true, false", example = "Y")
        @JsonProperty("PrintedCard")
        private String printedCard;
        @Schema(description = "Flag to define if customer is already a customer. Valid values: Y, N", example = "N")
        @JsonProperty("already_customer")
        private String alreadyCustomer;
        @Schema(description = "Favorite_Dealer", example = "B05AM58024")
        @JsonProperty("Favorite_Dealer")
        private String favorite_dealer;

        @JsonProperty("ListOfCurrentCars")
        List<InboundContactWorkflowCarPayLoad> listOfCurrentCars;
        @JsonProperty("ListOfApps")
        List<InboundContactWorkflowAppPayLoad> listOfApps;
        @JsonProperty("ListOfSocialMedia")
        List<InboundContactWorkflowSnsPayLoad> listOfSocialMedia;
        @JsonProperty("ListOfHobby")
        List<InboundContactWorkflowHobbyPayLoad> listOfHobby;
        @JsonProperty("ListOfSoccerTeam")
        List<InboundContactWorkflowSoccerTeamPayLoad> listOfSoccerTeam;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0002Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Contact Identifier.")
        @JsonProperty("ContactId")
        private String contactId;
        @Schema(description = "Connex error code. Code 200 means success.", example = "200")
        @JsonProperty("Error_spcCode")
        private String error_spcCode;
        @Schema(description = "Connex error message.", example = "success")
        @JsonProperty("Error_spcMessage")
        private String error_spcMessage;
    }
}
