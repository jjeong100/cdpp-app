package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036.ChatDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036.IFHMBSMARTERSCDPP0036Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036.ServiceRequestChatInputDto;

public interface IFHMBSMARTERSCDPP0036Mapper {
    
    public void insertServiceRequestChatInput(IFHMBSMARTERSCDPP0036Dto dto)throws Exception;

    public void insertChat(ServiceRequestChatInputDto dto)throws Exception;

    public void insertMessage(ChatDto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public IFHMBSMARTERSCDPP0036Dto getPocessData(IFHMBSMARTERSCDPP0036Dto dto)throws Exception;

    public IFHMBSMARTERSCDPP0036Dto getProcessChat(IFHMBSMARTERSCDPP0036Dto dto)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public void transferDPProcess(HashMap<String, String> parMap)throws Exception;
}
