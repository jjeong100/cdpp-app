package com.hyundaimotors.hmb.cdppapp.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0001Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0001Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0001Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0001ServiceImpl implements IFHMBINNOCEANCDPP0001Service {

    private final IFHMBINNOCEANCDPP0001Mapper mapper;

    public IFHMBINNOCEANCDPP0001Dto getObject(IFHMBINNOCEANCDPP0001Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0001Dto resulDto = new IFHMBINNOCEANCDPP0001Dto();
        resulDto = mapper.getObject(dto);
        
        if(resulDto != null){
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
            
            return resulDto;
        }else{
            IFHMBINNOCEANCDPP0001Dto failResultDto = new IFHMBINNOCEANCDPP0001Dto();
            failResultDto.setErrorSpcCode("1");
            failResultDto.setErrorSpcMessage("no data");
            
            return failResultDto;
        }
    }
    
}
