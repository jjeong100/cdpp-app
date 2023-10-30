package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0024Dto;

public interface IFHMBINNOCEANCDPP0024Mapper {
    
    public void insertObject(IFHMBINNOCEANCDPP0024Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;
}
