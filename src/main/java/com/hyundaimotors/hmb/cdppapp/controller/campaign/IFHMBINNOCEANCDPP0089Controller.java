package com.hyundaimotors.hmb.cdppapp.controller.campaign;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0089.IFHMBINNOCEANCDPP0089Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0089.IFHMBINNOCEANCDPP0089Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0089Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Satisfaction Survey WS", description = "This web service can be used to retrieve from Connex retail sales data with their associated individuals and legal entities. Retail sales will have status Customer Owned. For all business purposes, only contacts/accounts with relationship status \"Active\" should be considered. ")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0089Controller {

    private static final String IF_ID = "IF089";
    
    @Autowired
    private final IFHMBINNOCEANCDPP0089Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Satisfaction Survey WS", description = "HMB Satisfaction Survey WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0089Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBSatisfactionSurveyWS")
    public Object getObject(@RequestBody IFHMBINNOCEANCDPP0089Payload.Request request)throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        
        IFHMBINNOCEANCDPP0089Dto resultDto = new IFHMBINNOCEANCDPP0089Dto();

        IFHMBINNOCEANCDPP0089Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0089Dto.class);

        resultDto = service.getObject(dto);

        return modelMapper.map(resultDto, IFHMBINNOCEANCDPP0089Payload.Response.class);
    }
}
