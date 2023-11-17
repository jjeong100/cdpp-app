package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSELFBICDPP0062Dto {
    private String errorSpcCode;
    private String errorSpcMessage;
    private String date;
    private String created;
    private String voc;
    private String lead;
    // TotalLeadDto totallead;
    List<TotalLeadDto> totallead;
}
