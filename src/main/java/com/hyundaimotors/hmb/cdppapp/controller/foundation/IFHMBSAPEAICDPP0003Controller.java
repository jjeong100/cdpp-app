package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0003Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0003Service;
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

@Tag(name = "HMB Product Inbound WF", description = "SAP, EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0003Controller {

    private static final String IF_ID = "IF005";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBSAPEAICDPP0003Service service;

    private final ModelMapper defaultMapper;
    
    @Operation(summary = "Vehicle upsert", description = "Vehicle insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0003Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBProductInboundWF")
    public Object insertObject(@Valid @RequestBody IFHMBSAPEAICDPP0003Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBSAPEAICDPP0003Payload.Response response = new IFHMBSAPEAICDPP0003Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBSAPEAICDPP0003Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0003Dto.class);
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBSAPEAICDPP0003Dto resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBSAPEAICDPP0003Payload.Response.class) : null;
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            String message = e.getLocalizedMessage();
            if(message == null || "".equals(message)) message = e.getCause().getMessage();
            response.setErrorSpcMessage(message);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        
        return  response;
    }
}
