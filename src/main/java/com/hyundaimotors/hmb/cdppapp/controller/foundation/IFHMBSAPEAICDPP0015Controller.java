package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0015Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015.IFHMBSAPEAICDPP0015Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0015Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Inbound Color", description = "This web service can be used to insert or Update  List Of Val  Color into Connex.")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0015Controller {

    private static final String IF_ID = "IF015";
    
    private final IFHMBSAPEAICDPP0015Service service;
    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Inbound Color", description = "HMB Inbound Color")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0015Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBInboundColor")
    public Object upserObject(@RequestBody IFHMBSAPEAICDPP0015Payload.Request request)throws Exception{
        IFHMBSAPEAICDPP0015Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0015Dto.class);
        IFHMBSAPEAICDPP0015Dto resultDto = new IFHMBSAPEAICDPP0015Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBSAPEAICDPP0015Payload.Response.class);
    }
}
