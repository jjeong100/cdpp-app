package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Dto;

public interface IFHMBMAPFRECDPP0009Mapper {
    
    public String getRSAId(IFHMBMAPFRECDPP0009Dto dto)throws Exception;

    public void deleteList(IFHMBMAPFRECDPP0009Dto dto)throws Exception;

    public void insertObject(IFHMBMAPFRECDPP0009Dto dto)throws Exception;

    public void insertResSetvice(IFHMBMAPFRECDPP0009Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public String resGetProtocolId(String procId)throws Exception;

    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;
}
