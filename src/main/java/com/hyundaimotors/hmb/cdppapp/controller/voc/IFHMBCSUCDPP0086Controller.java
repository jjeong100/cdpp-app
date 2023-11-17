package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0086Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0086Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0086Service;
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

@Tag(name = "HMB Search IVR Contact", description = "This web service will be created to be used to search IVR Contact ) by phone number and return contact / protocol information.")
@RestController
@RequiredArgsConstructor
public class IFHMBCSUCDPP0086Controller {

    private static final String IF_ID = "IF086";
    
    private final ApiLogService logService;

    private final IFHMBCSUCDPP0086Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Search IVR Contact", description = "HMB Search IVR Contact")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBCSUCDPP0086Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBSearchIVRContact")
    public Object insertObject(@Valid @RequestBody IFHMBCSUCDPP0086Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBCSUCDPP0086Payload.Response response = new IFHMBCSUCDPP0086Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBCSUCDPP0086Dto dto = defaultMapper.map(request, IFHMBCSUCDPP0086Dto.class);
            IFHMBCSUCDPP0086Dto resultDto = new IFHMBCSUCDPP0086Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBCSUCDPP0086Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
             response.setErrorSpcCode("500");
             response.setErrorSpcMessage(e.getLocalizedMessage());

             ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
