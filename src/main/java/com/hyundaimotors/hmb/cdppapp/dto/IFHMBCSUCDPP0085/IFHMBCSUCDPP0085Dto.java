package com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBCSUCDPP0085Dto {
    private String vcep;
    private String vService;
    private String vSales;
    private String source;
    private String errorSpcCode;
    private String errorSpcMessage;
    private String objectSpcId;
    private String processSpcInstanceSpcId;
    private String connexSpcOperationSpcObjectSpcId;
    private ChannelPartnerCSUDto channelPartner;
}
