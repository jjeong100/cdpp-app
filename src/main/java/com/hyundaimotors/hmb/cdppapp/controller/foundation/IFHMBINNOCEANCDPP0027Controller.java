package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0027Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0027Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0027Service;
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

@Tag(name = "HMB Register In Application WS", description = "Innocean insert or update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0027Controller {

    private static final String IF_ID = "IF032";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0027Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "registers insert", description = "registers insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0027Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBRegisterInApplicationWS")
    public Object upsertObject(@Valid @RequestBody IFHMBINNOCEANCDPP0027Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0027Payload.Response response = new IFHMBINNOCEANCDPP0027Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            ModelMapper modelMapper = new ModelMapper();
            IFHMBINNOCEANCDPP0027Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0027Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBINNOCEANCDPP0027Dto resultDto = service.upsertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = modelMapper.map(resultDto, IFHMBINNOCEANCDPP0027Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }

}
