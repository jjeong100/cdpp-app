package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboundRepairPartsDto {
    private String soid;
    private String dealercode;
    private String vincode;
    private String itmnum;
    private String sotype;
    private String pncode;
    private String zdesc;
    private float zqty;
    private String unit;
    private float value;
    private float totalValue;
    private String ernam;
    private String erdat;
    private String erzet;
    private String aenam;
    private String aedat;
    private String aezet;
}
