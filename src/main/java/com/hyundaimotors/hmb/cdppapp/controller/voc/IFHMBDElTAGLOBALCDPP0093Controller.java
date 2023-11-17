package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDElTAGLOBALCDPP0093.IFHMBDElTAGLOBALCDPP0093Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDElTAGLOBALCDPP0093.IFHMBDElTAGLOBALCDPP0093Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDElTAGLOBALCDPP0093Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLog;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Delta Global - Inbound Rental Car Request Results", description = "Delta Global - Inbound Rental Car Request Results")
@RestController
@RequiredArgsConstructor
public class IFHMBDElTAGLOBALCDPP0093Controller {
    
    private static final String IF_ID = "IF093";
    
    private final ApiLogService logService;
    
    private final IFHMBDElTAGLOBALCDPP0093Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Delta Global - Inbound Rental Car Request Results", description = "Delta Global - Inbound Rental Car Request Results")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBDElTAGLOBALCDPP0093Payload.Response.class)))
    @PostMapping(value = "/api/v1/InboundRentalCarRequestResults")
    public Object insertObject(@RequestBody IFHMBDElTAGLOBALCDPP0093Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBDElTAGLOBALCDPP0093Payload.Response response = new IFHMBDElTAGLOBALCDPP0093Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBDElTAGLOBALCDPP0093Dto dto = defaultMapper.map(request, IFHMBDElTAGLOBALCDPP0093Dto.class);
            
            IFHMBDElTAGLOBALCDPP0093Dto resultDto = new IFHMBDElTAGLOBALCDPP0093Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = defaultMapper.map(resultDto, IFHMBDElTAGLOBALCDPP0093Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
             response.setErrorSpcCode("500");
             response.setErrorSpcMessage(e.getLocalizedMessage());

             ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
