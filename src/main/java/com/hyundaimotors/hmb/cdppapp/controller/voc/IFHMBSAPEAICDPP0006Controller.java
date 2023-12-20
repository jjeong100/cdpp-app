package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0006Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.IFHMBSAPEAICDPP0006Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0006Service;
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

@Tag(name = "HMB Action Inbound Webservice WF", description = "This web service can be used to  update Action information")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0006Controller {

    private static final String IF_ID = "IF008";
    
    private final ApiLogService logService;
    
    private final IFHMBSAPEAICDPP0006Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Action Inbound Webservice WF", description = "HMB Action Inbound Webservice WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0006Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBActionInboundWebserviceWF")
    public Object insertObject(@Valid @RequestBody IFHMBSAPEAICDPP0006Payload.Request request) throws Exception {
         UUID IF_TR_ID = UUID.randomUUID();
         
         ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
         IFHMBSAPEAICDPP0006Payload.Response response = new IFHMBSAPEAICDPP0006Payload.Response();
         try {
             IFHMBSAPEAICDPP0006Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0006Dto.class);
              
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBSAPEAICDPP0006Dto resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
     
            response  = defaultMapper.map(resultDto, IFHMBSAPEAICDPP0006Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
            service.insertDPObject(resultDto);
         }catch(Exception e) {
              response.setErrorSpcCode("500");
              response.setErrorSpcMessage(e.getLocalizedMessage());
              ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
         }
         return response;
    }
}
