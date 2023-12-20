package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.FileInfoDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0035Dto;

public interface IFHMBSAPEAICDPP0035Mapper {

    public void insertObject(IFHMBSAPEAICDPP0035Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    //public void transferReplica(HashMap<String, String> parMap)throws Exception;
    
    public void transferFile(HashMap<String, Object> parMap)throws Exception;
    public FileInfoDto selectFileDownload(IFHMBSAPEAICDPP0035Dto dto)throws Exception;
    
}
