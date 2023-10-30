package com.hyundaimotors.hmb.cdppapp.controller.lead;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0038Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0038.IFHMBSAPEAICDPP0038Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0038Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Update Lead WS", description = "The web service will Update the lead information about a specific day and respond to the Dealer.")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0038Controller {

    private static final String IF_ID = "IF048";
    
    private final IFHMBSAPEAICDPP0038Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Update Lead WS", description = "HMB Update Lead WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0038Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBUpdateLeadWS")
    public Object updateObject(@RequestBody IFHMBSAPEAICDPP0038Payload.Request request)throws Exception{

        IFHMBSAPEAICDPP0038Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0038Dto.class);
        
        IFHMBSAPEAICDPP0038Dto resultDto = new IFHMBSAPEAICDPP0038Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBSAPEAICDPP0038Payload.Response.class);
    }
}
