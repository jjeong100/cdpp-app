package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0019Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0019Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0019Service;
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

@Tag(name = "HMB MNTSRVC Dealer Calendar", description = "This web service can be used to query availability of dealer's maintenance service schedule for a specific month.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0019Controller {

    private static final String IF_ID = "IF019";
    
    private final ApiLogService logService;
    
    private final IFHMBINNOCEANCDPP0019Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Dealer Calendar", description = "HMB MNTSRVC Dealer Calendar ")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0019Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCDealerCalendar")
    public Object getList(@Valid @RequestBody IFHMBINNOCEANCDPP0019Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0019Payload.Response response = null;
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        try {
            ModelMapper modelMapper = new ModelMapper();
        
            IFHMBINNOCEANCDPP0019Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0019Dto.class);
    
            List<IFHMBINNOCEANCDPP0019Dto> resultList = new ArrayList<>();
    
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultList = service.getList(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
            
            response = IFHMBINNOCEANCDPP0019Payload.Response.builder()
                    .errorSpcCode("0")
                    .errorSpcMessage("OK")
                    .listOfDays(resultList.size() > 0 ? defaultMapper.map(resultList, new TypeToken<List<IFHMBINNOCEANCDPP0019Payload.ListOfDays>>() {}.getType()) : null)
                    .build();
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response = IFHMBINNOCEANCDPP0019Payload.Response.builder()
                                                   .errorSpcCode("500")
                                                   .errorSpcMessage(e.getLocalizedMessage())
                                                   .build();

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
