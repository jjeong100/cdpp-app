package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0003Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0003Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0003ServiceImpl implements IFHMBSAPEAICDPP0003Service{
    
    private final IFHMBSAPEAICDPP0003Mapper mapper;

    public IFHMBSAPEAICDPP0003Dto insertObject(IFHMBSAPEAICDPP0003Dto dto)throws Exception{

        IFHMBSAPEAICDPP0003Dto resulDto = new IFHMBSAPEAICDPP0003Dto();

        mapper.insertObject(dto);

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);   
        
        String productRowId = mapper.getProductRowId(dto);

        map.put("PRODUCT_ID", productRowId);


        mapper.transferReplica(map);

        resulDto.setRowId(productRowId);
        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");
       
        return resulDto;
    }

    public void insertDPObject(IFHMBSAPEAICDPP0003Dto dto)throws Exception{
        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", dto.getRowId());
        
        mapper.transferDPProcess(map);
    }
}
