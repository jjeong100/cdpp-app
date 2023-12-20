package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.IFHMBSELFBICDPP0062Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalActionDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalLeadDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalTemperatureDto;

public interface IFHMBSELFBICDPP0062Mapper {
    
    public List<TotalLeadDto> getLead(IFHMBSELFBICDPP0062Dto dto)throws Exception;
    // public List<TotalContactDto> getContact(String contactRowId)throws Exception;
     public TotalContactDto getContact(String contactRowId)throws Exception;

    public TotalActionDto getAction(String strId)throws Exception;

    public List<TotalTemperatureDto> getTemperature(String protocol)throws Exception;
    
}
