package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0024Dto;

public interface IFHMBINNOCEANCDPP0024Service {
    
    public IFHMBINNOCEANCDPP0024Dto insertObject(IFHMBINNOCEANCDPP0024Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBINNOCEANCDPP0024Dto dto)throws Exception;
}
