package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0028Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0028Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0028Service;
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

@Tag(name = "HMB Register Loyalty Benefit Used WS", description = "Innocean Benefit insert or update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0028Controller {

    private static final String IF_ID = "IF033";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0028Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Benefit imfomation upsert", description = "Benefit imfomation upsert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0028Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBRegisterLoyaltyBenefitUsedWS")
    public Object upsertObject(@Valid @RequestBody IFHMBINNOCEANCDPP0028Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0028Payload.Response response = new IFHMBINNOCEANCDPP0028Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        try {
            IFHMBINNOCEANCDPP0028Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0028Dto.class);
            
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBINNOCEANCDPP0028Dto resultDto = service.upsertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0028Payload.Response.class) : null;
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
             response.setErrorSpcCode("500");
             response.setErrorSpcMessage(e.getLocalizedMessage());
             ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        
        return response;
    }
}
