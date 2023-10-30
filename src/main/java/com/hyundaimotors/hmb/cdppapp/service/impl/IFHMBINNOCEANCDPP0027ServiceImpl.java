package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0027Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0027Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0027Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0027ServiceImpl implements IFHMBINNOCEANCDPP0027Service{
    
    private final IFHMBINNOCEANCDPP0027Mapper mapper;  

    public IFHMBINNOCEANCDPP0027Dto upsertObject(IFHMBINNOCEANCDPP0027Dto dto)throws Exception{

        IFHMBINNOCEANCDPP0027Dto resultDto = new IFHMBINNOCEANCDPP0027Dto();
        int parRowCheckNum = mapper.getParRowCheck(dto);
        
        mapper.insertObject(dto);
        
        if(parRowCheckNum > 0){
            HashMap<String, String> map = new HashMap<>();

            map.put("PARAM_ID", dto.getRowId());
            map.put("checkcu", "update");  
            map.put("ACCOUNT_ID", dto.getContactId());   
          
            mapper.transferProcess(map);

            mapper.transferReplica(map);
            
            String loyaltyStatus = mapper.getObject(dto);

            resultDto.setContactId(dto.getContactId());
            resultDto.setLoyaltyStatus(loyaltyStatus);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            
        }else{
            HashMap<String, String> map = new HashMap<>();

            
            map.put("PARAM_ID", dto.getRowId());
            map.put("ACCOUNT_ID", dto.getContactId());   
            map.put("checkcu", "insert");  
            mapper.transferProcess(map);
            mapper.transferReplica(map);

            String loyaltyStatus = mapper.getObject(dto);

            resultDto.setContactId(dto.getContactId());
            resultDto.setLoyaltyStatus(loyaltyStatus);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
        }

        return resultDto;
    }
}
