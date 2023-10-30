package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025.ScheduleMaintenanceINDto;

public interface IFHMBINNOCEANCDPP0025Mapper {

     public int insertObject(ScheduleMaintenanceINDto ScheduleMaintenanceIN)throws Exception;

     public void transferProcess(HashMap<String, String> parMap)throws Exception;

}
