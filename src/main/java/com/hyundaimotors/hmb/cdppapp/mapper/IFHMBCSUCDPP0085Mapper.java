package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085.ChannelPartnerCSUDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085.IFHMBCSUCDPP0085Dto;

public interface IFHMBCSUCDPP0085Mapper {
    
    public ChannelPartnerCSUDto getChannelObject(IFHMBCSUCDPP0085Dto dto)throws Exception;

    public String getDealerId(HashMap<String, String> parMap)throws Exception;
}
