package com.hyundaimotors.hmb.cdppapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBMAPFRECDPP0009Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBMAPFRECDPP0009Service;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBMAPFRECDPP0009ServiceImpl implements IFHMBMAPFRECDPP0009Service{
    
    private final IFHMBMAPFRECDPP0009Mapper mapper;

    public IFHMBMAPFRECDPP0009Dto upsertObject(IFHMBMAPFRECDPP0009Dto dto)throws Exception{
        IFHMBMAPFRECDPP0009Dto resultDto = new IFHMBMAPFRECDPP0009Dto();
        String procId = mapper.getRSAId(dto);        

        mapper.insertObject(dto);
        mapper.deleteList(dto);
        mapper.insertResSetvice(dto);

        if( procId != null ){            

            HashMap<String, String> map = new HashMap<>();
    
            map.put("PARAM_ID", dto.getRowId());
            map.put("PROC_ID", procId);
            map.put("checkcu", "update");
    
            mapper.transferProcess(map);
            mapper.transferReplica(map);
            
            String protocol = mapper.resGetProtocolId(procId);
            resultDto.setProtocol(protocol);
            resultDto.setRowId(procId);
            resultDto.setCheckCu("update");
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            
        }else{
            
            HashMap<String, String> map = new HashMap<>();            
            
            map.put("PARAM_ID", dto.getRowId());
            map.put("checkcu", "insert");
            
            mapper.transferProcess(map);
            
            procId = mapper.getRSAId(dto);
            
            map.put("PROC_ID", procId);
            mapper.transferReplica(map);

            String protocol = mapper.resGetProtocolId(procId);
            resultDto.setRowId(procId);
            resultDto.setProtocol(protocol);
            resultDto.setCheckCu("insert");
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");

        }           
        
        return resultDto;
    }

    public void insertDPObject(IFHMBMAPFRECDPP0009Dto dto)throws Exception{
        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", dto.getRowId());
        map.put("checkcu", dto.getCheckCu());
        
        mapper.transferDPProcess(map);
    }
}
