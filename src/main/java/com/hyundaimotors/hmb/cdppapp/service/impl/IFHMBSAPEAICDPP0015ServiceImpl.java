package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015.IFHMBSAPEAICDPP0015Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0015Mapper;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015.Color;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0015Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0015ServiceImpl implements IFHMBSAPEAICDPP0015Service{
    private final IFHMBSAPEAICDPP0015Mapper mapper;

    public IFHMBSAPEAICDPP0015Dto insertObject(IFHMBSAPEAICDPP0015Dto dto)throws Exception{
        IFHMBSAPEAICDPP0015Dto resultDto = new IFHMBSAPEAICDPP0015Dto();
        

        if(0 < dto.getListOfColor().size()){
            List<String> paramList = new ArrayList<>();
            
            for(int i=0; i < dto.getListOfColor().size(); i++){
                mapper.insertObject(dto.getListOfColor().get(i));

                paramList.add(String.valueOf(String.valueOf(dto.getListOfColor().get(i).getRowId())));
            }

            String[] param = paramList.toArray(new String[paramList.size()]);

            HashMap<String, String[]> map = new HashMap<>();

            map.put("param_id", param);

            mapper.transferProcess(map);
            
            List<String> replicaParamList = new ArrayList<>();       

            replicaParamList = mapper.getProcessRowIds(paramList);

            String[] replicaParam = replicaParamList.toArray(new String[replicaParamList.size()]);

            HashMap<String, String[]> replicaMap = new HashMap<>();

            replicaMap.put("param_id", replicaParam);
            
            mapper.transferReplica(replicaMap);
            
        
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
        }else{
        
            resultDto.setErrorSpcCode("1");
            resultDto.setErrorSpcMessage("Fail");
        }
        

        return resultDto;
    }
}
