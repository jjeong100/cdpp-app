package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013.IFHMBINNOCEANCDPP0013Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0002Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0013.IFHMBINNOCEANCDPP0013Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0013Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Inbound Channel Partner Interface Workflow", description = "delear Account Insert Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0013Controller {

    private static final String IF_ID = "IF014";
    
    @Autowired
    private final IFHMBINNOCEANCDPP0013Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "delear Account Insert", description = "delear Account Insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0002Payload.Request.class)))
    @PostMapping(value = "/api/v1/HMBInboundChannelPartnerInterfaceWorkflow")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0013Payload.Request request)throws Exception{

        IFHMBINNOCEANCDPP0013Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0013Dto.class);

        IFHMBINNOCEANCDPP0013Dto resultDto = service.upsertObject(dto);

        return defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0013Payload.Response.class);
    }
}
