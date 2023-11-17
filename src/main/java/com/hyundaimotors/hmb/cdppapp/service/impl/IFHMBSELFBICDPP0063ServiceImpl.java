package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.AccountGetVinDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.ContactGetVinDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.IFHMBSELFBICDPP0063Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.VehicleDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSELFBICDPP0063Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSELFBICDPP0063Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSELFBICDPP0063ServiceImpl implements IFHMBSELFBICDPP0063Service{
    private final IFHMBSELFBICDPP0063Mapper mapper;

    public IFHMBSELFBICDPP0063Dto getObject(IFHMBSELFBICDPP0063Dto dto)throws Exception{
        IFHMBSELFBICDPP0063Dto resulDto = new IFHMBSELFBICDPP0063Dto();
        List<VehicleDto> vehicleList = new ArrayList<>();

        vehicleList = mapper.getAsset(dto);
        if(vehicleList.size() > 0){
            for(int i = 0; i < vehicleList.size(); i++){
                List<AccountGetVinDto> accountDto = new ArrayList<>();
                List<ContactGetVinDto> contactDto = new ArrayList<>();
//                if(vehicleList.get(i).getAssetId() != null || vehicleList.get(i).getAssetId() != ""){
                if(vehicleList.get(i).getAssetId() != null || !"".equals(vehicleList.get(i).getAssetId())){
                    String assetGetRowId = vehicleList.get(i).getAssetId();

                    contactDto = mapper.getContact(assetGetRowId);
                    accountDto = mapper.getAccount(assetGetRowId);
                    if(0 < contactDto.size()){
                        vehicleList.get(i).setListOfContact(contactDto);
                    }
                    if(0 < accountDto.size()){
                        vehicleList.get(i).setListOfAccount(accountDto);
                    }
                }
                
            }

            resulDto.setListOfVehicle(vehicleList);
        }
        
        return resulDto;
    }
}
