package com.hyundaimotors.hmb.cdppapp.controller.lead;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0088.IFHMBINNOCEANCDPP0088Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0088.IFHMBINNOCEANCDPP0088Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0088Service;
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

@Tag(name = "HMB Amaro CSI Survey WS", description = "This web service can be used to send survey data to Connex.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0088Controller {

    private static final String IF_ID = "IF088";
    
    private final ApiLogService logService;

    private final IFHMBINNOCEANCDPP0088Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Amaro CSI Survey WS", description = "HMB Amaro CSI Survey WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0088Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAmaroCSISurveyWS")
    public Object updateObject(@Valid @RequestBody IFHMBINNOCEANCDPP0088Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();

        IFHMBINNOCEANCDPP0088Payload.Response response = new IFHMBINNOCEANCDPP0088Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        try {
            IFHMBINNOCEANCDPP0088Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0088Dto.class);
            
            IFHMBINNOCEANCDPP0088Dto resultDto = new IFHMBINNOCEANCDPP0088Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0088Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
