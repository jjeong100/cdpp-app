package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026.ListOfProductDto;

public interface IFHMBSAPEAICDPP0026Mapper {
    
    public void insertProductList(ListOfProductDto dto)throws Exception;
    
    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public List<String> getProcIdList(HashMap<String, String[]> parMap)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;

}
