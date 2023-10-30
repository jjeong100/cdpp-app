package com.hyundaimotors.hmb.cdppapp.controller.lead;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDMSCDPP0004Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Get Lead WS", description = "DMS list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBDMSCDPP0004Controller {

    private static final String IF_ID = "IF006";
    
    @Autowired
    private final IFHMBDMSCDPP0004Service service;

    private final ModelMapper defaultMapper;



    @Operation(summary = "Lead list", description = "Lead list.")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBDMSCDPP0004Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetLeadWS")
    public Object getObject(@RequestBody IFHMBDMSCDPP0004Payload.Request request)throws Exception{

        IFHMBDMSCDPP0004Dto dto = defaultMapper.map(request, IFHMBDMSCDPP0004Dto.class);
        
        IFHMBDMSCDPP0004Dto resultDto = new IFHMBDMSCDPP0004Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBDMSCDPP0004Payload.Response.class);
    }
}
