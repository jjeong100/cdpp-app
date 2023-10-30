package com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchContactOutputDto {
    private String cnheXpirationDate;
    private String contactId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String homePhone;
    private String workPhone;
    private String cellPhone;
    private String emailAddress;
    private String amountFriends;
    private String amountChildren;
    private String loyaltyOPTINFla;
    private String loyaltyActivationDate;
    private String loyaltyExpirationDate;
    private String loyaltyEngagementIndex;
    private String loyaltySatisfactionLevel;
    private String loyaltyCRMIndex;
    private String loyaltyLifeCycle;
    private String loyaltyTierLevel;
    private String loyaltyStatus;
    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String county;
    private String city;
    private String state;
    private String postalCode;
    private String numericRowId;
    private String suppressAllEmails;
    private String suppressAllSMS;
    private String printedCard;
    List<SearchAutoVehicleDto> listOfAutoVehicle;
    List<SearchCampaignDto> listOfCampaign;
    List<SearchContactHobbyDto> listOfContactHobby;
    List<SearchSoccerTeamDto> listOfContactSoccerTeam;
    List<SearchSocialMediaDto> listOfContactSocialMedia;
    List<SearchUtilizedAppsDto> listOfContactUtilizedApps;
    List<SearchCSISurveyDto> listOfCSISurvey;
}
