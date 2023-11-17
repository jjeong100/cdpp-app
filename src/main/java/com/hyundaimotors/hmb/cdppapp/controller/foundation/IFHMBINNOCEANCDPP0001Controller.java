package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0001Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0001Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0001Service;
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

@Tag(name = "HMB Get Contact WF", description = "INNOCEAN, EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0001Controller {
    private static final String IF_ID = "IF001";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0001Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get Contact WF", description = "HMB Get Contact WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0001Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetContactWF")
    public Object getObject(@Valid @RequestBody IFHMBINNOCEANCDPP0001Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0001Payload.Response response = new IFHMBINNOCEANCDPP0001Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        ModelMapper modelMapper = new ModelMapper();
        try {
            IFHMBINNOCEANCDPP0001Dto resultDto = new IFHMBINNOCEANCDPP0001Dto();
            IFHMBINNOCEANCDPP0001Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0001Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.getObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = modelMapper.map(resultDto, IFHMBINNOCEANCDPP0001Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
        	response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        
        return response;
    }
}
