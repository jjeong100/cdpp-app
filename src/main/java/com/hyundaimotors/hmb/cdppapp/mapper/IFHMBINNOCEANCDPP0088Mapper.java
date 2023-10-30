package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0088.IFHMBINNOCEANCDPP0088Dto;

public interface IFHMBINNOCEANCDPP0088Mapper {

    public String getProcId(IFHMBINNOCEANCDPP0088Dto dto)throws Exception;
    
    public void insertAmaroCSISurvey(IFHMBINNOCEANCDPP0088Dto dto)throws Exception;

    public void insertAmaroCSISurveyAnswer(IFHMBINNOCEANCDPP0088Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;
}
