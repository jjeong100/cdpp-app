package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactGetVinDto {
    private String idSiebel;
    private String relatedType;
    private String relatedStatus;
    private String suppressAllCalls;
    private String suppressAllEmails;
    private String suppressAllMailings;
    private String suppressAllMobilePhone;
    private String suppressAllSMS;
    private String suppressAllVideoCall;
    private String suppressAllWhatsapp;
}
