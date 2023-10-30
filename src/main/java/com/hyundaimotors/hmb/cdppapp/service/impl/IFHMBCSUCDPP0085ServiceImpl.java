package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085.ChannelPartnerCSUDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085.IFHMBCSUCDPP0085Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBCSUCDPP0085Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0085Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBCSUCDPP0085ServiceImpl implements IFHMBCSUCDPP0085Service{

    private final IFHMBCSUCDPP0085Mapper mapper;
    
    public IFHMBCSUCDPP0085Dto insertObject(IFHMBCSUCDPP0085Dto dto)throws Exception{

        IFHMBCSUCDPP0085Dto resulDto = new IFHMBCSUCDPP0085Dto();

        HashMap<String, String> map = new HashMap<>();
        map.put("param_id", String.valueOf(dto.getVcep()));
        if("Y".equalsIgnoreCase(dto.getVService())){
            map.put("saleorservice", "service");
        }else{
            map.put("saleorservice", "sales");
        }
        

        String dealerId = mapper.getDealerId(map);

        dto.setObjectSpcId(dealerId);

        ChannelPartnerCSUDto channelPartnerDto = new ChannelPartnerCSUDto();

        channelPartnerDto = mapper.getChannelObject(dto);

        if(channelPartnerDto != null){
            resulDto.setChannelPartner(channelPartnerDto);

            resulDto.setObjectSpcId(dto.getObjectSpcId());
            resulDto.setProcessSpcInstanceSpcId(dto.getVcep());
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
        }else{
            resulDto.setErrorSpcCode("1");
            resulDto.setErrorSpcMessage("Fail");
        }
        
        return resulDto;
    }
}
