package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBBLUELINKCDPP0053.IFHMBBLUELINKCDPP0053Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053.IFHMBBLUELINKCDPP0053Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBBLUELINKCDPP0053Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Auto Vehicle Bluelink WS", description = "This web service can be used to insert Bluelink data.")
@RestController
@RequiredArgsConstructor
public class IFHMBBLUELINKCDPP0053Controller {

    private static final String IF_ID = "IF063";
    
    private final IFHMBBLUELINKCDPP0053Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Auto Vehicle Bluelink WS", description = "HMB Auto Vehicle Bluelink WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBBLUELINKCDPP0053Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAutoVehicleBluelinkWS")
    public Object getList(@RequestBody IFHMBBLUELINKCDPP0053Payload.Request request)throws Exception{
    
        IFHMBBLUELINKCDPP0053Dto dto = defaultMapper.map(request, IFHMBBLUELINKCDPP0053Dto.class);

        IFHMBBLUELINKCDPP0053Dto resultDto = service.insertList(dto);

        return defaultMapper.map(resultDto, IFHMBBLUELINKCDPP0053Payload.Response.class);
    }
}
