package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0025;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ScheduleMaintenanceIN {
    @Schema(description = "Name of requester system.", example = "Source")
    @JsonProperty("Source")
    private String source;
    @Schema(description = "Protocol number. If this value is passed as an input parameter, update operation will be done. If not, insert operation will be done.", example = "HMB8761468242")
    private String srNumber;
    @Schema(description = "Literal value: \"Request\"", example = "Request")
    private String srReason;
    @Schema(description = "Literal value: \"Service\"", example = "Service")
    private String srLevel1;
    @Schema(description = "Literal value: \"Review / Maintenance\"", example = "Review")
    private String srLevel2;
    @Schema(description = "Literal value: \"Scheduling\" ", example = "Scheduling")
    private String srLevel3;
    @Schema(description = "Literal value: \"Customer Request\"", example = "Customer Request")
    private String srLevel4;
    @Schema(description = "ZICARD: Literal value: \"Microsite\"", example = "Microsite")
    private String srSource;
    @Schema(description = "ZICARD: Literal value: \"Internet\"", example = "Internet")
    private String srMethod;
    @Schema(description = "Customer comments.", example = "Eu tenho uma empresa e gostaria de comprar um HB20 para a mesma. O HB20 vir00E1 com desconto para pessoa jur00EDdica?")
    private String srDescription;
    @Schema(description = "Literal value: \"Normal\".", example = "Normal")
    private String srPriority;
    @Schema(description = "SR main status. Possible values are:", example = "Open")
    private String srStatus;
    @Schema(description = "Code for dealer providing maintenance service.", example = "B05AM18005")
    private String dealerCode;
    @Schema(description = "Vehicle chassis.", example = "9BHBG51DADP011617")
    private String chassis;
    @Schema(description = "CPF for customer requesting maintenance service.", example = "37369350720")
    private String customerCPF;
    @Schema(description = "Service consultant CPF number.", example = "40259294810")
    private String consultantCPF;
    @Schema(description = "Service technician CPF number.", example = "13106181788")
    private String technicianCPF;
    @Schema(description = "Service Name. Possible values are: \"1st\u00A0maintenance\", \"2nd\u00A0maintenance\"", example = "6th maintenance")
    private String serviceType;
    @Schema(description = "Maintenance service status. Possible values are: \"Service request\", \"Customer not scheduled\",", example = "Scheduled")
    private String serviceStatus;
    @Schema(description = "Maintenance service car arrival date at dealer.", example = "2016-08-16  10:00:00 AM")
    private String serviceArrivaldate;
    @Schema(description = "Maintenance service's start date.", example = "2017-11-28  9:00:00 AM")
    private String serviceStartdate;
    @Schema(description = "Maintenance service duration in minutes.", example = "50")
    private int serviceDuration;
    @Schema(description = "Maintenance service car delivery date to customer.", example = "2017-11-29")
    private String serviceDeliverydate;
}
