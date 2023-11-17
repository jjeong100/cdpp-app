package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0053.BluelinkDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0053.IFHMBBLUELINKCDPP0053Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBBLUELINKCDPP0053Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBBLUELINKCDPP0053Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBBLUELINKCDPP0053ServiceImpl implements IFHMBBLUELINKCDPP0053Service{
    
    private final IFHMBBLUELINKCDPP0053Mapper mapper;

    public IFHMBBLUELINKCDPP0053Dto insertList(IFHMBBLUELINKCDPP0053Dto dto)throws Exception{
        
                

        List<String> paramList = new ArrayList<>();
        List<String> replicaParamList = new ArrayList<>();       
        
        List<BluelinkDto> bluelinkList = new ArrayList<>();        

        bluelinkList = dto.getListOfBluelink();

        if ( bluelinkList != null ){

            for(int j=0; j< bluelinkList.size(); j++){
                BluelinkDto bluelinkDto = new BluelinkDto();
                bluelinkDto = bluelinkList.get(j);
                bluelinkDto.setSetChassi(dto.getChassi());
                // bluelinkDto.setSetLatestMileage(vehicleList.get(i).getLatestMileage());
                // type에 따른 결과 값 저장
                if("GPI-H".equals(bluelinkDto.getType())){
                    bluelinkDto.setType("ENROLLMENT (VIA TMU)");
                    bluelinkDto.setFirstActivation("Y");
                }else if("GPI-D".equals(bluelinkDto.getType())){
                    bluelinkDto.setType("ENROLLMENT (VIA APP)");
                    bluelinkDto.setFirstActivation("Y");
                }else if("GPI-M".equals(bluelinkDto.getType())){
                    bluelinkDto.setType("DEACTIVATION (VIA APP)");
                    bluelinkDto.setFirstActivation("N");
                }else if("GPI-Q".equals(bluelinkDto.getType())){
                    bluelinkDto.setType("DEACTIVATION (VIA TMU)");
                    bluelinkDto.setFirstActivation("N");
                }else{
    
                }
                mapper.inserBluelink(bluelinkDto);
                paramList.add(String.valueOf(bluelinkDto.getRowId()));
            }
        }
        
        
        String[] param = paramList.toArray(new String[paramList.size()]);
        
        HashMap<String, String[]> map = new HashMap<>();
        map.put("param_id", param);

        mapper.transferProcess(map);
        
        replicaParamList = mapper.getProcessRowIds(paramList);

        String[] replicaParam = replicaParamList.toArray(new String[replicaParamList.size()]);

        HashMap<String, String[]> replicaMap = new HashMap<>();
        
        replicaMap.put("param_id", replicaParam);

        mapper.transferReplica(replicaMap);

        IFHMBBLUELINKCDPP0053Dto resultDto = new IFHMBBLUELINKCDPP0053Dto();
        //resultDto.set(dto.getRowId());
        resultDto.setErrorSpcCode("0");
        resultDto.setErrorSpcMessage("OK");

        return resultDto;
    }
}
