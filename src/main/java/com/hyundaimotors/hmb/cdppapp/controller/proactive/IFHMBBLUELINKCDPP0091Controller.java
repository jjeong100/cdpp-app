package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091.IFHMBBLUELINKCDPP0091Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0091.IFHMBBLUELINKCDPP0091Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBBLUELINKCDPP0091Service;
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

@Tag(name = "HMB Get BLK WF", description = "Interface Requirement for Get Bluelink I/F Requirement")
@RestController
@RequiredArgsConstructor
public class IFHMBBLUELINKCDPP0091Controller {

    private static final String IF_ID = "IF091";
    
    private final ApiLogService logService;
    
    private final IFHMBBLUELINKCDPP0091Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get BLK WF", description = "HMB Get BLK WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBBLUELINKCDPP0091Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetBLKWF")
    public Object updateObject(@Valid @RequestBody IFHMBBLUELINKCDPP0091Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBBLUELINKCDPP0091Payload.Response response = new IFHMBBLUELINKCDPP0091Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        try {
            IFHMBBLUELINKCDPP0091Dto dto = defaultMapper.map(request, IFHMBBLUELINKCDPP0091Dto.class);
            IFHMBBLUELINKCDPP0091Dto resultDto = new IFHMBBLUELINKCDPP0091Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBBLUELINKCDPP0091Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
