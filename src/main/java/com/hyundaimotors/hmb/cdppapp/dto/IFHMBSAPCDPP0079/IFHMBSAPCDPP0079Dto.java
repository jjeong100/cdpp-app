package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPCDPP0079Dto {
    InboundRepairDto repair;
    private int rowId;
    private String errorSpcCode;
    private String errorSpcMessage;
}
