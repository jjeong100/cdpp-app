package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025.ScheduleMaintenanceINDto;

public interface IFHMBINNOCEANCDPP0025Mapper {

     public void insertObject(ScheduleMaintenanceINDto ScheduleMaintenanceIN)throws Exception;

     public String getProcProtocol(ScheduleMaintenanceINDto dto)throws Exception;

     public void transferProcess(HashMap<String, String> parMap)throws Exception;

     public void transferReplica(HashMap<String, String> parMap)throws Exception;

}
