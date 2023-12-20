package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015.Color;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0015Dto {
    private String source;
    List<String> paramList;
    List<ColorDto> listOfColor; 

    private String errorSpcCode;
    private String errorSpcMessage;
}
