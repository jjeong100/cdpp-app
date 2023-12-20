package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0006Dto;

public interface IFHMBSAPEAICDPP0006Mapper {
    
    public void insertAction(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    public void insertActionNote(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    public void insertActionProducts(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    public void insertSynergyActionAudit(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public String getTaskRowId(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    public String getActionRowId(IFHMBSAPEAICDPP0006Dto dto)throws Exception;

    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;
}
