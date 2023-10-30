package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0086Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0086Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0086Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Search IVR Contact", description = "This web service will be created to be used to search IVR Contact ) by phone number and return contact / protocol information.")
@RestController
@RequiredArgsConstructor
public class IFHMBCSUCDPP0086Controller {

    private static final String IF_ID = "IF086";

    private final IFHMBCSUCDPP0086Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Search IVR Contact", description = "HMB Search IVR Contact")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBCSUCDPP0086Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBSearchIVRContact")
    public Object insertObject(@RequestBody IFHMBCSUCDPP0086Payload.Request request)throws Exception{
        IFHMBCSUCDPP0086Dto dto = defaultMapper.map(request, IFHMBCSUCDPP0086Dto.class);
        
        IFHMBCSUCDPP0086Dto resultDto = new IFHMBCSUCDPP0086Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBCSUCDPP0086Payload.Response.class);
    }
}
