package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013.IFHMBINNOCEANCDPP0013Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013.ListOfContactsDto;

public interface IFHMBINNOCEANCDPP0013Mapper {
    
    public String getRowId(IFHMBINNOCEANCDPP0013Dto dto)throws Exception;

    public String getContactIdByCpf(ListOfContactsDto dto)throws Exception;

    public String getContactId(ListOfContactsDto dto)throws Exception;

    public void insertBusinessAccount(IFHMBINNOCEANCDPP0013Dto dto)throws Exception;

    public void insertPersonAccount(ListOfContactsDto dto)throws Exception;

    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;

    public void transferProcessContact(HashMap<String, String> parMap)throws Exception;
}
