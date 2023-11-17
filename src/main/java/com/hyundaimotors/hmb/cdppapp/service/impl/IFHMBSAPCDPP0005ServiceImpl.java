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
         * 20231110
         * 조건 : cnpjNumber 값이 있고 foundAccountIdbyCnpj조회 값이 있으면 update
         *       또는 name,mainPhoneNumber,mainEmailAddress 값이 있고 foundAccountIdbyCnpj조회 값이 있으면 update
         * 나머지 insert
         */
        String foundAccountIdbyCnpj = null;
        if(!isNull(dto.getCnpjNumber())) { //update
            foundAccountIdbyCnpj = mapper.foundAccountIdbyCnpj(dto);
        }else {
            if(!isNull(dto.getName()) && !isNull(dto.getMainPhoneNumber()) && !isNull(dto.getMainEmailAddress())) {
                foundAccountIdbyCnpj = mapper.foundAccountIdbyNameAndPhoneAndEmail(dto);
            }
        }
        
        if(!isNull(foundAccountIdbyCnpj)) {
              HashMap<String, String> map = new HashMap<>();
              map.put("PARAM_ID", String.valueOf(dto.getRowId()));
              map.put("PROC_ACC_ID", foundAccountIdbyCnpj);
              map.put("checkcu","update");
              
              mapper.insertProcessAccount(map);
              mapper.insertReplicaAccount(map);

              resulDto.setContactId(foundAccountIdbyCnpj);
              resulDto.setErrorSpcCode("0"); 
              resulDto.setErrorSpcMessage("OK");
        }else {
            HashMap<String, String> map = new HashMap<>();
            map.put("PARAM_ID", String.valueOf(dto.getRowId()));
            map.put("checkcu","insert");
            
            mapper.insertProcessAccount(map);  
            
            String foundAccountId = mapper.foundAccountId(dto);
            
            map.put("PROC_ACC_ID", foundAccountId );
            mapper.insertReplicaAccount(map);
            
            resulDto.setContactId(foundAccountId);
            resulDto.setErrorSpcCode("0"); 
            resulDto.setErrorSpcMessage("OK");
        }

        return resulDto;
    }
    
    /**
     * 공백이나 null체크
     * @param value
     * @return
     */
    private boolean isNull(String value) {
        return (value != null && !"".equals(value.trim()))?false:true;
    }

}