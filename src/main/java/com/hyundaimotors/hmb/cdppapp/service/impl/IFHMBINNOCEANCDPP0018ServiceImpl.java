package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0018Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0018Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0018Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0018ServiceImpl implements IFHMBINNOCEANCDPP0018Service{

    private final IFHMBINNOCEANCDPP0018Mapper mapper;   

    public List<IFHMBINNOCEANCDPP0018Dto> getList(IFHMBINNOCEANCDPP0018Dto dto)throws Exception{
        List<IFHMBINNOCEANCDPP0018Dto> resultList = new ArrayList<>();
        
        resultList = mapper.getList(dto);

        return resultList;
    }
    
}
