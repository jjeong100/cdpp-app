package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031.HMBSearchServiceRequestTDWebserviceOutputDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031.IFHMBSAPCDPP0031Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0031.SearchServiceRequestDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPCDPP0031Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPCDPP0031Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPCDPP0031ServiceImpl implements IFHMBSAPCDPP0031Service{
    
    private final IFHMBSAPCDPP0031Mapper mapper;

    public IFHMBSAPCDPP0031Dto getObject(IFHMBSAPCDPP0031Dto dto)throws Exception{
        IFHMBSAPCDPP0031Dto resuDto = new IFHMBSAPCDPP0031Dto();
        
        HMBSearchServiceRequestTDWebserviceOutputDto hmbSearchServiceRequestTDWebserviceOutput = new HMBSearchServiceRequestTDWebserviceOutputDto();
        List<SearchServiceRequestDto> listServiceRequest = new ArrayList<>();

        listServiceRequest = mapper.getServiceRequestTD(dto);

        if(0 < listServiceRequest.size()){

            hmbSearchServiceRequestTDWebserviceOutput.setListOfHmbSearchServiceRequest(listServiceRequest);
            hmbSearchServiceRequestTDWebserviceOutput.setErrorSpcCode(("0"));
            hmbSearchServiceRequestTDWebserviceOutput.setErrorSpcMessage(("OK"));  
            resuDto.setHmbSearchServiceRequestTDWebserviceOutput(hmbSearchServiceRequestTDWebserviceOutput);  

        }else{
            
            hmbSearchServiceRequestTDWebserviceOutput.setErrorSpcCode(("1"));
            hmbSearchServiceRequestTDWebserviceOutput.setErrorSpcMessage(("FAIL"));  
            resuDto.setHmbSearchServiceRequestTDWebserviceOutput(hmbSearchServiceRequestTDWebserviceOutput);    
            
        }
              

        
        return resuDto;
    }
}
