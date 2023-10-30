package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0010.AutoVehicleWebserviceWFAccountDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0010.AutoVehicleWebserviceWFContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0010.IFHMBSAPEAICDPP0010Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0010Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0010Service;

import io.swagger.v3.core.util.Json;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0010ServiceImpl implements IFHMBSAPEAICDPP0010Service {

    private final IFHMBSAPEAICDPP0010Mapper mapper;
    
    public HashMap<String, Object> UpsertAutoVehicle(IFHMBSAPEAICDPP0010Dto dto)throws Exception{

        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, String[]> processMap = new HashMap<>();

        List<AutoVehicleWebserviceWFContactDto> listOfContact = new ArrayList<>();
        List<AutoVehicleWebserviceWFAccountDto> listOfAccount = new ArrayList<>();
        List<String> listParamId = new ArrayList<>();
        List<String> listProcAssetId = new ArrayList<>();
        List<String> listProcInvoiceId = new ArrayList<>();
        List<String> listContactId = new ArrayList<>();
        List<String> listAccontId = new ArrayList<>();
        List<String> listProcCustVehicleId = new ArrayList<>();
        
        String getAssetId = mapper.getProcAssetId(dto);
        String getProcInvoiceId = mapper.getProcInvoiceId(dto);

        mapper.insertAutoVehicle(dto);        

        listParamId.add(dto.getRowId());
        if(dto.getContact() != null){
            listOfContact = dto.getContact();
        }
        if(dto.getAccount() != null ){
            listOfAccount = dto.getAccount();
        }
        String[] contactId = null;
        if( listOfContact != null ){
            for(int i = 0; i < listOfContact.size(); i++){
                AutoVehicleWebserviceWFContactDto con = new AutoVehicleWebserviceWFContactDto();
                con = listOfContact.get(i);
                con.setSerialNumber(dto.getSerialNumber());
                con.setParRowId(dto.getRowId());
                dto.setContactId(con.getConnexContactId());
                mapper.insertContactList(con);
                listContactId.add(String.valueOf(con.getConRowId()));
            }
            contactId = listContactId.toArray(new String[listContactId.size()]);
        }
        
        String[] accountId = null;
        if( listOfAccount != null ){
            for(int i = 0; i < listOfAccount.size(); i++){
                AutoVehicleWebserviceWFAccountDto accnt = new AutoVehicleWebserviceWFAccountDto();
                accnt = listOfAccount.get(i);
                accnt.setSerialNumber(dto.getSerialNumber());
                accnt.setParRowId(dto.getRowId());
                mapper.insertAccountList(accnt);
                listAccontId.add(String.valueOf(accnt.getAccntRowId()));
            }
            accountId = listAccontId.toArray(new String[listAccontId.size()]);
        }     
        
        if(getAssetId != null)
            listProcAssetId.add(getAssetId);
        if(getProcInvoiceId != null)
            listProcInvoiceId.add(getProcInvoiceId);
        
        String[] paramId = listParamId.toArray(new String[listParamId.size()]);  
        String[] procAssetId = listProcAssetId.toArray(new String[listProcAssetId.size()]);
        String[] procInvoiceId = listProcInvoiceId.toArray(new String[listProcInvoiceId.size()]);


        
        processMap.put("PARAM_ID", paramId);
        processMap.put("PROC_ASSET_ID", procAssetId);
        processMap.put("PROC_INVOICE_ID", procInvoiceId);
        processMap.put("account_rowid", accountId);
        processMap.put("contact_rowid", contactId); 

        System.out.println("procAssetId : " + Json.pretty(procAssetId));
        System.out.println("procInvoiceId : " + Json.pretty(procInvoiceId));
     
        if ( getAssetId != null && getProcInvoiceId != null){


            mapper.transferProcess(processMap);
            String[] procCustVehicleId = null;
            if( dto.getAccount() != null){
                listProcCustVehicleId = mapper.getProcCustVehicleId(dto);
                procCustVehicleId = listProcCustVehicleId.toArray(new String[listProcCustVehicleId.size()]);
            }
            processMap.put("PROC_CUSTVEHICLE_ID", procCustVehicleId);
            mapper.transferReplica(processMap);

            map.put("errorSpcCode", "0");
            map.put("errorSpcMessage", "OK"); 

        }else if(getProcInvoiceId != null && getAssetId == null ) {

            mapper.transferProcess(processMap);

            
            getAssetId = mapper.getProcAssetId(dto);
            listProcAssetId.add(getAssetId);
            String[] procCustVehicleId = null;
            if( dto.getAccount() != null){
                listProcCustVehicleId = mapper.getProcCustVehicleId(dto);
                procCustVehicleId = listProcCustVehicleId.toArray(new String[listProcCustVehicleId.size()]);
            }
            processMap.put("PROC_ASSET_ID", procAssetId);
            processMap.put("PROC_CUSTVEHICLE_ID", procCustVehicleId);

            mapper.transferReplica(processMap);

            map.put("errorSpcCode", "0");
            map.put("errorSpcMessage", "OK"); 

        }else if(getAssetId != null && getProcInvoiceId == null){


            mapper.transferProcess(processMap);

            
            getProcInvoiceId = mapper.getProcInvoiceId(dto);
            listProcInvoiceId.add(getProcInvoiceId);
            procInvoiceId = listProcInvoiceId.toArray(new String[listProcInvoiceId.size()]);
            String[] procCustVehicleId = null;
            if( dto.getAccount() != null){
                listProcCustVehicleId = mapper.getProcCustVehicleId(dto);
                procCustVehicleId = listProcCustVehicleId.toArray(new String[listProcCustVehicleId.size()]);
            }
            processMap.put("PROC_INVOICE_ID", procInvoiceId);
            processMap.put("PROC_CUSTVEHICLE_ID", procCustVehicleId);

            mapper.transferReplica(processMap);

            map.put("errorSpcCode", "0");
            map.put("errorSpcMessage", "OK");      
            
        } else {

            mapper.transferProcess(processMap);

            
            getProcInvoiceId = mapper.getProcInvoiceId(dto);
            getAssetId = mapper.getProcAssetId(dto);
            listProcInvoiceId.add(getProcInvoiceId);
            listProcAssetId.add(getAssetId);
            procInvoiceId = listProcInvoiceId.toArray(new String[listProcInvoiceId.size()]);
            procAssetId = listProcAssetId.toArray(new String[listProcAssetId.size()]);
           String[] procCustVehicleId = null;
            if( dto.getAccount() != null){
                listProcCustVehicleId = mapper.getProcCustVehicleId(dto);
                procCustVehicleId = listProcCustVehicleId.toArray(new String[listProcCustVehicleId.size()]);
            }
            processMap.put("PROC_INVOICE_ID", procInvoiceId);
            processMap.put("PROC_ASSET_ID", procAssetId);
            processMap.put("PROC_CUSTVEHICLE_ID", procCustVehicleId);

            mapper.transferReplica(processMap);

            map.put("errorSpcCode", "0");
            map.put("errorSpcMessage", "OK");      

        }
        

        return map;
    } 
}



