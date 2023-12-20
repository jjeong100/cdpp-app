package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBRECLAMEAQUICDPP0096.RetrieveTicketIdDto;

public interface IFHMBRECLAMEAQUICDPP0096Mapper {
    
    public void insertAllTicketList(RetrieveTicketIdDto dto)throws Exception;

    public void transferProcessAccount(HashMap<String, String[]> parMap)throws Exception;

    public List<String> getProcessAccountRowIds(List<String> paramList)throws Exception;

    public void transferReplicaAccount(HashMap<String, String[]> parMap)throws Exception;

    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public List<String> getProcessRowIds(List<String> paramList)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;
}
