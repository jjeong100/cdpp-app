package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0022.IFHMBINNOCEANCDPP0022Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0022.IFHMBINNOCEANCDPP0022Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0022Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Manage Dealer Holiday", description = "Innocean SAP EAI insert Delete Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0022Controller {
    
    private static final String IF_ID = "IF023";

    @Autowired
    private final IFHMBINNOCEANCDPP0022Service service;

    private final ModelMapper defaultMapper;
    
    @Operation(summary = "dealer holiday insert", description = "dealer holiday insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0022Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCManageDealerHoliday")
    public Object manageObject(@RequestBody IFHMBINNOCEANCDPP0022Payload.Request request)throws Exception{
        IFHMBINNOCEANCDPP0022Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0022Dto.class);
        
        IFHMBINNOCEANCDPP0022Dto resultDto = service.insertObject(dto);

        return ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0022Payload.Response.class) : null;
    }

}
