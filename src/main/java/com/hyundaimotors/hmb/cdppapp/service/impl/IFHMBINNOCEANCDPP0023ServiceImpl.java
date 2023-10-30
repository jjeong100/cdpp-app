package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0023.IFHMBINNOCEANCDPP0023Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0023Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0023Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0023ServiceImpl implements IFHMBINNOCEANCDPP0023Service{
    
    private final IFHMBINNOCEANCDPP0023Mapper mapper;   

    public IFHMBINNOCEANCDPP0023Dto insertObject(IFHMBINNOCEANCDPP0023Dto dto)throws Exception{
        
        mapper.insertObject(dto.getEmpAvailabIn());

        dto.setDayRowId(dto.getEmpAvailabIn().getRowId());

        mapper.insertDay(dto.getEmpAvailabIn());

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getDayRowId()));

        mapper.transferProcess(map);

        IFHMBINNOCEANCDPP0023Dto resulDto = new IFHMBINNOCEANCDPP0023Dto();

        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");

        return resulDto;
    }
}
