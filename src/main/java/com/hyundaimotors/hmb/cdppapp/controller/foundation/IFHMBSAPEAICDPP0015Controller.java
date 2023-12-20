package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015.IFHMBSAPEAICDPP0015Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015.IFHMBSAPEAICDPP0015Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0015Service;
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

@Tag(name = "HMB Inbound Color", description = "This web service can be used to insert or Update  List Of Val  Color into Connex.")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0015Controller {

    private static final String IF_ID = "IF015";
    
    private final ApiLogService logService;
    
    private final IFHMBSAPEAICDPP0015Service service;
    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Inbound Color", description = "HMB Inbound Color")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0015Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBInboundColor")
    public Object upserObject(@Valid @RequestBody IFHMBSAPEAICDPP0015Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBSAPEAICDPP0015Payload.Response response = new IFHMBSAPEAICDPP0015Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBSAPEAICDPP0015Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0015Dto.class);
            IFHMBSAPEAICDPP0015Dto resultDto = new IFHMBSAPEAICDPP0015Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBSAPEAICDPP0015Payload.Response.class);
            response.setErrorSpcCode("0");
            response.setErrorSpcMessage("OK");

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));

            service.insertDPObject(resultDto);
        }catch(Exception e) {
             response.setErrorSpcCode("500");
             response.setErrorSpcMessage(e.getLocalizedMessage());
             ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        
        return response;
    }
}
