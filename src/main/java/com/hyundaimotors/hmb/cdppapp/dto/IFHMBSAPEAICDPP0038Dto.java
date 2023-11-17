package com.hyundaimotors.hmb.cdppapp.dto;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038.Interaction;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038.Temperature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0038Dto {
    private int rowId;
    private String protocol;
    private String result;
    private String integrationId;
    private String salesStatus;
    private String saleCPF;
    private String status;
    private String firstInteractionDate;
    private String saleReason;
    private String endDate;
    private String dlrReceiveDate;
    private String dlrResponseTime;
    private String pcd;
    private String source;
    private String schedvisit;
    private String visitdate;
    private String visitstat;
    List<Temperature> listOfTemperature;
    List<Interaction> listOfInteraction;
    private String actionId;
    private String ErrorSpcCode;
    private String ErrorSpcMessage;
}
