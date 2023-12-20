package com.hyundaimotors.hmb.cdppapp.service;


import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026.IFHMBSAPEAICDPP0026Dto;

public interface IFHMBSAPEAICDPP0026Service {
    
    public IFHMBSAPEAICDPP0026Dto insertObject(IFHMBSAPEAICDPP0026Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBSAPEAICDPP0026Dto dto)throws Exception;
}
