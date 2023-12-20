package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0026Dto {
    List<String> listParamId;
    private String error_spcCode;
    private String error_spcMessage;
    
    List<ListOfProductDto> listOfProduct;
}
