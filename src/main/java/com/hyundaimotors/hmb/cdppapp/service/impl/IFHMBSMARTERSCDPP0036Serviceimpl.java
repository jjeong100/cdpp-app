package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036.IFHMBSMARTERSCDPP0036Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSMARTERSCDPP0036Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSMARTERSCDPP0036Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSMARTERSCDPP0036Serviceimpl implements IFHMBSMARTERSCDPP0036Service{
    
    private final IFHMBSMARTERSCDPP0036Mapper mapper;

    public IFHMBSMARTERSCDPP0036Dto insertObject(IFHMBSMARTERSCDPP0036Dto dto)throws Exception{
        IFHMBSMARTERSCDPP0036Dto resulDto = new IFHMBSMARTERSCDPP0036Dto();

        mapper.insertServiceRequestChatInput(dto);
        dto.getServiceRequestChatInput().setRowId(dto.getRowId());

        if( dto.getServiceRequestChatInput().getChat() != null ){
            mapper.insertChat(dto.getServiceRequestChatInput());
            dto.getServiceRequestChatInput().getChat().setRowId(dto.getRowId());
        }

        if( dto.getServiceRequestChatInput().getChat().getListOfMessage() != null){
            mapper.insertMessage(dto.getServiceRequestChatInput().getChat());
        }

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);

        IFHMBSMARTERSCDPP0036Dto replicaDto = new IFHMBSMARTERSCDPP0036Dto();

        replicaDto = mapper.getPocessData(dto);

        HashMap<String, String> replicaMap = new HashMap<>();

        replicaMap.put("PARAM_ID", replicaDto.getProcessProtocol());

        mapper.transferReplica(replicaMap);

        resulDto.setOwnedById(replicaDto.getOwnedById());
        resulDto.setProcessProtocol(replicaDto.getProcessProtocol());
        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");

        return resulDto;
    }
}
