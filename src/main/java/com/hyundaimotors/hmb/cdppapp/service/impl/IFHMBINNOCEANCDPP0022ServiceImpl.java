package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0022.IFHMBINNOCEANCDPP0022Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0022Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0022Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0022ServiceImpl implements IFHMBINNOCEANCDPP0022Service{
    
    private final IFHMBINNOCEANCDPP0022Mapper mapper;   

    public IFHMBINNOCEANCDPP0022Dto insertObject(IFHMBINNOCEANCDPP0022Dto dto)throws Exception{

        IFHMBINNOCEANCDPP0022Dto resultDto = new IFHMBINNOCEANCDPP0022Dto();
        
        mapper.insertObject(dto);

        IFHMBINNOCEANCDPP0022Dto rowId = mapper.getCheckHoliDay(dto);
        
        if( rowId != null ){
            dto.setAccntRowId(rowId.getAccntRowId());
            dto.setHolyRowId(rowId.getHolyRowId());
        }
        
        
        if("upsert".equalsIgnoreCase(dto.getOperation())){

            
            if(rowId != null) { // 딜러코드, 해당 날짜 존재할 때           

                HashMap<String, String> map = new HashMap<>();
                map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                map.put("PROC_ID", dto.getHolyRowId());
                map.put("checkcu", "update");
                
                mapper.transferProcess(map);
                mapper.transferReplica(map);                

                
                resultDto.setErrorSpcCode("0");    
                resultDto.setErrorSpcMessage("OK");                
                
            }else{ // 해당날짜 holiday가 없을때                   
                
                HashMap<String, String> map = new HashMap<>();
                map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                map.put("checkcu", "insert");
                
                mapper.transferProcess(map);
                
                rowId = mapper.getCheckHoliDay(dto);
                
                map.put("PROC_ID", rowId.getHolyRowId());


                mapper.transferReplica(map);

            
                resultDto.setErrorSpcCode("0");    
                resultDto.setErrorSpcMessage("OK");     
                
            }            

        }else if("delete".equalsIgnoreCase(dto.getOperation())){

            if(rowId != null) {    
                
                HashMap<String, String> map = new HashMap<>();
                map.put("PROC_ID", rowId.getHolyRowId());
                map.put("checkcu", "delete");

                mapper.transferProcess(map);
                mapper.transferReplica(map);
                
                mapper.insertObject(dto);
            
                resultDto.setErrorSpcCode("0");    
                resultDto.setErrorSpcMessage("OK");     
            }else {
                resultDto.setErrorSpcCode("1");    
                resultDto.setErrorSpcMessage("FAIL"); 
            }
        }else {
            
            resultDto.setErrorSpcCode("1");    
            resultDto.setErrorSpcMessage("FAIL"); 
              
        }

        

        return resultDto;       
    }
}
