package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0063;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Contact")
@Getter
@Setter
public class ContactGetVin {
    @JsonProperty("IdSiebel")
    private String idSiebel;
    @JsonProperty("RelatedType")
    private String relatedType;
    @JsonProperty("RelatedStatus")
    private String relatedStatus;
    @JsonProperty("SuppressAllCalls")
    private String suppressAllCalls;
    @JsonProperty("SuppressAllEmails")
    private String suppressAllEmails;
    @JsonProperty("SuppressAllMailings")
    private String suppressAllMailings;
    @JsonProperty("SuppressAllMobilePhone")
    private String suppressAllMobilePhone;
    @JsonProperty("SuppressAllSMS")
    private String suppressAllSMS;
    @JsonProperty("SuppressAllVideoCall")
    private String suppressAllVideoCall;
    @JsonProperty("SuppressAllWhatsapp")
    private String suppressAllWhatsapp;
}