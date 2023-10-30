package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleMaintenanceINDto {
    private int rowId;
    private String source;
    private String srNumber;
    private String srReason;
    private String srLevel1;
    private String srLevel2;
    private String srLevel3;
    private String srLevel4;
    private String srSource;
    private String srMethod;
    private String srDescription;
    private String srPriority;
    private String srStatus;
    private String dealerCode;
    private String chassis;
    private String customerCPF;
    private String consultantCPF;
    private String technicianCPF;
    private String serviceType;
    private String serviceStatus;
    private String serviceArrivaldate;
    private String serviceStartdate;
    private int serviceDuration;
    private String serviceDeliverydate;
}
