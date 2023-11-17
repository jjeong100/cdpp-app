package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBZICARDCDPP0007Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0007Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBZICARDCDPP0007Service;
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

@Tag(name = "HMB Asset Contact Upsert Webservice WS", description = "INNOCEAN, EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBZICARDCDPP0007Controller {

    private static final String IF_ID = "IF009";
    
    private final ApiLogService logService;

    @Autowired
    private final IFHMBZICARDCDPP0007Service service;
    
    @Operation(summary = "assetContact upsert", description = "assetContact upsert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBZICARDCDPP0007Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAssetContactUpsertWS")
    public Object getObject(@Valid @RequestBody IFHMBZICARDCDPP0007Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBZICARDCDPP0007Payload.Response response = new IFHMBZICARDCDPP0007Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        try {

            ModelMapper modelMapper = new ModelMapper();
            IFHMBZICARDCDPP0007Dto dto = modelMapper.map(request, IFHMBZICARDCDPP0007Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBZICARDCDPP0007Dto resultDto = service.upsertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = modelMapper.map(resultDto, IFHMBZICARDCDPP0007Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        
        return response;
    }
}
