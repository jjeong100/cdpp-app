package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0005Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0005Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPCDPP0005Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Account Webservice WF", description = "SAP, EAI Create/Update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPCDPP0005Controller {

    private static final String IF_ID = "IF007";

    @Autowired
    private final IFHMBSAPCDPP0005Service service;

    private final ModelMapper defaultMapper;
    
    @Operation(summary = "Account upsert", description = "Account upsert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPCDPP0005Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAccountWebserviceWF")
    public Object upsertObject(@RequestBody IFHMBSAPCDPP0005Payload.Request request)throws Exception{

        IFHMBSAPCDPP0005Dto dto = defaultMapper.map(request, IFHMBSAPCDPP0005Dto.class);

        IFHMBSAPCDPP0005Dto resultDto = service.insertObject(dto);

        return ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBSAPCDPP0005Payload.Response.class) : null;
    }
}
