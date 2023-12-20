package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.IFHMBCSUCDPP0087Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchAutoVehicleDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchCSISurveyDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchCampaignDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchContactOutputDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.SearchServiceRequestContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031.SearchServiceRequestDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBCSUCDPP0087Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0087Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBCSUCDPP0087ServiceImpl implements IFHMBCSUCDPP0087Service{
    private final IFHMBCSUCDPP0087Mapper mapper;

    public IFHMBCSUCDPP0087Dto insertObject(IFHMBCSUCDPP0087Dto dto)throws Exception{
        IFHMBCSUCDPP0087Dto resultDto = new IFHMBCSUCDPP0087Dto();

        List<SearchContactOutputDto> listOfContactOutput = new ArrayList<>();
        
        listOfContactOutput = mapper.getContactList(dto);

        if(0 < listOfContactOutput.size()){
            for(int i = 0; i < listOfContactOutput.size();i++){
                List<SearchAutoVehicleDto> listOfAutoVehicle = new ArrayList<>();
                listOfAutoVehicle = mapper.getVehicleList(dto);
                
                if(0 < listOfAutoVehicle.size()){
                    listOfContactOutput.get(i).setAutoVehicle(listOfAutoVehicle);
                }

                List<SearchCampaignDto> listOfCampaign = new ArrayList<>();
                listOfCampaign = mapper.getCampaignList(dto);

                if(0 < listOfCampaign.size()){
                    listOfContactOutput.get(i).setCampaign(listOfCampaign);
                }

                List<SearchCSISurveyDto> listOfCSISurvey = new ArrayList<>();
                listOfCSISurvey = mapper.getCSISurveyList(dto);

                if(0 < listOfCSISurvey.size()){
                    listOfContactOutput.get(i).setCsiSurvey(listOfCSISurvey);
                }

                List<SearchServiceRequestContactDto> listOfSearchServiceRequest = new ArrayList<>();
                listOfSearchServiceRequest = mapper.getServiceRequestList(dto);
                if(0 < listOfSearchServiceRequest.size()){
                    listOfContactOutput.get(i).setServiceRequest(listOfSearchServiceRequest);
                }
            }

            resultDto.setListOfContactOutput(listOfContactOutput);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
        }else{
            resultDto.setErrorSpcCode("1");
            resultDto.setErrorSpcMessage("No data");
        }
        

        return resultDto;
    }
}
