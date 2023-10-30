package com.hyundaimotors.hmb.cdppapp.dto;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015.Color;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0015Dto {
    private String rowId;
    private String source;

    List<Color> listOfColor; 

    private String errorSpcCode;
    private String errorSpcMessage;
}
