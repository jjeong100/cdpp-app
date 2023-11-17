package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025.IFHMBINNOCEANCDPP0025Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0025.IFHMBINNOCEANCDPP0025Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0025Service;
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

@Tag(name = "HMB MNTSRVC Schedule Maintenance", description = "This web service can be used to insert or update maintenance services.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0025Controller {

    private static final String IF_ID = "IF029";
    
    private final ApiLogService logService;
    
    private final IFHMBINNOCEANCDPP0025Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Schedule Maintenance", description = "HMB MNTSRVC Schedule Maintenance")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0025Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCScheduleMaintenance")
    public Object upsertObject(@Valid @RequestBody IFHMBINNOCEANCDPP0025Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0025Payload.Response response = new IFHMBINNOCEANCDPP0025Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            ModelMapper modelMapper = new ModelMapper();
            IFHMBINNOCEANCDPP0025Dto resultDto = new IFHMBINNOCEANCDPP0025Dto();
            IFHMBINNOCEANCDPP0025Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0025Dto.class);
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.upsertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            modelMapper.createTypeMap(IFHMBINNOCEANCDPP0025Dto.class, IFHMBINNOCEANCDPP0025Payload.Response.class).addMapping(IFHMBINNOCEANCDPP0025Dto::getDtoSrnumber, IFHMBINNOCEANCDPP0025Payload.Response::setSrNumber);
    
            response = modelMapper.map(resultDto, IFHMBINNOCEANCDPP0025Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
