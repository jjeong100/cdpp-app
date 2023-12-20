package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013.IFHMBINNOCEANCDPP0013Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013.ListOfContactsDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0013Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0013Service;

import io.swagger.v3.core.util.Json;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0013ServiceImpl implements IFHMBINNOCEANCDPP0013Service{
    
    private final IFHMBINNOCEANCDPP0013Mapper mapper;   

    public IFHMBINNOCEANCDPP0013Dto upsertObject(IFHMBINNOCEANCDPP0013Dto dto)throws Exception{
        List<ListOfContactsDto> listOfcontacts = new ArrayList<>();        
        IFHMBINNOCEANCDPP0013Dto resultDto = new IFHMBINNOCEANCDPP0013Dto();
        List<String> listParamId = new ArrayList<>();
        List<String> listProcAccntId = new ArrayList<>();
        List<String> listConRowId = new ArrayList<>();
        List<String> listProcConId = new ArrayList<>();
        
        String getProcAccntRowId = mapper.getRowId(dto);

        mapper.insertBusinessAccount(dto);

        listParamId.add(String.valueOf(dto.getRowId()));
        if(getProcAccntRowId != null){
            listProcAccntId.add(getProcAccntRowId);
        }
        listOfcontacts = dto.getContactList();              
    
        
        
        if( getProcAccntRowId != null ){ // 딜러 어카운트 존재할 때

            String[] conRowId = null;
            if( listOfcontacts != null ){
                for(int i = 0; i < listOfcontacts.size(); i++){
                    ListOfContactsDto contact = new ListOfContactsDto();
                    contact = listOfcontacts.get(i);
                    contact.setParRowId(String.valueOf(dto.getRowId()));
                    contact.setAccntRowId(getProcAccntRowId);
    
                    mapper.insertPersonAccount(contact);
    
                    listConRowId.add(contact.getRowId());
                }
                conRowId = listConRowId.toArray(new String[listConRowId.size()]);
            }
            String[] paramId = listParamId.toArray(new String[listParamId.size()]);
            String[] procAccntId = listProcAccntId.toArray(new String[listProcAccntId.size()]);

            HashMap<String, String[]> map = new HashMap<>();

            map.put("PARAM_ID", paramId);
            map.put("PROC_ACC_ID", procAccntId);
            map.put("CON_ROWID", conRowId);

            List<String> listCheckcu = new ArrayList<>();
            listCheckcu.add("update");
            String[] checkcu = listCheckcu.toArray(new String[listCheckcu.size()]);
            map.put("checkcu", checkcu); //update

            mapper.transferProcess(map);

            // process.contact row_id 리스트
            String[] procConId = null;
            if( listOfcontacts != null ){
                for(int i = 0; i < listOfcontacts.size(); i++){
                    ListOfContactsDto contact = new ListOfContactsDto();
                    contact = listOfcontacts.get(i);
                    
                    String getContactId = mapper.getContactId(contact);                        
                    listProcConId.add(getContactId);                      
                    
                }
                procConId = listProcConId.toArray(new String[listProcConId.size()]);
            }


            map.put("PROC_CON_ID",procConId);

            mapper.transferReplica(map);

            resultDto.setProcRowId(getProcAccntRowId);
            resultDto.setListOfProcContactRowId(listProcConId);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");

        }else{
        
            HashMap<String, String[]> map = new HashMap<>();
            String[] paramId = listParamId.toArray(new String[listParamId.size()]);
            map.put("PARAM_ID", paramId);

            List<String> listCheckcu = new ArrayList<>();
            listCheckcu.add("insert");
            String[] checkcu = listCheckcu.toArray(new String[listCheckcu.size()]);
            map.put("checkcu", checkcu); //insert

            String[] conRowId = null;
            if( listOfcontacts != null ){
                for(int i = 0; i < listOfcontacts.size(); i++){
                    ListOfContactsDto contact = new ListOfContactsDto();
                    contact = listOfcontacts.get(i);
                    contact.setParRowId(String.valueOf(dto.getRowId()));
                    
                    mapper.insertPersonAccount(contact);

                    listConRowId.add(contact.getRowId());
                }
                conRowId = listConRowId.toArray(new String[listConRowId.size()]);
            }   

            map.put("CON_ROWID", conRowId);

            mapper.transferProcess(map);

            getProcAccntRowId = mapper.getRowId(dto);
            String[] procAccntId = null;
            if( getProcAccntRowId != null){
                listProcAccntId.add(getProcAccntRowId);
                procAccntId = listProcAccntId.toArray(new String[listProcAccntId.size()]);
            }
            map.put("PROC_ACC_ID", procAccntId);

            String[] procConId = null;
            // process.contact row_id 리스트
            if( listOfcontacts != null ){
                for(int i = 0; i < listOfcontacts.size(); i++){
                    ListOfContactsDto contact = new ListOfContactsDto();
                    contact = listOfcontacts.get(i);
                    contact.setAccntRowId(getProcAccntRowId);
                    
                    String getContactId = mapper.getContactId(contact);
                    
                    listProcConId.add(getContactId);                      
                    
                }
                procConId = listProcConId.toArray(new String[listProcConId.size()]);
            }
     
            map.put("PROC_CON_ID",procConId);

            mapper.transferReplica(map);

            resultDto.setProcRowId(getProcAccntRowId);
            resultDto.setListOfProcContactRowId(listProcConId);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
        }        
        
        return resultDto;
    }

    public void insertDPObject(IFHMBINNOCEANCDPP0013Dto dto)throws Exception{

        HashMap<String, String[]> map = new HashMap<>();
        List<String> listProcAccntId = new ArrayList<>();
        List<String> listProcConId = new ArrayList<>();

        listProcAccntId.add(dto.getProcRowId());
        listProcConId = dto.getListOfProcContactRowId();

        String[] procAccntId = listProcAccntId.toArray(new String[listProcAccntId.size()]);
        String[] procContId = listProcConId.toArray(new String[listProcConId.size()]);

        map.put("PROC_ACC_ID", procAccntId);
        map.put("PROC_CON_ID_LIST", procContId);

        mapper.transferDPProcess(map);

    }
}
