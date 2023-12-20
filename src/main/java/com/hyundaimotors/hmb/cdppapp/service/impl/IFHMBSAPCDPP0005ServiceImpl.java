package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0005Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPCDPP0005Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPCDPP0005Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPCDPP0005ServiceImpl implements IFHMBSAPCDPP0005Service{
    
    private final IFHMBSAPCDPP0005Mapper mapper;

    public IFHMBSAPCDPP0005Dto insertObject(IFHMBSAPCDPP0005Dto dto)throws Exception{
        IFHMBSAPCDPP0005Dto resulDto = new IFHMBSAPCDPP0005Dto();

        mapper.insertObject(dto);
        
        /**
         * 20231122
         * 조건 : cnpjNumber 값이 있고 foundAccountIdbyCnpj조회 값이 있으면 update
         *       또는 name,mainPhoneNumber,mainEmailAddress 값이 있고 foundAccountIdbyCnpj조회 값이 있으면 update
         * 나머지 insert
         */
       boolean isValidation = false;
       
       String foundAccountIdbyCnpj = null;
       if(!isNull(dto.getCnpjNumber())) { //update
            isValidation = true;
           foundAccountIdbyCnpj = mapper.foundAccountIdbyCnpj(dto);
       }else {
           if(!isNull(dto.getName()) && !isNull(dto.getMainPhoneNumber()) && !isNull(dto.getMainEmailAddress())) {
               isValidation = true;
               foundAccountIdbyCnpj = mapper.foundAccountIdbyNameAndPhoneAndEmail(dto);
           }
       }
       
       if(isValidation) {
             if(!isNull(foundAccountIdbyCnpj)) {
                 resulDto.setContactId(update(dto,foundAccountIdbyCnpj));
                 resulDto.setCheckUpsert("update");
             }else {
                 resulDto.setContactId(insert(dto));
                 resulDto.setCheckUpsert("insert");
             }
             
             resulDto.setErrorSpcCode("0"); 
             resulDto.setErrorSpcMessage("OK");
       }else {
           String foundAccountId = mapper.foundAccountId(dto);
           if(!isNull(foundAccountId)) {//저장 조건중 row_id를 가져올수 있다면..
                resulDto.setContactId(update(dto,foundAccountId));
                resulDto.setCheckUpsert("update");
           }else {
               resulDto.setContactId(insert(dto));
               resulDto.setCheckUpsert("insert");
           }
           
           resulDto.setErrorSpcCode("0"); 
           resulDto.setErrorSpcMessage("OK");
       }

       return resulDto;
    }
    
    /**
     * 
     * @param dto
     * @return
     * @throws Exception
     */
    private String insert(IFHMBSAPCDPP0005Dto dto) throws Exception {
         HashMap<String, String> map = new HashMap<>();
         map.put("PARAM_ID", String.valueOf(dto.getRowId()));
         map.put("checkcu","insert");
         
         mapper.insertProcessAccount(map);  
         
         String foundAccountId = mapper.foundAccountId(dto);
         
         map.put("PROC_ACC_ID", foundAccountId);
         mapper.insertReplicaAccount(map);
         
         return foundAccountId;
    }
    
    /**
     * 
     * @param dto
     * @param foundAccountIdbyCnpj
     * @return
     * @throws Exception
     */
    private String update(IFHMBSAPCDPP0005Dto dto,String foundAccountIdbyCnpj) throws Exception {
          HashMap<String, String> map = new HashMap<>();
          map.put("PARAM_ID", String.valueOf(dto.getRowId()));
          map.put("PROC_ACC_ID", foundAccountIdbyCnpj);
          map.put("checkcu","update");
          
          mapper.insertProcessAccount(map);
          mapper.insertReplicaAccount(map);
          
          return foundAccountIdbyCnpj;
    }
    
    /**
     * 공백이나 null체크
     * @param value
     * @return
     */
    private boolean isNull(String value) {
        return !(value != null && !"".equals(value.trim())) && true;
    }


    public void insertDPObject(IFHMBSAPCDPP0005Dto dto)throws Exception{

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", dto.getContactId());
        map.put("checkcu", dto.getCheckUpsert());

        mapper.transferDPProcess(map);

    }

}