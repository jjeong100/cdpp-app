package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0021Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0021Mapper;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0021.ListOfDealers;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0021Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0021ServiceImpl implements IFHMBINNOCEANCDPP0021Service{
    
    private final IFHMBINNOCEANCDPP0021Mapper mapper;   

    public IFHMBINNOCEANCDPP0021Dto getObject(IFHMBINNOCEANCDPP0021Dto dto)throws Exception{
        List<ListOfDealers> list = mapper.getObject(dto);
        dto.setListOfDealers(list);

        return dto;
    }
}
