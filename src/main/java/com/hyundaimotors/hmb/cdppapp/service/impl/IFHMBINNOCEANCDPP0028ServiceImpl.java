package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0028Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0028Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0028Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0028ServiceImpl implements IFHMBINNOCEANCDPP0028Service{
    
    private final IFHMBINNOCEANCDPP0028Mapper mapper;  

    public IFHMBINNOCEANCDPP0028Dto upsertObject(IFHMBINNOCEANCDPP0028Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0028Dto resulDto = new IFHMBINNOCEANCDPP0028Dto();

        String getProcRowId = mapper.getProcRowId(dto);

        System.out.println("PROC_ID ======= > " + getProcRowId);

        mapper.insertObject(dto);

        if(getProcRowId != null){

            HashMap<String, String> map = new HashMap<>();
            
            map.put("PARAM_ID", dto.getRowId());
            map.put("PROC_ID", getProcRowId);
            map.put("checkcu", "update");
            
            mapper.transferProcess(map);
            mapper.transferReplica(map);

            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
                        
        }else{   
            
            HashMap<String, String> map= new HashMap<>();

            map.put("PARAM_ID", dto.getRowId());
            map.put("checkcu", "insert");
            
            mapper.transferProcess(map);
            
            getProcRowId = mapper.getProcRowId(dto);
            map.put("PROC_ID", getProcRowId);
            mapper.transferReplica(map);
            
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
            
            
        }
        

        return resulDto;
    }
}
