package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBRECLAMEAQUICDPP0096.IFHMBRECLAMEAQUICDPP0096Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBRECLAMEAQUICDPP0096.RetrieveTicketIdDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBRECLAMEAQUICDPP0096Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBRECLAMEAQUICDPP0096Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBRECLAMEAQUICDPP0096ServiceImpl implements IFHMBRECLAMEAQUICDPP0096Service{
    
    private final IFHMBRECLAMEAQUICDPP0096Mapper mapper;

    public void insertAllTicketList(IFHMBRECLAMEAQUICDPP0096Dto dto)throws Exception{

        List<String> paramList = new ArrayList<>();
        List<String> replicaAccountList = new ArrayList<>();
        List<String> replicaParamList = new ArrayList<>();

        List<RetrieveTicketIdDto> data = new ArrayList<>();
        
        if(0 < dto.getData().size()){
            for(int i=0; i < dto.getData().size(); i++){
                mapper.insertAllTicketList(dto.getData().get(i));
                paramList.add(String.valueOf(dto.getData().get(i).getRowId()));
            }
        }

        String[] param = paramList.toArray(new String[paramList.size()]);

        HashMap<String, String[]> map = new HashMap<>();
        map.put("param_id", param);

        //Account Upsert 
        mapper.transferProcessAccount(map);

        replicaAccountList = mapper.getProcessAccountRowIds(paramList);

        String[] replicaAccountParam = replicaAccountList.toArray(new String[replicaAccountList.size()]);

        HashMap<String, String[]> replicAccountaMap = new HashMap<>();

        replicAccountaMap.put("param_id", replicaAccountParam);

        mapper.transferReplicaAccount(replicAccountaMap);


        //Case Upsert
        mapper.transferProcess(map);

        replicaParamList = mapper.getProcessRowIds(paramList);

        String[] replicaParam = replicaParamList.toArray(new String[replicaParamList.size()]);

        HashMap<String, String[]> replicaMap = new HashMap<>();
        
        replicaMap.put("param_id", replicaParam);

        mapper.transferReplica(replicaMap);

    }
}
