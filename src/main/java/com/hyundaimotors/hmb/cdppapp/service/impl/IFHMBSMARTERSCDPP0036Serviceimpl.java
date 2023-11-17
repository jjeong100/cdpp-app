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

        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 1");
        mapper.insertServiceRequestChatInput(dto);
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 2");
        dto.getServiceRequestChatInput().setRowId(dto.getRowId());
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 3");

        if( dto.getServiceRequestChatInput().getChat() != null ){
        	System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 4");
            mapper.insertChat(dto.getServiceRequestChatInput());
            dto.getServiceRequestChatInput().getChat().setRowId(dto.getRowId());
        }

        if( dto.getServiceRequestChatInput().getChat().getListOfMessage() != null){
        	System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 5");
            mapper.insertMessage(dto.getServiceRequestChatInput().getChat());
        }

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 6");
        System.out.println("■ dto.getRowId() : "+dto.getRowId());

        mapper.transferProcess(map);
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 7");
        IFHMBSMARTERSCDPP0036Dto replicaDto = new IFHMBSMARTERSCDPP0036Dto();

        replicaDto = mapper.getPocessData(dto);
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 8");
        HashMap<String, String> replicaMap = new HashMap<>();
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 9");

        replicaMap.put("PARAM_ID", replicaDto.getProcessProtocol());
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 10");
        mapper.transferReplica(replicaMap);
        System.out.println("■ IFHMBSMARTERSCDPP0036Serviceimpl : 11");
        resulDto.setOwnedById(replicaDto.getOwnedById());
        resulDto.setProcessProtocol(replicaDto.getProcessProtocol());
        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");

        return resulDto;
    }
}
