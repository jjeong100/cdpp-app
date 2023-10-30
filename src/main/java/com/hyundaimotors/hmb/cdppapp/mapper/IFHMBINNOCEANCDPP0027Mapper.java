package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0027Dto;

public interface IFHMBINNOCEANCDPP0027Mapper {

    public int getParRowCheck(IFHMBINNOCEANCDPP0027Dto dto)throws Exception;

    public int insertObject(IFHMBINNOCEANCDPP0027Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public String getObject(IFHMBINNOCEANCDPP0027Dto dto)throws Exception;
    
}
