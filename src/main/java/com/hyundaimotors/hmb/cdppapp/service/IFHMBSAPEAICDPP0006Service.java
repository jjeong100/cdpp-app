package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0006Dto;

public interface IFHMBSAPEAICDPP0006Service {
    public IFHMBSAPEAICDPP0006Dto insertObject(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBSAPEAICDPP0006Dto dto)throws Exception;
}
