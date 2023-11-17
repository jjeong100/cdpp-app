package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBMAPFRECDPP0009Service;
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

@Tag(name = "HMB Auto Vehicle RSA Claim WS", description = "This web service can be used to insert or update Auto Vehicle Information")
@RestController
@RequiredArgsConstructor
public class IFHMBMAPFRECDPP0009Controller {

    private static final String IF_ID = "IF010";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBMAPFRECDPP0009Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Auto Vehicle RSA Claim WS", description = "HMB Auto Vehicle RSA Claim WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBMAPFRECDPP0009Payload.Request.class)))
    @PostMapping(value = "/api/v1/HMBAutoVehicleRSAClaimWS")
    public Object upsertObject(@Valid @RequestBody IFHMBMAPFRECDPP0009Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBMAPFRECDPP0009Payload.Response response = new IFHMBMAPFRECDPP0009Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
         IFHMBMAPFRECDPP0009Dto dto = defaultMapper.map(request, IFHMBMAPFRECDPP0009Dto.class);

         ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
         IFHMBMAPFRECDPP0009Dto resultDto = service.upsertObject(dto);
         ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);

         response = ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBMAPFRECDPP0009Payload.Response.class) : null;
         ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
