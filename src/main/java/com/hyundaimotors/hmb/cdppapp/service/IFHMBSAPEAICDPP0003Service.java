package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;

public interface IFHMBSAPEAICDPP0003Service {

    public IFHMBSAPEAICDPP0003Dto insertObject(IFHMBSAPEAICDPP0003Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBSAPEAICDPP0003Dto dto)throws Exception;
}
