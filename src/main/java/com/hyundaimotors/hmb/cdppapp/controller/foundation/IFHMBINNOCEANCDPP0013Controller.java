package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013.IFHMBINNOCEANCDPP0013Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0002Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0013.IFHMBINNOCEANCDPP0013Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0013Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLog;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Inbound Channel Partner Interface Workflow", description = "delear Account Insert Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0013Controller {

    private static final String IF_ID = "IF014";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0013Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "delear Account Insert", description = "delear Account Insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0002Payload.Request.class)))
    @PostMapping(value = "/api/v1/HMBInboundChannelPartnerInterfaceWorkflow")
    public Object upsertObject(@Valid @RequestBody IFHMBINNOCEANCDPP0013Payload.Request request) throws Exception {
       UUID IF_TR_ID = UUID.randomUUID();
       
       IFHMBINNOCEANCDPP0013Payload.Response response = new IFHMBINNOCEANCDPP0013Payload.Response();
       ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
       try {
           IFHMBINNOCEANCDPP0013Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0013Dto.class);
           
           ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
           IFHMBINNOCEANCDPP0013Dto resultDto = service.upsertObject(dto);
           ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
       
           response = defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0013Payload.Response.class);
           ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
       }catch(Exception e) {
    	   response.setErrorSpcCode("500");
           response.setErrorSpcMessage(e.getLocalizedMessage());
           ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
       }
       return response;
    }
}
