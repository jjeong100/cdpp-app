package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025.IFHMBINNOCEANCDPP0025Dto;

public interface IFHMBINNOCEANCDPP0025Service {

    public IFHMBINNOCEANCDPP0025Dto upsertObject(IFHMBINNOCEANCDPP0025Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBINNOCEANCDPP0025Dto dto)throws Exception;
    
    
}
