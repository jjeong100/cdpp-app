package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0025;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ScheduleMaintenanceIN {
    @Schema(description = "Name of requester system.", example = "Source")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("Source")
    private String source;
    @Schema(description = "Protocol number. If this value is passed as an input parameter, update operation will be done. If not, insert operation will be done.", example = "HMB8761468242")
    private String srNumber;
    @Schema(description = "Literal value: \"Request\"", example = "Request")
    @NotNull @NotBlank @NotEmpty
    private String srReason;
    @Schema(description = "Literal value: \"Service\"", example = "Service")
    @NotNull @NotBlank @NotEmpty
    private String srLevel1;
    @Schema(description = "Literal value: \"Review / Maintenance\"", example = "Review")
    @NotNull @NotBlank @NotEmpty
    private String srLevel2;
    @Schema(description = "Literal value: \"Scheduling\" ", example = "Scheduling")
    @NotNull @NotBlank @NotEmpty
    private String srLevel3;
    @Schema(description = "Literal value: \"Customer Request\"", example = "Customer Request")
    @NotNull @NotBlank @NotEmpty
    private String srLevel4;
    @Schema(description = "ZICARD: Literal value: \"Microsite\"", example = "Microsite")
    @NotNull @NotBlank @NotEmpty
    private String srSource;
    @Schema(description = "ZICARD: Literal value: \"Internet\"", example = "Internet")
    @NotNull @NotBlank @NotEmpty
    private String srMethod;
    @Schema(description = "Customer comments.", example = "Eu tenho uma empresa e gostaria de comprar um HB20 para a mesma. O HB20 vir00E1 com desconto para pessoa jur00EDdica?")
    private String srDescription;
    @Schema(description = "Literal value: \"Normal\".", example = "Normal")
    @NotNull @NotBlank @NotEmpty
    private String srPriority;
    @Schema(description = "SR main status. Possible values are:", example = "Open")
    private String srStatus;
    @Schema(description = "Code for dealer providing maintenance service.", example = "B05AM18005")
    @NotNull @NotBlank @NotEmpty
    private String dealerCode;
    @Schema(description = "Vehicle chassis.", example = "9BHBG51DADP011617")
    @NotNull @NotBlank @NotEmpty
    private String chassis;
    @Schema(description = "CPF for customer requesting maintenance service.", example = "37369350720")
    @NotNull @NotBlank @NotEmpty
    private String customerCPF;
    @Schema(description = "Service consultant CPF number.", example = "40259294810")
    private String consultantCPF;
    @Schema(description = "Service technician CPF number.", example = "13106181788")
    private String technicianCPF;
    @Schema(description = "Service Name. Possible values are: \"1st\u00A0maintenance\", \"2nd\u00A0maintenance\"", example = "6th maintenance")
    @NotNull @NotBlank @NotEmpty
    private String serviceType;
    @Schema(description = "Maintenance service status. Possible values are: \"Service request\", \"Customer not scheduled\",", example = "Scheduled")
    @NotNull @NotBlank @NotEmpty
    private String serviceStatus;
    @Schema(description = "Maintenance service car arrival date at dealer.", example = "2023-05-04T16:30:32-0300")
    @NotNull @NotBlank @NotEmpty
    private String serviceArrivaldate;
    @Schema(description = "Maintenance service's start date.", example = "2023-05-04T16:30:32-0300")
    private String serviceStartdate;
    @Schema(description = "Maintenance service duration in minutes.", example = "50")
    private int serviceDuration;
    @Schema(description = "Maintenance service car delivery date to customer.", example = "2023-05-04T16:30:32-0300")
    private String serviceDeliverydate;
}
