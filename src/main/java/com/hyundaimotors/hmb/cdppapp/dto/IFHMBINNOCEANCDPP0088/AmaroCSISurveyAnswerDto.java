package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0088;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmaroCSISurveyAnswerDto {
    private String questionId;
    private String questionCode;
    private String questionComments;
    private String answerDescription;
    private String answerValue;
    private String answerComplement;
}
