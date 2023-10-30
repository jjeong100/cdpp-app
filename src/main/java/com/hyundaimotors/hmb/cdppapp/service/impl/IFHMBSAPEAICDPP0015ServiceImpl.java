package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0015Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0015Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0015ServiceImpl implements IFHMBSAPEAICDPP0015Service{
    private final IFHMBSAPEAICDPP0015Mapper mapper;

    public IFHMBSAPEAICDPP0015Dto insertObject(IFHMBSAPEAICDPP0015Dto dto)throws Exception{
         mapper.insertObject(dto);

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);
        
        mapper.transferReplica(map);

        IFHMBSAPEAICDPP0015Dto resultDto = new IFHMBSAPEAICDPP0015Dto();
        
        resultDto.setErrorSpcCode("0");
        resultDto.setErrorSpcMessage("OK");

        return resultDto;
    }
}
