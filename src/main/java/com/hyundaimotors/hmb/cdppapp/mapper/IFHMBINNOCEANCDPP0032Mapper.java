package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032.IFHMBINNOCEANCDPP0032Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032.SearchContactTDDto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0032.ServiceRequestTD;

public interface IFHMBINNOCEANCDPP0032Mapper {
    
    public List<SearchContactTDDto> getSearchContact(IFHMBINNOCEANCDPP0032Dto dto)throws Exception;

    public List<ServiceRequestTD> getServiceRequest(IFHMBINNOCEANCDPP0032Dto dto)throws Exception;

}
