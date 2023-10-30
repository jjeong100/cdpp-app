package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactSocialMedia {
    @JsonProperty("ContactSocialMedia")
    ListOfContactSocialMedia contactSocialMedia;
    
}
