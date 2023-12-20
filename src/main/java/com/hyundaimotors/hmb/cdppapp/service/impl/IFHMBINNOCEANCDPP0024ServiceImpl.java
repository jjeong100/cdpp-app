package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0024Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0024Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0024Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0024ServiceImpl implements IFHMBINNOCEANCDPP0024Service{
    private final IFHMBINNOCEANCDPP0024Mapper mapper;   

    public IFHMBINNOCEANCDPP0024Dto insertObject(IFHMBINNOCEANCDPP0024Dto dto)throws Exception{
        
        IFHMBINNOCEANCDPP0024Dto resulDto = new IFHMBINNOCEANCDPP0024Dto();
        mapper.insertObject(dto);

        if ("delete".equalsIgnoreCase(dto.getOperation().toLowerCase())) {

            String procRowId = mapper.getProcRowId(dto);
            resulDto.setProcRowId(procRowId);
        }

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);

        resulDto.setRowId(dto.getRowId());
        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");
        return resulDto;
    }


    public void insertDPObject(IFHMBINNOCEANCDPP0024Dto dto)throws Exception{

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));
        map.put("PROC_ID", dto.getProcRowId());

        mapper.transferDPProcess(map);
    }

}
