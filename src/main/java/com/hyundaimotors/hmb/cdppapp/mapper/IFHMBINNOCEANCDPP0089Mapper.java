package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.IFHMBINNOCEANCDPP0089Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.SatisfactionSurveyDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.SurveyAccountDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.SurveyContactDto;

public interface IFHMBINNOCEANCDPP0089Mapper {
    
    public List<SatisfactionSurveyDto> getSatisfactionSurveyList(IFHMBINNOCEANCDPP0089Dto dto)throws Exception;

    public List<SurveyContactDto> getContact(String personAccountId)throws Exception;

    public List<SurveyAccountDto> getAccount(String businessAccountId)throws Exception;

}
