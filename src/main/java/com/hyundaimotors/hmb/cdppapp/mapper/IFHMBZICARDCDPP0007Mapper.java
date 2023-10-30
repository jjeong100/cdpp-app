package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBZICARDCDPP0007Dto;

public interface IFHMBZICARDCDPP0007Mapper {
    
    public String getCustomerVehicleId(IFHMBZICARDCDPP0007Dto dto)throws Exception;

    public void insertObject(IFHMBZICARDCDPP0007Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;
    
}
