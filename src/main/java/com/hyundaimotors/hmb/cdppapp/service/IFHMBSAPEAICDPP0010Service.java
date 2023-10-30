package com.hyundaimotors.hmb.cdppapp.service;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0010.IFHMBSAPEAICDPP0010Dto;

public interface IFHMBSAPEAICDPP0010Service {

    public HashMap<String, Object> UpsertAutoVehicle(IFHMBSAPEAICDPP0010Dto dto)throws Exception;
    
}
