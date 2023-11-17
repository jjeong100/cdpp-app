package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0012.IFHMBINNOCEANCDPP0012Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012.IFHMBINNOCEANCDPP0012Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0012Service;
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

@Tag(name = "HMB Channel Partner Get Webservice Inbound WF", description = "This web service will be created to be used to search Channel Partner  (individuals) by source and return channet /Contact information.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0012Controller {

    private static final String IF_ID = "IF013";
    
    private final ApiLogService logService;

    @Autowired
    private final IFHMBINNOCEANCDPP0012Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Channel Partner Get Webservice Inbound WF", description = "HMB Channel Partner Get Webservice Inbound WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0012Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBChannelPartnerGetWebserviceInboundWF")
    public Object getObject(@Valid @RequestBody IFHMBINNOCEANCDPP0012Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0012Payload.Response response = new IFHMBINNOCEANCDPP0012Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBINNOCEANCDPP0012Dto resultDto = new IFHMBINNOCEANCDPP0012Dto();
            IFHMBINNOCEANCDPP0012Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0012Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.getObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response =  defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0012Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
        	response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }

        return response;
    }
}
