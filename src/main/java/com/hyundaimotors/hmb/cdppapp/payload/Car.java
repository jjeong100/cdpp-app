package com.hyundaimotors.hmb.cdppapp.payload;

import lombok.Data;

@Data
public class Car {
    private String name;
    private String yearModel;
    private String intentionToChange;
    private String isCurrent;
    private String carModel;
    private String mileage;
    private String clientExpectedValue;
}
