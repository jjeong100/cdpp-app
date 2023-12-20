package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchContactOutput")
@Getter
@Setter
public class SearchContactOutput {
    @Schema(description = "CNH Expiration Date", example = "2022-05-20")
    @JsonProperty("CNHExpirationDate")
    private String cnheXpirationDate;
    @Schema(description = "Contact Id", example = "1-7890WX")
    @JsonProperty("ContactId")
    private String contactId;
    @Schema(description = "Contact first name", example = "Jose")
    @JsonProperty("FirstName")
    private String firstName;
    @Schema(description = "Contact last name", example = "Ciclano")
    @JsonProperty("LastName")
    private String lastName;
    @Schema(description = "Contact birth date.Format: YYYY-MM-DD", example = "2005-11-24")
    @JsonProperty("BirthDate")
    private String birthDate;
    @Schema(description = "Contact gender. Valid values: Uninformed, Female, Male", example = "Male")
    @JsonProperty("Gender")
    private String gender;
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
    @Schema(description = "Amount Friends", example = "5")
    @JsonProperty("AmountFriends")
    private String amountFriends;
    @Schema(description = "Amount Children", example = "2")
    @JsonProperty("AmountChildren")
    private String amountChildren;
    @Schema(description = "Loyalty OPTINFla", example = "N")
    @JsonProperty("LoyaltyOPTINFla")
    private String loyaltyOPTINFla;
    @Schema(description = "Loyalty Activation Date", example = "2019-01-17")
    @JsonProperty("LoyaltyActivationDate")
    private String loyaltyActivationDate;
    @Schema(description = "Loyalty Expiration Date", example = "2023-01-16")
    @JsonProperty("LoyaltyExpirationDate")
    private String loyaltyExpirationDate;
    @Schema(description = "Loyalty Engagement Index", example = "Uninformed")
    @JsonProperty("LoyaltyEngagementIndex")
    private String loyaltyEngagementIndex;
    @Schema(description = "Loyalty  Satisfaction Level", example = "Uninformed")
    @JsonProperty("LoyaltySatisfactionLevel")
    private String loyaltySatisfactionLevel;
    @Schema(description = "Loyalty CRMI ndex", example = "Warm")
    @JsonProperty("LoyaltyCRMIndex")
    private String loyaltyCRMIndex;
    @Schema(description = "Loyalty Life Cycle", example = "Middle")
    @JsonProperty("LoyaltyLifeCycle")
    private String loyaltyLifeCycle;
    @Schema(description = "Loyalty Tier Level", example = "Uninformed")
    @JsonProperty("LoyaltyTierLevel")
    private String loyaltyTierLevel;
    @Schema(description = "Loyalty Status", example = "Active")
    @JsonProperty("LoyaltyStatus")
    private String loyaltyStatus;
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
    @Schema(description = "Address state.", example = "São Paulo")
    @JsonProperty("State")
    private String state;
    @Schema(description = "Address zip code.", example = "4007001")
    @JsonProperty("PostalCode")
    private String postalCode;
    @Schema(description = "Numeric Row Id", example = "1402214")
    @JsonProperty("NumericRowId")
    private String numericRowId;
    @Schema(description = "Flag to define if customer wants all emails suppressed.", example = "Y")
    @JsonProperty("SuppressAllEmails")
    private String suppressAllEmails;
    @Schema(description = "Flag to define if customer wants all sms suppressed.", example = "Y")
    @JsonProperty("SuppressAllSMS")
    private String suppressAllSMS;
    @Schema(description = "Printed card flag. Valid values: true, false", example = "TRUE")
    @JsonProperty("PrintedCard")
    private String printedCard;
    @JsonProperty("AutoVehicle")
    List<SearchAutoVehicle> autoVehicle;
    @JsonProperty("Campaign")
    List<SearchCampaign> campaign;
    @JsonProperty("ContactHobby")
    List<SearchContactHobby> contactHobby;
    @JsonProperty("ContactSoccerTeam")
    List<SearchSoccerTeam> contactSoccerTeam;
    @JsonProperty("ContactSocialMedia")
    List<SearchSocialMedia> contactSocialMedia;
    @JsonProperty("ContactUtilizedApps")
    List<SearchUtilizedApps> contactUtilizedApps;
    @JsonProperty("CSISurvey")
    List<SearchCSISurvey> csiSurvey;
    @JsonProperty("ServiceRequest")
    List<SearchServiceRequestContact> serviceRequest;
}
