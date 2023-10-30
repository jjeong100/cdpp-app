package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079.IFHMBSAPCDPP0079Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079.IFHMBSAPCDPP0079Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPCDPP0079Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Inbound Repair Order", description = "HMB Inbound Repair Order")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPCDPP0079Controller {

    private static final String IF_ID = "IF079";
    
    private final IFHMBSAPCDPP0079Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Inbound Repair Order", description = "HMB Inbound Repair Order")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPCDPP0079Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBInboundRepairOrder")
    public Object upsertObject(@RequestBody IFHMBSAPCDPP0079Payload.Request request)throws Exception{
        
        IFHMBSAPCDPP0079Dto resultDto = new IFHMBSAPCDPP0079Dto();
        IFHMBSAPCDPP0079Dto dto = defaultMapper.map(request, IFHMBSAPCDPP0079Dto.class);

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBSAPCDPP0079Payload.Response.class);
    }
}
