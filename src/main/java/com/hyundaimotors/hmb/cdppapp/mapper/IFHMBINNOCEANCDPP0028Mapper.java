package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0028Dto;

public interface IFHMBINNOCEANCDPP0028Mapper {
    
    public String getProcRowId(IFHMBINNOCEANCDPP0028Dto dto)throws Exception;

    public void insertObject(IFHMBINNOCEANCDPP0028Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;
}
