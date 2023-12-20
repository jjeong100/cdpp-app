package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0023.EmpAvailabInDto;

public interface IFHMBINNOCEANCDPP0023Mapper {
    
    public void insertObject(EmpAvailabInDto empAvailabIn)throws Exception;

    public void insertDay(EmpAvailabInDto empAvailabIn)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;
    
    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;
}
