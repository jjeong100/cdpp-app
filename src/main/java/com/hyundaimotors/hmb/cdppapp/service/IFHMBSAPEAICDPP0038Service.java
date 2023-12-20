package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0038Dto;

public interface IFHMBSAPEAICDPP0038Service {
    
    public IFHMBSAPEAICDPP0038Dto insertObject(IFHMBSAPEAICDPP0038Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBSAPEAICDPP0038Dto dto)throws Exception;

}
