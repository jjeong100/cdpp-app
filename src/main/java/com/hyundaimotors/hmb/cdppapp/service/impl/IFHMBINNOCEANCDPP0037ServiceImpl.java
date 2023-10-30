package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.ListOfAutoVehicleDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0037Mapper;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.AutoVehicle;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ContactData;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ContactSocialMedia;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfAutoVehicle;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfContactSocialMedia;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0037Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0037ServiceImpl implements IFHMBINNOCEANCDPP0037Service{
    
    private final IFHMBINNOCEANCDPP0037Mapper mapper;

    public HashMap<String, Object> updateObject(IFHMBINNOCEANCDPP0037Dto dto)throws Exception{
        
        List<ListOfAutoVehicle> listVehicle = new ArrayList<>();
        List<ListOfContactSocialMedia> listSocialMedia = new ArrayList<>();
        
        ContactData updateContactOutput = new ContactData();  
        AutoVehicle autoVehicle = new AutoVehicle();
        ContactSocialMedia contactSocialMedia = new ContactSocialMedia();

        HashMap<String, String[]> processMap = new HashMap<>();
        HashMap<String, Object> map = new HashMap<>();
        List<ListOfAutoVehicleDto> listOfAutoVehicle = new ArrayList<>();         
        List<String> listVehicleId = new ArrayList<>();
        List<String> listParamId = new ArrayList<>();
        List<String> listAccountId = new ArrayList<>();
        List<String> listAssetId = new ArrayList<>();

        List<AutoVehicle> listOfAutoVehicleOut = new ArrayList<>();
        List<ContactSocialMedia> listOfContactSocialMediaOut = new ArrayList<>();


        int checkContactId = mapper.checkAccountId(dto);

        if ( checkContactId > 0 ){

            mapper.insertObject(dto);
    
            if( dto.getListOfContactSocialMedia() != null ){
                mapper.insertSocialMedia(dto); 
            }
    
            listOfAutoVehicle = dto.getListOfAutoVehicle();
            listParamId.add(String.valueOf(dto.getRowId()));
            listAccountId.add(dto.getContactId());
    
            if( listOfAutoVehicle.size() > 0 ){
                for(int i = 0; i < listOfAutoVehicle.size(); i++){
                    ListOfAutoVehicleDto vehicle = new ListOfAutoVehicleDto();
                    vehicle = listOfAutoVehicle.get(i);
                    vehicle.setParRowId(dto.getRowId());
                    mapper.insertAutoVehicle(vehicle);
                    listVehicleId.add(String.valueOf(vehicle.getRowId()));
                    listAssetId.add(String.valueOf(vehicle.getVehicleId()));
                }
            }
            String[] vehicleId = listVehicleId.toArray(new String[listVehicleId.size()]);
            String[] paramId = listParamId.toArray(new String[listParamId.size()]);
            String[] accountId = listAccountId.toArray(new String[listAccountId.size()]);
            String[] assetId = listAssetId.toArray(new String[listAssetId.size()]);
    
    
            // landing dummy rowId
            processMap.put("PARAM_ID", paramId);
            // landing dummy vehicle rowId list
            processMap.put("VEHICLE_ID", vehicleId);
            // process account rowId       
            processMap.put("PROC_ACCOUNT_ID", accountId);
            // process asset rowId list
            processMap.put("ASSET_ID_LIST", assetId);
    
            mapper.transferProcess(processMap);    
            
            mapper.transferReplica(processMap);
    
    
            map.put("contactId", dto.getContactId());
            map.put("error_spcCode", "0");
            map.put("error_spcMessage", "OK");
    
            updateContactOutput = mapper.getUpdateContactOutput(dto);  
            listVehicle = mapper.getListVehicle(processMap);
            listSocialMedia = mapper.getListSocialMedia(dto);
    
    
            if( listVehicle.size() > 0){
                for( int i = 0; i < listVehicle.size(); i++){
                    autoVehicle.setAutoVehicle(listVehicle.get(i));
                    listOfAutoVehicleOut.add(autoVehicle);
                }
                if(updateContactOutput != null){
                    updateContactOutput.setListOfAutoVehicle(listOfAutoVehicleOut);
                }
            }
    
    
            if( listSocialMedia.size() > 0){
                for( int i = 0; i < listSocialMedia.size(); i++){
                    contactSocialMedia.setContactSocialMedia(listSocialMedia.get(i));
                    listOfContactSocialMediaOut.add(contactSocialMedia);
                }
                if(updateContactOutput != null){
                    updateContactOutput.setListOfContactSocialMedia(listOfContactSocialMediaOut);
                }
            }
    
            map.put("updateContactOutput", updateContactOutput);
        }else {
            map.put("contactId", dto.getContactId());
            map.put("error_spcCode", "1");
            map.put("error_spcMessage", "No Data");
        }


        return map;
    }
    
}
