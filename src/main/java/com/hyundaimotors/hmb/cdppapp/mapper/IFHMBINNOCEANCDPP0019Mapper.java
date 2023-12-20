package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0019Dto;

public interface IFHMBINNOCEANCDPP0019Mapper {
    
    public List<IFHMBINNOCEANCDPP0019Dto> getList(IFHMBINNOCEANCDPP0019Dto dto)throws Exception;

    public List<String> getHolyDayList(IFHMBINNOCEANCDPP0019Dto dto)throws Exception;

    public List<String> getMaintenanceDayList(IFHMBINNOCEANCDPP0019Dto dto)throws Exception;
    
    public List<String> getWeekDayList(IFHMBINNOCEANCDPP0019Dto dto)throws Exception;
}
