package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0088;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0088Dto {
    private String integrationId;
    private String assetId;
    private String contactId;
    private String accountId;
    private String dealerId;
    private String researchDate;
    private String researchName;
    private String source;
    private String status;
    private String substatus;
    private String ratingAll;
    private String ratingAttendant;
    private String ratingMechanic;
    private String snaCode;
    private String snaDate;
    private String snaType;
    private String snaComment;
    private String srProtocol;
    private String serialNumber;
    private int rowId;
    List<AmaroCSISurveyAnswerDto> listOfAmaroCSISurveyAnswer;
    private String ErrorSpcCode;
    private String ErrorSpcMessage;
}
