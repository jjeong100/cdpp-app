package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0087.IFHMBCSUCDPP0087Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087.IFHMBCSUCDPP0087Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0087Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMBSearchContactWF", description = "This web service will be created to be used to search Contact  by Contact id, Serial number, Campaimg Name  and return  Vehicle, Campaing nformation and Contacts.")
@RestController
@RequiredArgsConstructor
public class IFHMBCSUCDPP0087Controller {

    private static final String IF_ID = "IF087";

    private final IFHMBCSUCDPP0087Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMBSearchContactWF", description = "HMBSearchContactWF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBCSUCDPP0087Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBSearchContactWF")
    public Object insertObject(@RequestBody IFHMBCSUCDPP0087Payload.Request request)throws Exception{
        IFHMBCSUCDPP0087Dto dto = defaultMapper.map(request, IFHMBCSUCDPP0087Dto.class);
        
        IFHMBCSUCDPP0087Dto resultDto = new IFHMBCSUCDPP0087Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBCSUCDPP0087Payload.Response.class);
    }
}
