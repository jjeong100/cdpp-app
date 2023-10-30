package com.hyundaimotors.hmb.cdppapp.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ApiLogDto {
    private Integer seqNo;
    private String ifId;
    private Timestamp createdAt;
    private Timestamp lastModAt;
    private Timestamp ifRequestAt;
    private Timestamp ifResponseAt;
    private Timestamp ifStep1At;
    private Timestamp ifStep2At;
    private Timestamp ifStep3At;
    private String ifReqJson;
    private String ifResJson;
    private String ifErrFlag;
    private String ifErrMsg;
    private String ifTrId;
}
