package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.IFHMBCSUCDPP0087Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchAutoVehicleDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchCSISurveyDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchCampaignDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchContactOutputDto;

public interface IFHMBCSUCDPP0087Mapper {
    
    public List<SearchContactOutputDto> getContactList(IFHMBCSUCDPP0087Dto dto)throws Exception;

    public List<SearchAutoVehicleDto> getVehicleList(IFHMBCSUCDPP0087Dto dto)throws Exception;

    public List<SearchCampaignDto> getCampaignList(IFHMBCSUCDPP0087Dto dto)throws Exception;

    public List<SearchCSISurveyDto> getCSISurveyList(IFHMBCSUCDPP0087Dto dto)throws Exception;
}
