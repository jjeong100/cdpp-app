package com.hyundaimotors.hmb.cdppapp.service;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0018Dto;

public interface IFHMBINNOCEANCDPP0018Service {
    
    public List<IFHMBINNOCEANCDPP0018Dto> getList(IFHMBINNOCEANCDPP0018Dto dto)throws Exception;
}
