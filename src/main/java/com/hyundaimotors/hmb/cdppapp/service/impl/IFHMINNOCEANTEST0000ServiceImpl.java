package com.hyundaimotors.hmb.cdppapp.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hyundaimotors.hmb.cdppapp.dto.IFHMINNOCEANTEST0000.IFHMINNOCEANTEST0000Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMINNOCEANTEST0000Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMINNOCEANTEST0000Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMINNOCEANTEST0000ServiceImpl  implements IFHMINNOCEANTEST0000Service {

    private final IFHMINNOCEANTEST0000Mapper mapper;

    public IFHMINNOCEANTEST0000Dto insertObject(IFHMINNOCEANTEST0000Dto dto) throws Exception {

      System.out.println("■■■■■■■■■■■ Insert !..");
       
      mapper.insertObject(dto.getUserDto());

      IFHMINNOCEANTEST0000Dto resulDto = new IFHMINNOCEANTEST0000Dto(); 

      System.out.println("■■■■■■■■■■■ IFHMINNOCEANTEST0000ServiceImpl");
       
      resulDto.setErrorSpcCode("0");
      resulDto.setErrorSpcMessage("OK");
        // resulDto = dto;

        return resulDto;
    }
    
}
