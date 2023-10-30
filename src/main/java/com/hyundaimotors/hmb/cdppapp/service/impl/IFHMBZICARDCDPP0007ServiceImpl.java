package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBZICARDCDPP0007Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBZICARDCDPP0007Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBZICARDCDPP0007Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBZICARDCDPP0007ServiceImpl implements IFHMBZICARDCDPP0007Service{

    private final IFHMBZICARDCDPP0007Mapper mapper;

    public IFHMBZICARDCDPP0007Dto upsertObject(IFHMBZICARDCDPP0007Dto dto)throws Exception{
        
        IFHMBZICARDCDPP0007Dto resultDto = new IFHMBZICARDCDPP0007Dto();

        String procId = mapper.getCustomerVehicleId(dto);

        mapper.insertObject(dto);

        if( procId != null ){

            HashMap<String, String> map = new HashMap<String, String>();
    
            map.put("PARAM_ID", dto.getRowId());    
            map.put("PROC_ID", procId);
            map.put("checkcu",  "update");            
            mapper.transferProcess(map);
            mapper.transferReplica(map);

            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            resultDto.setNumAffRow("1");

        }else {
    
            HashMap<String, String> map = new HashMap<String, String>();
    
            map.put("PARAM_ID", dto.getRowId());    
            map.put("checkcu",  "insert");            
            mapper.transferProcess(map);

            procId = mapper.getCustomerVehicleId(dto);

            map.put("PROC_ID", procId);
            mapper.transferReplica(map);

            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            resultDto.setNumAffRow("1");
        }
          
        return resultDto;
    }
}
