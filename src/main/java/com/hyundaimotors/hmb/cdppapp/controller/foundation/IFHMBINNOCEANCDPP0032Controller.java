package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032.IFHMBINNOCEANCDPP0032Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0032.IFHMBINNOCEANCDPP0032Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0032Service;
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

@Tag(name = "HMB Search TD Webservice WF", description = "Innocean, SAP EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0032Controller {

    private static final String IF_ID = "IF036";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0032Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Search TD Webservice WF", description = "HMB Search TD Webservice WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0032Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBSearchTDWebserviceWF")
    public Object getObject(@Valid @RequestBody IFHMBINNOCEANCDPP0032Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0032Payload.Response response = new IFHMBINNOCEANCDPP0032Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        ModelMapper modelMapper = new ModelMapper();

        try {
            IFHMBINNOCEANCDPP0032Dto resultDto = new IFHMBINNOCEANCDPP0032Dto();
    
            IFHMBINNOCEANCDPP0032Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0032Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.getObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = modelMapper.map(resultDto, IFHMBINNOCEANCDPP0032Payload.Response.class);
            response.setErrorSpcCode("0");
            response.setErrorSpcMessage("OK");

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
             response.setErrorSpcCode("500");
             response.setErrorSpcMessage(e.getLocalizedMessage());
              ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
