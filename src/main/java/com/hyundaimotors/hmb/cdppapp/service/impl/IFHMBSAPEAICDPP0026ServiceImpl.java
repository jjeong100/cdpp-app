package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026.IFHMBSAPEAICDPP0026Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026.ListOfProductDto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0026Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0026Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0026ServiceImpl implements IFHMBSAPEAICDPP0026Service{
    
    private final IFHMBSAPEAICDPP0026Mapper mapper;

    public IFHMBSAPEAICDPP0026Dto insertObject(IFHMBSAPEAICDPP0026Dto dto)throws Exception{

        IFHMBSAPEAICDPP0026Dto resultDto = new IFHMBSAPEAICDPP0026Dto();

        List<ListOfProductDto> listOfProduct = new ArrayList<>();
        List<String> listParamId = new ArrayList<>();
        List<String> listProductName = new ArrayList<>();
        HashMap<String, String[]> map = new HashMap<>();

        listOfProduct = dto.getListOfProduct();
        
        if( listOfProduct.size() > 0 ){
            for(int i = 0; i < listOfProduct.size(); i++){
                ListOfProductDto product = new ListOfProductDto();
                product = listOfProduct.get(i);
                mapper.insertProductList(product);
                listParamId.add(String.valueOf(product.getRowId()));
                listProductName.add(String.valueOf(product.getName()));
            }
        }
        String[] param = listParamId.toArray(new String[listParamId.size()]);
        String[] name = listProductName.toArray(new String[listProductName.size()]);
        
        map.put("PARAM_ID", param);
        map.put("NAME_LIST", name);        
        
        mapper.transferProcess(map);
        
        List<String> procIdList = mapper.getProcIdList(map);
        String[] procId = procIdList.toArray(new String[procIdList.size()]);
        map.put("PROC_ID", procId);

        mapper.transferReplica(map);
        resultDto.setListParamId(procIdList);
        resultDto.setError_spcCode("0");
        resultDto.setError_spcMessage("OK");
        
        return resultDto;
    }
    
    public void insertDPObject(IFHMBSAPEAICDPP0026Dto dto)throws Exception{
        List<String> listParamId = new ArrayList<>();
        
        listParamId = dto.getListParamId();

        HashMap<String, String[]>  map = new HashMap<>();

        String[] param = listParamId.toArray(new String[listParamId.size()]);

        map.put("param_id", param);
        
        mapper.transferDPProcess(map);
    }
}
