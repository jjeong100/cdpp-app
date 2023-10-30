package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0022.IFHMBINNOCEANCDPP0022Dto;

public interface IFHMBINNOCEANCDPP0022Mapper {

    public IFHMBINNOCEANCDPP0022Dto getCheckHoliDay(IFHMBINNOCEANCDPP0022Dto dto)throws Exception;

    public String getRowId(IFHMBINNOCEANCDPP0022Dto dto)throws Exception;

    public int insertObject(IFHMBINNOCEANCDPP0022Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

}
