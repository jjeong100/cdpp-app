package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0034Dto;

public interface IFHMBINNOCEANCDPP0034Mapper {
    
    public void insertServiceRequest(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public void insertAccessory(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public void insertPart(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> replicaMap)throws Exception;

    public String getProtocalTestDrive(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public String getProtocalQuotation(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public String getProtocalCase(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public String getprotocolID(IFHMBINNOCEANCDPP0034Dto dto)throws Exception;

    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;
    
}
