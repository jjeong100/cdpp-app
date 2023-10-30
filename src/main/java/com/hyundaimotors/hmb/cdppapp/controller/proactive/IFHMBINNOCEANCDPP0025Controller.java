package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025.IFHMBINNOCEANCDPP0025Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0025.IFHMBINNOCEANCDPP0025Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0025Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Schedule Maintenance", description = "This web service can be used to insert or update maintenance services.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0025Controller {

    private static final String IF_ID = "IF029";
    
    private final IFHMBINNOCEANCDPP0025Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Schedule Maintenance", description = "HMB MNTSRVC Schedule Maintenance")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0025Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCScheduleMaintenance")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0025Payload.Request request)throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        IFHMBINNOCEANCDPP0025Dto resultDto = new IFHMBINNOCEANCDPP0025Dto();
        IFHMBINNOCEANCDPP0025Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0025Dto.class);

        resultDto = service.upsertObject(dto);

        modelMapper.createTypeMap(IFHMBINNOCEANCDPP0025Dto.class, IFHMBINNOCEANCDPP0025Payload.Response.class).addMapping(IFHMBINNOCEANCDPP0025Dto::getDtoSrnumber, IFHMBINNOCEANCDPP0025Payload.Response::setSrNumber);

        return modelMapper.map(resultDto, IFHMBINNOCEANCDPP0025Payload.Response.class);
    }
}
