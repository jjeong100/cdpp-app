package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.IFHMBSELFBICDPP0062Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalActionDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalLeadDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.TotalTemperatureDto;
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

        // TotalLeadDto lead = new TotalLeadDto();
        List<TotalLeadDto> lead = new ArrayList<TotalLeadDto>();

        lead = mapper.getLead(dto);

        if(lead != null){
            for(int index=0;index < lead.size();index++ ) {
                TotalLeadDto leadDto = lead.get(index);

            // List<TotalContactDto> contactList = new ArrayList<>();
                TotalContactDto contactList = new TotalContactDto();
                TotalActionDto action = new TotalActionDto();
                
                // String contactRowId = lead.getContactRowId();
                String contactRowId = leadDto.getContactRowId();

                contactList = mapper.getContact(contactRowId);

                // if(0 < contactList.size()){
                // lead.setContact(contactList);
                // }
                lead.get(index).setContact(contactList);
                
                // String protocol = lead.getProtocol();
                // action = mapper.getAction(protocol);
                // if(action!= null){
                //     lead.setAction(action);
                // }
                // resulDto.setTotallead(lead);

                String protocol = leadDto.getProtocol();

                String strId = leadDto.getStrId();

                action = mapper.getAction(strId);
                if(action!= null){
                    lead.get(index).setAction(action);

                    List<TotalTemperatureDto> temperature = new ArrayList<>();
                    temperature = mapper.getTemperature(protocol);
                    lead.get(index).getAction().setTemperature(temperature);
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
