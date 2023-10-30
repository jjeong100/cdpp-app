package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091.GetBluelinkDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091.IFHMBBLUELINKCDPP0091Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBBLUELINKCDPP0091Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBBLUELINKCDPP0091Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBBLUELINKCDPP0091ServiceImpl implements IFHMBBLUELINKCDPP0091Service{
    private final IFHMBBLUELINKCDPP0091Mapper mapper;

    public IFHMBBLUELINKCDPP0091Dto insertObject(IFHMBBLUELINKCDPP0091Dto dto)throws Exception{
        IFHMBBLUELINKCDPP0091Dto resulDto = new IFHMBBLUELINKCDPP0091Dto();

        List<GetBluelinkDto> bluelinkList = new ArrayList<>();

        bluelinkList = mapper.getBluelinkList(dto);

        if( bluelinkList != null ){
            resulDto.setListOfBluelink(bluelinkList); 
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
        }else{
            resulDto.setErrorSpcCode("1");
            resulDto.setErrorSpcMessage("No data");
        }

        return resulDto;
    }
}
