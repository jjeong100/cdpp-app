package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.ListOfAutoVehicleDto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ContactData;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfAutoVehicle;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfContactSocialMedia;

public interface IFHMBINNOCEANCDPP0037Mapper {
    
    public void insertObject(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public void insertAutoVehicle(ListOfAutoVehicleDto dto)throws Exception;

    public int checkAccountId(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public void insertSocialMedia(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public ContactData getUpdateContactOutput(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public List<ListOfAutoVehicle> getListVehicle(HashMap<String, String[]> parMap)throws Exception;

    public List<ListOfContactSocialMedia> getListSocialMedia(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;
}
