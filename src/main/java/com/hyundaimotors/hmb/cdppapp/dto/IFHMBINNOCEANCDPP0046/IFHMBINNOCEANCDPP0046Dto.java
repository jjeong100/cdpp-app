package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0046;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0046.ListOfServices;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0046Dto {
    private int rowId;
    private String dealerCode;
    private String source;
    private String parRowId;
    private List<ListOfServices> listOfServices;
    private String errorSpcCode;
    private String errorSpcMessage;

    ManageDealerServiceOutDto ManageDealerServiceOut;
}

