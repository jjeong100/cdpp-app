package com.hyundaimotors.hmb.cdppapp.controller.lead;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDMSCDPP0004Service;
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

@Tag(name = "HMB Get Lead WS", description = "DMS list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBDMSCDPP0004Controller {

    private static final String IF_ID = "IF006";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBDMSCDPP0004Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Lead list", description = "Lead list.")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBDMSCDPP0004Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetLeadWS")
    public Object getObject(@Valid @RequestBody IFHMBDMSCDPP0004Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();

        IFHMBDMSCDPP0004Payload.Response response = new IFHMBDMSCDPP0004Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
         
        try {
            IFHMBDMSCDPP0004Dto dto = defaultMapper.map(request, IFHMBDMSCDPP0004Dto.class);
            IFHMBDMSCDPP0004Dto resultDto = new IFHMBDMSCDPP0004Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBDMSCDPP0004Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorspcCode("500");
            response.setErrorspcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
