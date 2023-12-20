package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0038Dto;

public interface IFHMBSAPEAICDPP0038Mapper {
    
    public void insertLead(IFHMBSAPEAICDPP0038Dto dto)throws Exception;

    public void insertTemperature(IFHMBSAPEAICDPP0038Dto dto)throws Exception;

    public void insertInteraction(IFHMBSAPEAICDPP0038Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public List<String> getActionId(IFHMBSAPEAICDPP0038Dto dto)throws Exception;

    public void transferDPProcess(HashMap<String, String[]> parMap)throws Exception;
    
}
