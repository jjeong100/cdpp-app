package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085.IFHMBCSUCDPP0085Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0085.IFHMBCSUCDPP0085Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0085Service;
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

@Tag(name = "HMB Closest Dealer WS", description = "This web service will be created to be used to search Closest Dealer (individuals) by CEP  and return channet /Contact information.")
@RestController
@RequiredArgsConstructor
public class IFHMBCSUCDPP0085Controller {

    private static final String IF_ID = "IF085";
    
    private final ApiLogService logService;

    private final IFHMBCSUCDPP0085Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Closest Dealer WS", description = "HMB Closest Dealer WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBCSUCDPP0085Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBClosestDealerWS")
    public Object insertObject(@Valid @RequestBody IFHMBCSUCDPP0085Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBCSUCDPP0085Payload.Response response = new IFHMBCSUCDPP0085Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        ModelMapper modelMapper = new ModelMapper();

        try {
        	IFHMBCSUCDPP0085Dto resultDto = new IFHMBCSUCDPP0085Dto();
        	IFHMBCSUCDPP0085Dto dto = defaultMapper.map(request, IFHMBCSUCDPP0085Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.getObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = modelMapper.map(resultDto, IFHMBCSUCDPP0085Payload.Response.class);
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
