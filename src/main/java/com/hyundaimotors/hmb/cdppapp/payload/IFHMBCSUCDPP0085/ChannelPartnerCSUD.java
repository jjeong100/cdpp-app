package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0085;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelPartnerCSUD {
    @JsonProperty("HMBIntegrationId")
    private String integrationId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Nickname")
    private String nickName;
    @JsonProperty("DealerCode")
    private String dealerCode;
    @JsonProperty("Telephone")
    private String mainPhone;
    @JsonProperty("Whatsapp")
    private String whatsappPhoneNumber;
    @JsonProperty("Address")
    private String streetAddress;
    @JsonProperty("Number")
    private String streetAddress2;
    @JsonProperty("Complement")
    private String streetAddress3;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("County")
    private String neighborhood;
    @JsonProperty("Cep")
    private String zipCode;
    @JsonProperty("PartyId")
    private String partyId;
    @JsonProperty("PartyTypeCode")
    private String partyTypeCode;
    @JsonProperty("PartyUId")
    private String partyUId;
}
