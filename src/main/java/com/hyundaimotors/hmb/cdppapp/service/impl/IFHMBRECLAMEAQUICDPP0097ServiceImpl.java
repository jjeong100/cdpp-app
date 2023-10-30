package com.hyundaimotors.hmb.cdppapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBRECLAMEAQUICDPP0097Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBRECLAMEAQUICDPP0097Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBRECLAMEAQUICDPP0097Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBRECLAMEAQUICDPP0097ServiceImpl implements IFHMBRECLAMEAQUICDPP0097Service{
    
    private final IFHMBRECLAMEAQUICDPP0097Mapper mapper;

    public void insertAttachmentLink(IFHMBRECLAMEAQUICDPP0097Dto dto)throws Exception{
        mapper.insertAttachmentLink(dto);
    }
}
