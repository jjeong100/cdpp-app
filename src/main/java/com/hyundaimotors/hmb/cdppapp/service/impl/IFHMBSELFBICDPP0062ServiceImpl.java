package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.IFHMBSELFBICDPP0062Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalActionDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalLeadDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSELFBICDPP0062Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSELFBICDPP0062Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSELFBICDPP0062ServiceImpl implements IFHMBSELFBICDPP0062Service{
    private final IFHMBSELFBICDPP0062Mapper mapper;

    public IFHMBSELFBICDPP0062Dto getObject(IFHMBSELFBICDPP0062Dto dto)throws Exception{
        IFHMBSELFBICDPP0062Dto resulDto = new IFHMBSELFBICDPP0062Dto();

        List<TotalLeadDto> lead = new ArrayList<TotalLeadDto>();

        lead = mapper.getLead(dto);

        if(lead != null){
            List<TotalContactDto> contactList = new ArrayList<>();
            TotalActionDto action = new TotalActionDto();
            
             for(int index=0;index < lead.size();index++ ) {
            String contactRowId = lead.get(index).getContactRowId();
            contactList = mapper.getContact(contactRowId);

            if(0 < contactList.size()){
               
                lead.get(index).setContact(contactList);
            }
            
        //    for(int index=0;index < lead.size();index++ ) {
String protocol = lead.get(index).getProtocol();
            action = mapper.getAction(protocol);
            if(action!= null){
                lead.get(index).setAction(action);
            }
           }
          

             resulDto.setTotallead(lead);

            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
            
        }else{
            resulDto.setErrorSpcCode("1");
            resulDto.setErrorSpcMessage("No Data");
        }
        
        return resulDto;
    }
}
