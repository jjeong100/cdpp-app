package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0088.IFHMBINNOCEANCDPP0088Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0088Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0088Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0088ServiceImpl implements IFHMBINNOCEANCDPP0088Service{
    private final IFHMBINNOCEANCDPP0088Mapper mapper;

    public IFHMBINNOCEANCDPP0088Dto insertObject(IFHMBINNOCEANCDPP0088Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0088Dto resulDto = new IFHMBINNOCEANCDPP0088Dto();
        
        mapper.insertAmaroCSISurvey(dto);
        mapper.insertAmaroCSISurveyAnswer(dto);
        String getProcId = mapper.getProcId(dto);
        
        if( getProcId != null){

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("param_id", String.valueOf(dto.getRowId()));
            map.put("checkcu", "update");

            mapper.transferProcess(map);
            
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");

        }else{
            
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("param_id", String.valueOf(dto.getRowId()));
            map.put("checkcu", "insert");
            
            mapper.transferProcess(map);
                
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
        }

        return resulDto;
    }
}
