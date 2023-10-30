package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031.IFHMBSAPCDPP0031Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031.SearchServiceRequestDto;

public interface IFHMBSAPCDPP0031Mapper {
    
    public List<SearchServiceRequestDto> getServiceRequestTD(IFHMBSAPCDPP0031Dto dto)throws Exception;
}
