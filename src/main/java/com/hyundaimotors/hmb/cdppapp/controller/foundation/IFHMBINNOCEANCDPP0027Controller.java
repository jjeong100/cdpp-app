package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0027Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0027Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0027Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Register In Application WS", description = "Innocean insert or update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0027Controller {

    private static final String IF_ID = "IF032";
    
    @Autowired
    private final IFHMBINNOCEANCDPP0027Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "registers insert", description = "registers insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0027Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBRegisterInApplicationWS")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0027Payload.Request request)throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        IFHMBINNOCEANCDPP0027Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0027Dto.class);

        
        IFHMBINNOCEANCDPP0027Dto resultDto = service.upsertObject(dto);

        return modelMapper.map(resultDto, IFHMBINNOCEANCDPP0027Payload.Response.class);
        
    }

}
