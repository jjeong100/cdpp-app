package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0091.IFHMBBLUELINKCDPP0091Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0091.IFHMBBLUELINKCDPP0091Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBBLUELINKCDPP0091Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Get BLK WF", description = "Interface Requirement for Get Bluelink I/F Requirement")
@RestController
@RequiredArgsConstructor
public class IFHMBBLUELINKCDPP0091Controller {

    private static final String IF_ID = "IF091";
    
     private final IFHMBBLUELINKCDPP0091Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get BLK WF", description = "HMB Get BLK WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBBLUELINKCDPP0091Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetBLKWF")
    public Object updateObject(@RequestBody IFHMBBLUELINKCDPP0091Payload.Request request)throws Exception{

        IFHMBBLUELINKCDPP0091Dto dto = defaultMapper.map(request, IFHMBBLUELINKCDPP0091Dto.class);
        
        IFHMBBLUELINKCDPP0091Dto resultDto = new IFHMBBLUELINKCDPP0091Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBBLUELINKCDPP0091Payload.Response.class);
    }
}
