package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0024Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0024.IFHMBINNOCEANCDPP0024Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0024Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Manage Employee Availability Excp", description = "This web service can be used to manage the maintenance service consultant availability exceptions. This web service can insert, update, or delete the consultant availability exceptions. The operation tag will be combined with the excp-id tag to define the operation executed, according to the table below:")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0024Controller {

    private static final String IF_ID = "IF027";
    
    private final IFHMBINNOCEANCDPP0024Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Manage Employee Availability Excp", description = "HMB MNTSRVC Manage Employee Availability Excp")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0024Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCManageEmployeeAvailabilityExcp")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0024Payload.Request request)throws Exception{
        
        IFHMBINNOCEANCDPP0024Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0024Dto.class);
        
        IFHMBINNOCEANCDPP0024Dto resultDto = new IFHMBINNOCEANCDPP0024Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0024Payload.Response.class);
    }
}
