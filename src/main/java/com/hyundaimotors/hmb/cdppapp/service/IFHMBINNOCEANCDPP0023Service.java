package com.hyundaimotors.hmb.cdppapp.service;

import org.springframework.scheduling.annotation.Async;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0023.IFHMBINNOCEANCDPP0023Dto;

public interface IFHMBINNOCEANCDPP0023Service {
    
   public IFHMBINNOCEANCDPP0023Dto insertObject(IFHMBINNOCEANCDPP0023Dto dto)throws Exception;

   @Async
   public void insertDPObject(IFHMBINNOCEANCDPP0023Dto dto)throws Exception;
}
