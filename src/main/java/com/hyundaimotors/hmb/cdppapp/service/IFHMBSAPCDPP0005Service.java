package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0005Dto;

public interface IFHMBSAPCDPP0005Service {
    
    public IFHMBSAPCDPP0005Dto insertObject(IFHMBSAPCDPP0005Dto dto)throws Exception;
    
    @Async
    public void insertDPObject(IFHMBSAPCDPP0005Dto dto)throws Exception;
}
