package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0085;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelPartnerCSUD {
    @JsonProperty("IntegrationId")
    private String integrationId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Nickname")
    private String nickName;
    @JsonProperty("DealerCode")
    private String dealerCode;
    @JsonProperty("MainPhone")
    private String mainPhone;
    @JsonProperty("WhatsappPhoneNumber")
    private String whatsappPhoneNumber;
    @JsonProperty("StreetAddress")
    private String streetAddress;
    @JsonProperty("StreetAddress2")
    private String streetAddress2;
    @JsonProperty("StreetAddress3")
    private String streetAddress3;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Neighborhood")
    private String neighborhood;
    @JsonProperty("ZipCode")
    private String zipCode;
    @JsonProperty("PartyId")
    private String partyId;
    @JsonProperty("PartyTypeCode")
    private String partyTypeCode;
    @JsonProperty("PartyUId")
    private String partyUId;
}
