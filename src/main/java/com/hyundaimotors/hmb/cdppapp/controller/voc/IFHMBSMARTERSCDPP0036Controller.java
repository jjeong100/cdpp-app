package com.hyundaimotors.hmb.cdppapp.controller.voc;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036.IFHMBSMARTERSCDPP0036Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036.IFHMBSMARTERSCDPP0036Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSMARTERSCDPP0036Service;
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

@Tag(name = "HMB Service Request Chat WS", description = "This web service can be used to insert or update Mesage de Chat into Connex.")
@RestController
@RequiredArgsConstructor
public class IFHMBSMARTERSCDPP0036Controller {

    private static final String IF_ID = "IF045";
    
    private final ApiLogService logService;
    
    private final IFHMBSMARTERSCDPP0036Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Service Request Chat WS", description = "HMB Service Request Chat WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSMARTERSCDPP0036Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBServiceRequestChatWS")
    public Object insertObject(@RequestBody IFHMBSMARTERSCDPP0036Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBSMARTERSCDPP0036Payload.Response response = new IFHMBSMARTERSCDPP0036Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            IFHMBSMARTERSCDPP0036Dto dto = defaultMapper.map(request, IFHMBSMARTERSCDPP0036Dto.class);
            
            IFHMBSMARTERSCDPP0036Dto resultDto = new IFHMBSMARTERSCDPP0036Dto();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.insertObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.createTypeMap(IFHMBSMARTERSCDPP0036Dto.class, IFHMBSMARTERSCDPP0036Payload.Response.class)
                                    .addMapping(IFHMBSMARTERSCDPP0036Dto::getProcessProtocol, IFHMBSMARTERSCDPP0036Payload.Response::setProtocol);
    
            response = modelMapper.map(resultDto, IFHMBSMARTERSCDPP0036Payload.Response.class);
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
