package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0012.ChannelPartnerDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0012.IFHMBINNOCEANCDPP0012Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0012Mapper;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012.ChannelPartnerContact;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0012Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0012ServiceImpl implements IFHMBINNOCEANCDPP0012Service{
    
    private final IFHMBINNOCEANCDPP0012Mapper mapper;   

    public IFHMBINNOCEANCDPP0012Dto getObject(IFHMBINNOCEANCDPP0012Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0012Dto resultDto = new IFHMBINNOCEANCDPP0012Dto();
        List<ChannelPartnerDto> channelPartner = new ArrayList<>();
        channelPartner = mapper.getChannelPartner(dto);  
        resultDto.setChannelPartner(channelPartner);

        if( 0 < channelPartner.size()){
            for(int i = 0; i < channelPartner.size(); i++){
                List<ChannelPartnerContact> channelPartnerContact = new ArrayList<>();
                dto.setAccountRowId(channelPartner.get(i).getId());
                channelPartnerContact = mapper.getChannelPartnerContactList(dto);
                resultDto.getChannelPartner().get(i).setChannelPartnerContact(channelPartnerContact);
            }
        }              

        resultDto.setErrorSpcCode("0");
        resultDto.setErrorSpcMessage("OK");


        return resultDto;
    }
}
