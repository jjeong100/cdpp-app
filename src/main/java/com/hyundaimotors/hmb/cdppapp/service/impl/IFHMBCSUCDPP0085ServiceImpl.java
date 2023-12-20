package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
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
    
    public IFHMBCSUCDPP0085Dto getObject(IFHMBCSUCDPP0085Dto dto)throws Exception{
       IFHMBCSUCDPP0085Dto resultDto = new IFHMBCSUCDPP0085Dto();

       List<ChannelPartnerCSUDto> channelPartnerDto = new ArrayList<ChannelPartnerCSUDto>();

       channelPartnerDto = mapper.getChannelPartnerCtiIoList(dto);
       resultDto.setChannelPartner(channelPartnerDto);

       if(channelPartnerDto != null){
           resultDto.setChannelPartner(channelPartnerDto);
   
           resultDto.setObjectSpcId(dto.getObjectSpcId());
           resultDto.setProcessSpcInstanceSpcId(dto.getVcep());
           resultDto.setErrorSpcCode("0");
           resultDto.setErrorSpcMessage("OK");
       }else{
           resultDto.setErrorSpcCode("1");
           resultDto.setErrorSpcMessage("Fail");
       }
       
       return resultDto;
    }
}
