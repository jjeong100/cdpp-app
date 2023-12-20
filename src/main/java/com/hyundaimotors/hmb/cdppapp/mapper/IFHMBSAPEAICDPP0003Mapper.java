package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;

public interface IFHMBSAPEAICDPP0003Mapper {
    
    public int insertObject(IFHMBSAPEAICDPP0003Dto dto)throws Exception;

    public String getProductRowId(IFHMBSAPEAICDPP0003Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;

}
