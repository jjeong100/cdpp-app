package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0022.IFHMBINNOCEANCDPP0022Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0022.IFHMBINNOCEANCDPP0022Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0022Service;
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

@Tag(name = "HMB MNTSRVC Manage Dealer Holiday", description = "Innocean SAP EAI insert Delete Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0022Controller {
    
    private static final String IF_ID = "IF023";
    
    private final ApiLogService logService;

    @Autowired
    private final IFHMBINNOCEANCDPP0022Service service;

    private final ModelMapper defaultMapper;
    
    @Operation(summary = "dealer holiday insert", description = "dealer holiday insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0022Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCManageDealerHoliday")
    public Object manageObject(@Valid @RequestBody IFHMBINNOCEANCDPP0022Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0022Payload.Response response = new IFHMBINNOCEANCDPP0022Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBINNOCEANCDPP0022Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0022Dto.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBINNOCEANCDPP0022Dto resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0022Payload.Response.class) : null;
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
