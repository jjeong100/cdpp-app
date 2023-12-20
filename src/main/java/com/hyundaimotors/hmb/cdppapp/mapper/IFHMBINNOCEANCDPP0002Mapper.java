package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0002.IFHMBINNOCEANCDPP0002Dto;


public interface IFHMBINNOCEANCDPP0002Mapper {
	public String foundAccountIdbyNameAndPhoneAndEmail(IFHMBINNOCEANCDPP0002Dto dto)throws Exception;
	
    public String foundContactIdbyCpf(IFHMBINNOCEANCDPP0002Dto dto)throws Exception;

    public String foundContactId(IFHMBINNOCEANCDPP0002Dto dto)throws Exception;
    
    public int insertObject(IFHMBINNOCEANCDPP0002Dto dto) throws Exception;

    public int insertCar(IFHMBINNOCEANCDPP0002Dto dto) throws Exception;

    public int insertApp(IFHMBINNOCEANCDPP0002Dto dto) throws Exception;

    public int insertSocialmedia(IFHMBINNOCEANCDPP0002Dto dto) throws Exception;
    
    public int insertHobby(IFHMBINNOCEANCDPP0002Dto dto) throws Exception;
    
    public int insertSoccerteam(IFHMBINNOCEANCDPP0002Dto dto) throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;
    
    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public String getContactId(IFHMBINNOCEANCDPP0002Dto dto)throws Exception;
}
