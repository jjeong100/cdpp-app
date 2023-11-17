package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0035Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0035Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0035Service;
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

@Tag(name = "HMB Service Request Attachment", description = "This web service can be used to insert attachment  into Connex system.")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0035Controller {

    private static final String IF_ID = "IF044";
    
    private final ApiLogService logService;

    private final IFHMBSAPEAICDPP0035Service service;
    
    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Service Request Attachment", description = "HMB Service Request Attachment")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0035Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBServiceRequestAttachment")
    public Object upserObject(@Valid @RequestBody IFHMBSAPEAICDPP0035Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBSAPEAICDPP0035Payload.Response response = new IFHMBSAPEAICDPP0035Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBSAPEAICDPP0035Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0035Dto.class);
            IFHMBSAPEAICDPP0035Dto resultDto = new IFHMBSAPEAICDPP0035Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBSAPEAICDPP0035Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
    
}
