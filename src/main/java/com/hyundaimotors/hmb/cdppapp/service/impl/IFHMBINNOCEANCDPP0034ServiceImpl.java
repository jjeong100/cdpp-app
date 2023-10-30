package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0034Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0034Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0034Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0034ServiceImpl implements IFHMBINNOCEANCDPP0034Service{
    private final IFHMBINNOCEANCDPP0034Mapper mapper;
    
    public IFHMBINNOCEANCDPP0034Dto insertObject(IFHMBINNOCEANCDPP0034Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0034Dto resulDto = new IFHMBINNOCEANCDPP0034Dto();

        mapper.insertServiceRequest(dto);

        if( dto.getListOfAccessories() != null){
            mapper.insertAccessory(dto);
        }

        if( dto.getListOfParts() != null ){
            mapper.insertPart(dto);
        }

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);

        String protocolID = mapper.getprotocolID(dto);
        
        HashMap<String, String> replicaMap = new HashMap<>();

        replicaMap.put("PARAM_ID", protocolID);

        mapper.transferReplica(replicaMap);

        String protocalResult = "";
        if("Information".equals(dto.getReason()) && "Sales".equals(dto.getLevel1()) && "Test drive".equals(dto.getLevel2())){
            protocalResult = mapper.getProtocalTestDrive(dto);
        }else if("Sales opportunity".equals(dto.getReason()) && "Sales".equals(dto.getLevel1()) && "Request a quote".equals(dto.getLevel2())){
            protocalResult = mapper.getProtocalQuotation(dto);
        }else{
            protocalResult = mapper.getProtocalCase(dto);
        }
        
        resulDto.setProtocalResult(protocolID);
        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");

        return resulDto;
    }
}
