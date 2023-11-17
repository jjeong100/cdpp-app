package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0053.IFHMBBLUELINKCDPP0053Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053.IFHMBBLUELINKCDPP0053Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBBLUELINKCDPP0053Service;
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

@Tag(name = "HMB Auto Vehicle Bluelink WS", description = "This web service can be used to insert Bluelink data.")
@RestController
@RequiredArgsConstructor
public class IFHMBBLUELINKCDPP0053Controller {

    private static final String IF_ID = "IF063";
    
    private final ApiLogService logService;
    
    private final IFHMBBLUELINKCDPP0053Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Auto Vehicle Bluelink WS", description = "HMB Auto Vehicle Bluelink WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBBLUELINKCDPP0053Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAutoVehicleBluelinkWS")
    public Object getList(@Valid @RequestBody IFHMBBLUELINKCDPP0053Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
    
        IFHMBBLUELINKCDPP0053Payload.Response response = new IFHMBBLUELINKCDPP0053Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBBLUELINKCDPP0053Dto dto = defaultMapper.map(request, IFHMBBLUELINKCDPP0053Dto.class);
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBBLUELINKCDPP0053Dto resultDto = service.insertList(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBBLUELINKCDPP0053Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
