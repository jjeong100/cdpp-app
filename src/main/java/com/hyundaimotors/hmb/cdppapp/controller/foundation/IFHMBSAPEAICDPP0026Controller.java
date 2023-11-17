package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026.IFHMBSAPEAICDPP0026Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0026.IFHMBSAPEAICDPP0026Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0026Service;
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

@Tag(name = "HMB Product List Inbound WF", description = "SAP EAI Product Create/Update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0026Controller {

    private static final String IF_ID = "IF031";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBSAPEAICDPP0026Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "UpsertProductList", description = "UpsertProductList")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0026Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBProductListInboundWF")
    public Object insertObject(@Valid @RequestBody IFHMBSAPEAICDPP0026Payload.Request request)throws Exception{
    	UUID IF_TR_ID = UUID.randomUUID();
    	
    	IFHMBSAPEAICDPP0026Payload.Response response = new IFHMBSAPEAICDPP0026Payload.Response();
    	ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
    	try {
        IFHMBSAPEAICDPP0026Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0026Dto.class);

        ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
        IFHMBSAPEAICDPP0026Dto result = service.insertObject(dto);
        ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);

        response = defaultMapper.map(result, IFHMBSAPEAICDPP0026Payload.Response.class);
        ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
    	}catch(Exception e) {
            response.setError_spcCode("500");
            response.setError_spcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
    	}
    	return response;
    }    
}
