package com.hyundaimotors.hmb.cdppapp.controller.lead;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0038Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038.IFHMBSAPEAICDPP0038Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0038Service;
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

@Tag(name = "HMB Update Lead WS", description = "The web service will Update the lead information about a specific day and respond to the Dealer.")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0038Controller {

    private static final String IF_ID = "IF048";
    
    private final ApiLogService logService;
    
    private final IFHMBSAPEAICDPP0038Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Update Lead WS", description = "HMB Update Lead WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0038Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBUpdateLeadWS")
    public Object updateObject(@Valid @RequestBody IFHMBSAPEAICDPP0038Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();

        IFHMBSAPEAICDPP0038Payload.Response response = new IFHMBSAPEAICDPP0038Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        try {
            IFHMBSAPEAICDPP0038Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0038Dto.class);
            
            IFHMBSAPEAICDPP0038Dto resultDto = new IFHMBSAPEAICDPP0038Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBSAPEAICDPP0038Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
             response.setErrorSpcCode("500");
             response.setErrorSpcMessage(e.getLocalizedMessage());
             ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
