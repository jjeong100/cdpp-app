
package com.hyundaimotors.hmb.cdppapp.service.impl;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0002.IFHMBINNOCEANCDPP0002Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0002Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0002Service;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0002ServiceImpl implements IFHMBINNOCEANCDPP0002Service{
    
    private final IFHMBINNOCEANCDPP0002Mapper mapper;
    public IFHMBINNOCEANCDPP0002Dto insertObject(IFHMBINNOCEANCDPP0002Dto dto)throws Exception{
        //To_Do : Return ContactId를 Process Id로 변경, Exception Runtime 으로 변경
    
        IFHMBINNOCEANCDPP0002Dto resultDto = new IFHMBINNOCEANCDPP0002Dto();
        mapper.insertObject(dto);
        if(  dto.getListOfCurrentCars() != null){
            mapper.insertCar(dto);
        }
        if ( dto.getListOfApps() != null){
            mapper.insertApp(dto);
        }
        if(  dto.getListOfSocialMedia() != null){
            mapper.insertSocialmedia(dto);
        }
        if(  dto.getListOfHobby() != null){
            mapper.insertHobby(dto);            
        }
        if(  dto.getListOfSoccerTeam() != null){
            mapper.insertSoccerteam(dto);
        }
        
        // contact 존재 여부 체크
        if( dto.getCpf() != null ){
            String foundContactIdByCpf = mapper.foundContactIdbyCpf(dto);
            if( foundContactIdByCpf != null){
                HashMap<String, String> map = new HashMap<>();
                map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                map.put("CONTACT_ID", foundContactIdByCpf);
                map.put("checkcu", "update");
                
                mapper.transferProcess(map);
                mapper.transferReplica(map);
                resultDto.setContactId(foundContactIdByCpf);
                resultDto.setError_spcCode("0");
                resultDto.setError_spcMessage("OK"); 
                
            }else{
                String foundContactId = mapper.foundContactId(dto);
                
                if(foundContactId != null ){
    
                    HashMap<String, String> map = new HashMap<>();
                    map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                    map.put("CONTACT_ID", foundContactId);
                    map.put("checkcu", "update");
                    
                    mapper.transferProcess(map);
                    mapper.transferReplica(map);
                    resultDto.setContactId(foundContactId);
                    resultDto.setError_spcCode("0");
                    resultDto.setError_spcMessage("OK"); 
                }else{
                    HashMap<String, String> map = new HashMap<>();
                    map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                    map.put("checkcu", "insert");
                    
                    mapper.transferProcess(map);

                    foundContactId = mapper.foundContactId(dto);

                    
                    map.put("CONTACT_ID", foundContactId);
                    mapper.transferReplica(map);
                    
                    resultDto.setContactId(foundContactId);
                    resultDto.setError_spcCode("0");
                    resultDto.setError_spcMessage("OK"); 
                }
            }
        } else {
            String foundContactId = mapper.foundContactId(dto);
            
            if(foundContactId != null ){
                
                HashMap<String, String> map = new HashMap<>();
                map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                map.put("CONTACT_ID", foundContactId);
                map.put("checkcu", "update");
                
                mapper.transferProcess(map);
                mapper.transferReplica(map);
                resultDto.setContactId(foundContactId);
                resultDto.setError_spcCode("0");
                resultDto.setError_spcMessage("OK"); 
            }else{
                HashMap<String, String> map = new HashMap<>();
                map.put("PARAM_ID", String.valueOf(dto.getRowId()));
                map.put("checkcu", "insert");
                
                mapper.transferProcess(map);
                
                foundContactId = mapper.foundContactId(dto);
                
                map.put("CONTACT_ID", foundContactId);
                mapper.transferReplica(map);
                
                resultDto.setContactId(foundContactId);
                resultDto.setError_spcCode("0");
                resultDto.setError_spcMessage("OK"); 
            }
        }
        
        
        return resultDto;
    }
}
