package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.HashMap;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0037Service;
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

@Tag(name = "HMB Update Contact IN WF", description = "Innocean, SAP EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0037Controller {

    private static final String IF_ID = "IF046";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0037Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Person Account Update", description = "Person Account Update")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0037Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBUpdateContactINWF")
    public Object updateObject(@Valid @RequestBody IFHMBINNOCEANCDPP0037Payload.Request request) throws Exception {
       UUID IF_TR_ID = UUID.randomUUID();

       IFHMBINNOCEANCDPP0037Payload.Response response = new IFHMBINNOCEANCDPP0037Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
       
        try {
            IFHMBINNOCEANCDPP0037Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0037Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            HashMap<String, Object> result = service.updateObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
            
            response = defaultMapper.map(result, IFHMBINNOCEANCDPP0037Payload.Response.class);
            response.setError_spcCode("0");
            response.setError_spcMessage("OK");
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));


            service.insertDPObject(result);
            
        }catch(Exception e) {
            response.setError_spcCode("500");
            response.setError_spcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        
        return response;
    }

}
