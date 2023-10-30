package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0024Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0024Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0024Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0024ServiceImpl implements IFHMBINNOCEANCDPP0024Service{
    private final IFHMBINNOCEANCDPP0024Mapper mapper;   

    public IFHMBINNOCEANCDPP0024Dto insertObject(IFHMBINNOCEANCDPP0024Dto dto)throws Exception{
        
        mapper.insertObject(dto);

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);

        IFHMBINNOCEANCDPP0024Dto resulDto = new IFHMBINNOCEANCDPP0024Dto();
        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");
        return resulDto;
    }

}
