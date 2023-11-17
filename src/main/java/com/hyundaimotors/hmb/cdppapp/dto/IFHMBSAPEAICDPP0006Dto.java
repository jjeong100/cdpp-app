package com.hyundaimotors.hmb.cdppapp.dto;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.ActionNote;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.ActionProducts;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.SynergyActionAudit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0006Dto {
    private int rowId;
    private String integrationId;
    private String result;
    private String answer;
    private String status;
    private String hotlineId;
    private String hotlineCreation;
    private String pwaId;
    private String pwaCreation;
    private String roId;
    private String roCreation;
    private String mobisId;
    private String mobisStatus;
    private String expectedDelivery;
    private String purchasePurposeId;
    private String type;
    private String srProtocol;
    private String priority;
    private String owner;
    private String description;
    private String contactId;
    private String dealerCode;
    private String serialNumber;
    private String creationDate;
    private String plannedDt;
    private String orderNum;
    private String dpUser;
    private String estoque;

    ActionNote actionNote;
    ActionProducts actionProducts;
    SynergyActionAudit synergyActionAudit;
    
    private String actionId;
    private String errorSpcCode;
    private String errorSpcMessage;
}
