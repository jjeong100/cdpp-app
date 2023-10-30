package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSMARTERSCDPP0036Dto {
    private int rowId;
    private String ownedById;
    private String processProtocol;
    ServiceRequestChatInputDto serviceRequestChatInput;
    

    private String errorSpcCode;
    private String errorSpcMessage;
}
