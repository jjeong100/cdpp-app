package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0005Dto;

public interface IFHMBSAPCDPP0005Mapper {

    public String foundAccountIdbyCnpj(IFHMBSAPCDPP0005Dto dto)throws Exception;
    
    public String foundAccountIdbyNameAndPhoneAndEmail(IFHMBSAPCDPP0005Dto dto)throws Exception;
    
    public String foundAccountId(IFHMBSAPCDPP0005Dto dto)throws Exception;

    public int insertObject(IFHMBSAPCDPP0005Dto dto)throws Exception;  

    public void insertProcessAccount(HashMap<String, String> parMap)throws Exception;
    
    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;

    public void insertReplicaAccount(HashMap<String, String> parMap)throws Exception;
}
