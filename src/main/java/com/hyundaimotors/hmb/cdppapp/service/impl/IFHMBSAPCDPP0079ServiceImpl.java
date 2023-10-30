package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079.IFHMBSAPCDPP0079Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079.InboundRepairDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPCDPP0079Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPCDPP0079Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPCDPP0079ServiceImpl implements IFHMBSAPCDPP0079Service{
    private final IFHMBSAPCDPP0079Mapper mapper;

    public IFHMBSAPCDPP0079Dto insertObject(IFHMBSAPCDPP0079Dto dto)throws Exception{
        IFHMBSAPCDPP0079Dto resultDto = new IFHMBSAPCDPP0079Dto();
        
        mapper.insertRepair(dto);
        mapper.insertRepairService(dto);
        mapper.insertRepairPart(dto);

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);

        resultDto.setErrorSpcCode("0");
        resultDto.setErrorSpcMessage("OK");


        return resultDto;
    }
}
