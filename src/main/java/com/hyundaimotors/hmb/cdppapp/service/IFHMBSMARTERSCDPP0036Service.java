package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036.IFHMBSMARTERSCDPP0036Dto;

public interface IFHMBSMARTERSCDPP0036Service {

    public IFHMBSMARTERSCDPP0036Dto insertObject(IFHMBSMARTERSCDPP0036Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBSMARTERSCDPP0036Dto dto)throws Exception;
}
