package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0012;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012.ChannelPartnerContact;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelPartnerDto {
    private String integrationId;
    private String cnpj;
    private String name;
    private String nickname;
    private String accountStatus;
    private String reasonStatus;
    private String dealerType;
    private String dealerCode;
    private String mainPhone;
    private String fax;
    private String mainEmailAddress;
    private String workEmailAddress;
    private String salesDealerFlag;
    private String serviceDealerFlag;
    private String partnerStartDate;
    private String partnerEndDate;
    private String region;
    private String workingHour;
    private String facebookPage;
    private String homepage;
    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String city;
    private String state;
    private String neighborhood;
    private String latitude;
    private String longitude;
    private String zipCode;
    private String csn;
    private String id;

    List<ChannelPartnerContact> channelPartnerContact;
}
