package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015.ColorDto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015.Color;

public interface IFHMBSAPEAICDPP0015Mapper {
    public void insertObject(ColorDto dto)throws Exception;

    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public List<String> getProcessRowIds(List<String> paramList)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;

    public void transferDPProcess(HashMap<String, String[]> parMap)throws Exception;
}
