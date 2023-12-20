package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Dto;

public interface IFHMBMAPFRECDPP0009Service {
    
    public IFHMBMAPFRECDPP0009Dto upsertObject(IFHMBMAPFRECDPP0009Dto dto)throws Exception;

    @Async
    public void insertDPObject(IFHMBMAPFRECDPP0009Dto dto)throws Exception;
}
