package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0021Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0021.ListOfDealers;

public interface IFHMBINNOCEANCDPP0021Mapper {
    
    public List<ListOfDealers> getObject(IFHMBINNOCEANCDPP0021Dto dto)throws Exception;
}
