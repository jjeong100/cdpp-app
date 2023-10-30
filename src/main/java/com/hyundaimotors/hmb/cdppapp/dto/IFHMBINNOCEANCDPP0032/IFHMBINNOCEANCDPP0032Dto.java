package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0032Dto {

    private String cpf;
    private String contactId;

    private String errorSpcCode;
    private String errorSpcMessage;
    
    private List<SearchContactTDDto> listOfSearchContactTD;
}
