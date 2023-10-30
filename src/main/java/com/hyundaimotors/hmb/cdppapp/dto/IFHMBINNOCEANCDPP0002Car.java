package com.hyundaimotors.hmb.cdppapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class IFHMBINNOCEANCDPP0002Car {    
    public String Name;
    public String YearModel;
    public String IntentionToChange;
    public String isCurrent;
    public String CarModel;
    public String mileage;
    public String ClientExpectedValue;
}
