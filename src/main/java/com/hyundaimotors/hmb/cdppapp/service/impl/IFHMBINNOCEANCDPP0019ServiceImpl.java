package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0019Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0019Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0019Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0019ServiceImpl implements IFHMBINNOCEANCDPP0019Service{
    
    private final IFHMBINNOCEANCDPP0019Mapper mapper;

    public List<IFHMBINNOCEANCDPP0019Dto> getList(IFHMBINNOCEANCDPP0019Dto dto)throws Exception{
          List<IFHMBINNOCEANCDPP0019Dto> resultList = new ArrayList<>();
        
        resultList = mapper.getList(dto);

        return resultList;
    }
}
