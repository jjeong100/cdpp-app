package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0023.IFHMBINNOCEANCDPP0023Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0023.IFHMBINNOCEANCDPP0023Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0023Service;
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

@Tag(name = "HMB MNTSRVC Manage Employee Availability", description = "This web service can be used to manage the maintenance service consultant availability. This web service will use a synchronize operation and expects to receive one item in the list for each week day available. The week days not present in the XML file will be excluded from the consultant availability, making the Connex database look like an exact photo from the xml.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0023Controller {

    private static final String IF_ID = "IF025";
    
    private final ApiLogService logService;
    
    private final IFHMBINNOCEANCDPP0023Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMBMNTSRVCManageEmployeeAvailability", description = "HMB MNTSRVC Manage Employee Availability")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0023Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCManageEmployeeAvailability")
    public Object upsertObject(@Valid @RequestBody IFHMBINNOCEANCDPP0023Payload.Request request) throws Exception {

        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0023Payload.Response response = new IFHMBINNOCEANCDPP0023Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBINNOCEANCDPP0023Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0023Dto.class);
            
            IFHMBINNOCEANCDPP0023Dto resultDto = new IFHMBINNOCEANCDPP0023Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0023Payload.Response.class);
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
