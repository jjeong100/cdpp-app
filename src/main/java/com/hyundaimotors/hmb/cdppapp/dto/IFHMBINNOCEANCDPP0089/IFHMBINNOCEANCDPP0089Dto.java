package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0089Dto {
    
    private String startDate;
    private String endDate;
    private String ErrorSpcCode;
    private String ErrorSpcMessage;
    List<SatisfactionSurveyDto> listOfSatisfactionSurvey;
}
