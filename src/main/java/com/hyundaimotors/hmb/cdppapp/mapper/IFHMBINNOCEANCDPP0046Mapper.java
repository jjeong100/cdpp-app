package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0046.IFHMBINNOCEANCDPP0046Dto;

public interface IFHMBINNOCEANCDPP0046Mapper {

    public String getAccRowIdByDealercode(IFHMBINNOCEANCDPP0046Dto dto)throws Exception;
    
    public void deleteList(IFHMBINNOCEANCDPP0046Dto dto)throws Exception;
    
    public void insertObject(IFHMBINNOCEANCDPP0046Dto dto)throws Exception;
    
    public void insertList(IFHMBINNOCEANCDPP0046Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;
                
    public void transferReplica(HashMap<String, String> replicaMap)throws Exception;
}
