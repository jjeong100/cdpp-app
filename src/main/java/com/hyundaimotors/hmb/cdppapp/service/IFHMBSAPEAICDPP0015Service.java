package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015.IFHMBSAPEAICDPP0015Dto;

public interface IFHMBSAPEAICDPP0015Service {
    
    public IFHMBSAPEAICDPP0015Dto insertObject(IFHMBSAPEAICDPP0015Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBSAPEAICDPP0015Dto dto)throws Exception;
}
