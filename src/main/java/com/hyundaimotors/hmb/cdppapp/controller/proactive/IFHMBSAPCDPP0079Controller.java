package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079.IFHMBSAPCDPP0079Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079.IFHMBSAPCDPP0079Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPCDPP0079Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLog;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Inbound Repair Order", description = "HMB Inbound Repair Order")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPCDPP0079Controller {

    private static final String IF_ID = "IF079";
    
    private final ApiLogService logService;
    
    private final IFHMBSAPCDPP0079Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Inbound Repair Order", description = "HMB Inbound Repair Order")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPCDPP0079Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBInboundRepairOrder")
    public Object upsertObject(@RequestBody IFHMBSAPCDPP0079Payload.Request request)throws Exception{
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBSAPCDPP0079Payload.Response response = new IFHMBSAPCDPP0079Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBSAPCDPP0079Dto resultDto = new IFHMBSAPCDPP0079Dto();
            IFHMBSAPCDPP0079Dto dto = defaultMapper.map(request, IFHMBSAPCDPP0079Dto.class);
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBSAPCDPP0079Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
