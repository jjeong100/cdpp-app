package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0034Dto;

public interface IFHMBINNOCEANCDPP0034Service {
    public IFHMBINNOCEANCDPP0034Dto insertObject(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;
}
