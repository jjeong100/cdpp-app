package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0002;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboundContactWorkflowCarDto {
    public String parRowId;
    public String name;
    public String yearModel;   
    public String intentionToChange;
    public String isCurrent;
    public String carModel;
    public int mileage;
    public int clientExpectedValue;
}
