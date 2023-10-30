package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBZICARDCDPP0007Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0007Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBZICARDCDPP0007Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Asset Contact Upsert Webservice WS", description = "INNOCEAN, EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBZICARDCDPP0007Controller {

    private static final String IF_ID = "IF009";

     @Autowired
    private final IFHMBZICARDCDPP0007Service service;
    
    @Operation(summary = "assetContact upsert", description = "assetContact upsert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBZICARDCDPP0007Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAssetContactUpsertWS")
    public Object getObject(@RequestBody IFHMBZICARDCDPP0007Payload.Request request)throws Exception{

        ModelMapper modelMapper = new ModelMapper();
        IFHMBZICARDCDPP0007Dto dto = modelMapper.map(request, IFHMBZICARDCDPP0007Dto.class);
        
        IFHMBZICARDCDPP0007Dto resultDto = service.upsertObject(dto);

        return modelMapper.map(resultDto, IFHMBZICARDCDPP0007Payload.Response.class);       
    }
    
}
