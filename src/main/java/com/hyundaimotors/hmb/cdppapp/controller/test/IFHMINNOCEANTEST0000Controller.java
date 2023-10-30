package com.hyundaimotors.hmb.cdppapp.controller.test;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hyundaimotors.hmb.cdppapp.dto.IFHMINNOCEANTEST0000.IFHMINNOCEANTEST0000Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMINNOCEANTEST0000.IFHMINNOCEANTEST0000Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMINNOCEANTEST0000Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB test WS", description = "This web service can be used to retrieve from Connex retail sales data with their associated individuals and legal entities. Retail sales will have status Customer Owned. For all business purposes, only contacts/accounts with relationship status \"Active\" should be considered. ")
@RestController
@RequiredArgsConstructor
public class IFHMINNOCEANTEST0000Controller {

    private static final String IF_ID = "IF000";

    @Autowired
    private final IFHMINNOCEANTEST0000Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB test WS", description = "HMB test WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMINNOCEANTEST0000Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBTestWS")
    public Object getObject(@RequestBody IFHMINNOCEANTEST0000Payload.Request request) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        
        IFHMINNOCEANTEST0000Dto resultDto = new IFHMINNOCEANTEST0000Dto();

        System.out.println("■■■■■■■■■■■■■■■■■■■■■ Test !!.");

        // IFHMBINNOCEANCDPP0089Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0089Dto.class);
        IFHMINNOCEANTEST0000Dto dto = defaultMapper.map(request, IFHMINNOCEANTEST0000Dto.class);

        // resultDto = service.getObject(dto);
        //return 값 없음.
        service.insertObject(dto);

        return modelMapper.map(resultDto, IFHMINNOCEANTEST0000Payload.Response.class);
    }


}
