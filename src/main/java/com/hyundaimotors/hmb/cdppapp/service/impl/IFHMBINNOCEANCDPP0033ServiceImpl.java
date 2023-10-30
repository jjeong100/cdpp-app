package com.hyundaimotors.hmb.cdppapp.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.AccountAssetDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.ContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.HMBVehicleDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.IFHMBINNOCEANCDPP0033Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0033Mapper;

import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0033Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0033ServiceImpl implements IFHMBINNOCEANCDPP0033Service{
    private final IFHMBINNOCEANCDPP0033Mapper mapper;

    public IFHMBINNOCEANCDPP0033Dto getObject(IFHMBINNOCEANCDPP0033Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0033Dto resulDto = new IFHMBINNOCEANCDPP0033Dto();
        List<HMBVehicleDto> vehicleList = new ArrayList<>();
        
        vehicleList = mapper.getAsset(dto);

        if(0 < vehicleList.size()) {
            for(int i = 0; i < vehicleList.size(); i++){
                List<AccountAssetDto> accountAssetDto = new ArrayList<>();
                List<ContactDto> contactDto = new ArrayList<>();
                dto.setContactInputId(vehicleList.get(i).getContactSearchId());
                dto.setAccountInputId(vehicleList.get(i).getAccountSearchId());
                dto.setAssetInputId(vehicleList.get(i).getAssetId());
                contactDto = mapper.getContact(dto);
                accountAssetDto = mapper.getAccount(dto);
                if(0 < contactDto.size()){
                    vehicleList.get(i).setListOfContact(contactDto);
                }
                if(0 < accountAssetDto.size()){
                    vehicleList.get(i).setListOfAccount(accountAssetDto);
                }
            }
        }

        resulDto.setListOfHMBVehicle(vehicleList);
        return resulDto;
    }
}
