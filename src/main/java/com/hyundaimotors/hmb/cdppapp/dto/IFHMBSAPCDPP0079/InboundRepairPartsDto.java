package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
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
    private float value;
    private String erdat;
    private String erzet;
    private String aedat;
    private String aezet;
}