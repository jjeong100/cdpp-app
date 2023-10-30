package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.IFHMBINNOCEANCDPP0089Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.SatisfactionSurveyDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.SurveyAccountDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.SurveyContactDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0089Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0089Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0089ServiceImpl implements IFHMBINNOCEANCDPP0089Service{
    
    private final IFHMBINNOCEANCDPP0089Mapper mapper;

    public IFHMBINNOCEANCDPP0089Dto getObject(IFHMBINNOCEANCDPP0089Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0089Dto resulDto = new IFHMBINNOCEANCDPP0089Dto();

        List<SatisfactionSurveyDto> satisfactionSurveyList = new ArrayList<>();

        satisfactionSurveyList = mapper.getSatisfactionSurveyList(dto);

        if(0 < satisfactionSurveyList.size()){
            
            for(int i=0; i < satisfactionSurveyList.size(); i++){
                if(satisfactionSurveyList.get(i).getPersonAccountId() != null){
                    String personAccountId = satisfactionSurveyList.get(i).getPersonAccountId();
                    List<SurveyContactDto> listOfContact = new ArrayList<>();
                    listOfContact = mapper.getContact(personAccountId);
                    satisfactionSurveyList.get(i).setListOfContact(listOfContact);
                }
                if(satisfactionSurveyList.get(i).getBusinessAccountId() != null){
                    List<SurveyAccountDto> listOfAccount = new ArrayList<>();
                    String businessAccountId = satisfactionSurveyList.get(i).getBusinessAccountId();
                    listOfAccount = mapper.getAccount(businessAccountId);
                    satisfactionSurveyList.get(i).setListOfAccount(listOfAccount);
                }
            }
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
            resulDto.setListOfSatisfactionSurvey(satisfactionSurveyList);  
        }else{
            resulDto.setErrorSpcCode("1");
            resulDto.setErrorSpcMessage("No Data");
        }
        

        return resulDto;
    }
}
