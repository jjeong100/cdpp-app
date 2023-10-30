package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0003Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0003Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Product Inbound WF", description = "SAP, EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0003Controller {

    private static final String IF_ID = "IF005";
    
    @Autowired
    private final IFHMBSAPEAICDPP0003Service service;

    private final ModelMapper defaultMapper;
    
    @Operation(summary = "Vehicle upsert", description = "Vehicle insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0003Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBProductInboundWF")
    public Object insertObject(@RequestBody IFHMBSAPEAICDPP0003Payload.Request request)throws Exception{

        IFHMBSAPEAICDPP0003Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0003Dto.class);

        IFHMBSAPEAICDPP0003Dto resultDto = service.insertObject(dto);

        return ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBSAPEAICDPP0003Payload.Response.class) : null;
        
    }
}
