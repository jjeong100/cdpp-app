package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBDMSCDPP0004Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDMSCDPP0004Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBDMSCDPP0004ServiceImpl implements IFHMBDMSCDPP0004Service{
    
    private final IFHMBDMSCDPP0004Mapper mapper;

    public IFHMBDMSCDPP0004Dto insertObject(IFHMBDMSCDPP0004Dto dto)throws Exception{
        IFHMBDMSCDPP0004Dto resultDto = new IFHMBDMSCDPP0004Dto();
        
        List<GetLeadDto> listOfLead = new ArrayList<>();

        List<IFHMBDMSCDPP0004Dto> getContactId = new ArrayList<>();

        getContactId = mapper.getContact(dto);
        
        GetLeadContactDto contato = new GetLeadContactDto();

        contato = mapper.GetContato(dto);

        return resultDto;
    }
}
