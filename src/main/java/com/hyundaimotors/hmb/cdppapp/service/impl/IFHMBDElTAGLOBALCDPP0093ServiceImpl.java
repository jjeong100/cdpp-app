package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDElTAGLOBALCDPP0093.IFHMBDElTAGLOBALCDPP0093Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBDElTAGLOBALCDPP0093Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDElTAGLOBALCDPP0093Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBDElTAGLOBALCDPP0093ServiceImpl implements IFHMBDElTAGLOBALCDPP0093Service{
    private final IFHMBDElTAGLOBALCDPP0093Mapper mapper;

    public IFHMBDElTAGLOBALCDPP0093Dto insertObject(IFHMBDElTAGLOBALCDPP0093Dto dto)throws Exception{
        IFHMBDElTAGLOBALCDPP0093Dto resuDto = new IFHMBDElTAGLOBALCDPP0093Dto();
        List<String> paramList = new ArrayList<>();
        List<String> replicaParamList = new ArrayList<>();
        
        for(int i=0;i < dto.getListOfRentalResult().size(); i++){
            if(!"Confirmed".equals(dto.getListOfRentalResult().get(i).getRentalStatus())){
                resuDto.setErrorSpcCode("1");
                resuDto.setErrorSpcMessage("Not Confirmed Rental Status value");

                return resuDto; 
            }else{
                mapper.insertRental(dto.getListOfRentalResult().get(i));
                paramList.add(i, String.valueOf(dto.getListOfRentalResult().get(i).getRowId()));
                
            }
        }

        String[] param = paramList.toArray(new String[paramList.size()]);

        HashMap<String, String[]> map = new HashMap<>();
        map.put("param_id", param);

        mapper.transferProcess(map);

        replicaParamList = mapper.getProcessRowIds(paramList);

        String[] replicaParam = replicaParamList.toArray(new String[replicaParamList.size()]);

        HashMap<String, String[]> replicaMap = new HashMap<>();
        
        replicaMap.put("param_id", replicaParam);

        mapper.transferReplica(replicaMap);

        resuDto.setErrorSpcCode("0");
        resuDto.setErrorSpcMessage("OK");

        return resuDto;
    }
}
