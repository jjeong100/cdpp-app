package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDElTAGLOBALCDPP0093.RentalResultDto;

public interface IFHMBDElTAGLOBALCDPP0093Mapper {
    
    public void insertRental(RentalResultDto dto)throws Exception;

    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public List<String> getProcessRowIds(List<String> paramList)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;
}
