package com.hyundaimotors.hmb.cdppapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPEAICDPP0003Dto {
    
    private String rowId;
    private String name;
    private String source;
    private String type;
    private String part;
    private String advdesc; 
    private int modelYear;
    private String chassiModel; 
    private String bodyStyle;
    private String hmbCylindercapacity;
    private String engine;
    private String engineDesc;
    private String versionDesc; 
    private String transmissionDesc;
    private String transmission;
    private String fuel;
    private int doorsAmnt;
    private float suggestedPrice;
    private String description;
    private String productTypeCode;
    
    private String errorSpcCode;
    private String errorSpcMessage;
    private String processProductId;
}
