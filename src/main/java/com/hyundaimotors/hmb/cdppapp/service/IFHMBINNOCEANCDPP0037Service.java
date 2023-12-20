package com.hyundaimotors.hmb.cdppapp.service;

import java.util.HashMap;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Dto;

public interface IFHMBINNOCEANCDPP0037Service {
    
    public HashMap<String, Object> updateObject(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    @Async
    public void insertDPObject(HashMap<String, Object> parMap)throws Exception;
}
