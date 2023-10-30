package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0018Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0018Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0018Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Customer Schedule", description = "This web service can be used to query the customer's maintenance service schedule.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0018Controller {

    private static final String IF_ID = "IF018";

    @Autowired
    private final IFHMBINNOCEANCDPP0018Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Customer Schedule", description = "HMB MNTSRVC Customer Schedule ")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0018Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCCustomerSchedule")
    public Object getList(@RequestBody IFHMBINNOCEANCDPP0018Payload.Request request)throws Exception{
        ModelMapper modelMapper = new ModelMapper();
    
        IFHMBINNOCEANCDPP0018Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0018Dto.class);

        List<IFHMBINNOCEANCDPP0018Dto> resultList = new ArrayList<>();

        resultList = service.getList(dto);
        
        return IFHMBINNOCEANCDPP0018Payload.Response.builder()
                .errorSpcCode("0")
                .errorSpcMessage("OK")
                .listOfServices(resultList.size() > 0 ? defaultMapper.map(resultList, new TypeToken<List<IFHMBINNOCEANCDPP0018Payload.ListOfServices>>() {}.getType()) : null)
                .build();
    }    
}
