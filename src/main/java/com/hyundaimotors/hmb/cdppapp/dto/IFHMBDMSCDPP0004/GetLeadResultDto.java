package com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadResultDto {
    private String firstInteractionDate;
    private String saleStatus;
    private String reason;
    private String result;
    private String saleCPF;
    private String endDate;
    private String dlrReceiveDate;
    private double dlrResponseTime;
}
