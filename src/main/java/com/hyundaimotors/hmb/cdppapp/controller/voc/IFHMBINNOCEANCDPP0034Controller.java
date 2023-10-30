package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0034Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0034.IFHMBINNOCEANCDPP0034Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0034Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Service Request Webservice WF", description = "This web service can be used to insert occurrences into Connex system. Connex uses the upsert method in this web service, which means it will determine if an existing record should be updated or a new record should be inserted based on the information provided.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0034Controller {

    private static final String IF_ID = "IF040";
    
    private final IFHMBINNOCEANCDPP0034Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Service Request Webservice WF", description = "HMB Service Request Webservice WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0034Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBServiceRequestWebserviceWF")
    public Object insertObject(@RequestBody IFHMBINNOCEANCDPP0034Payload.Request request)throws Exception{
        
        IFHMBINNOCEANCDPP0034Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0034Dto.class);
        
        IFHMBINNOCEANCDPP0034Dto resultDto = new IFHMBINNOCEANCDPP0034Dto();

        resultDto = service.insertObject(dto);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(IFHMBINNOCEANCDPP0034Dto.class, IFHMBINNOCEANCDPP0034Payload.Response.class)
                                .addMapping(IFHMBINNOCEANCDPP0034Dto::getProtocalResult, IFHMBINNOCEANCDPP0034Payload.Response::setProtocol);

        return modelMapper.map(resultDto, IFHMBINNOCEANCDPP0034Payload.Response.class);
    }
}
