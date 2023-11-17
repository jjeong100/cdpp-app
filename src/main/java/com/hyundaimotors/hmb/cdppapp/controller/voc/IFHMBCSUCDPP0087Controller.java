package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.IFHMBCSUCDPP0087Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087.IFHMBCSUCDPP0087Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0087Service;
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

@Tag(name = "HMBSearchContactWF", description = "This web service will be created to be used to search Contact  by Contact id, Serial number, Campaimg Name  and return  Vehicle, Campaing nformation and Contacts.")
@RestController
@RequiredArgsConstructor
public class IFHMBCSUCDPP0087Controller {

    private static final String IF_ID = "IF087";
    
    private final ApiLogService logService;

    private final IFHMBCSUCDPP0087Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMBSearchContactWF", description = "HMBSearchContactWF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBCSUCDPP0087Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBSearchContactWF")
    public Object insertObject(@Valid @RequestBody IFHMBCSUCDPP0087Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBCSUCDPP0087Payload.Response response = new IFHMBCSUCDPP0087Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBCSUCDPP0087Dto dto = defaultMapper.map(request, IFHMBCSUCDPP0087Dto.class);
            IFHMBCSUCDPP0087Dto resultDto = new IFHMBCSUCDPP0087Dto();
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBCSUCDPP0087Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
