package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091.GetBluelinkDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091.IFHMBBLUELINKCDPP0091Dto;

public interface IFHMBBLUELINKCDPP0091Mapper {
    
    public List<GetBluelinkDto> getBluelinkList(IFHMBBLUELINKCDPP0091Dto dto)throws Exception;
}
