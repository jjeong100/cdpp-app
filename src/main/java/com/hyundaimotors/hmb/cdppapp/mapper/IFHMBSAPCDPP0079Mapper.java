package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079.IFHMBSAPCDPP0079Dto;

public interface IFHMBSAPCDPP0079Mapper {

    public void insertRepair(IFHMBSAPCDPP0079Dto dto)throws Exception;

    public void insertRepairService(IFHMBSAPCDPP0079Dto dto)throws Exception;

    public void insertRepairPart(IFHMBSAPCDPP0079Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;
}
