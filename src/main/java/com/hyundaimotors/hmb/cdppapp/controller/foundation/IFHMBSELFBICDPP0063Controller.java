package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.IFHMBSELFBICDPP0063Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0063.IFHMBSELFBICDPP0063Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSELFBICDPP0063Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Get VIN Sales WF", description = "Interface Requirement for Get VIN Sales WF I/F Requirement")
@RestController
@RequiredArgsConstructor
public class IFHMBSELFBICDPP0063Controller {

    private static final String IF_ID = "IF084";
    
    private final IFHMBSELFBICDPP0063Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get VIN Sales WF", description = "HMB Get VIN Sales WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSELFBICDPP0063Payload.Request.class)))
    @PostMapping(value = "/api/v1/HMBGetVINSalesWF")
    public Object getObject(@RequestBody IFHMBSELFBICDPP0063Payload.Request request)throws Exception{
        IFHMBSELFBICDPP0063Dto dto = defaultMapper.map(request, IFHMBSELFBICDPP0063Dto.class);
            IFHMBSELFBICDPP0063Dto resultDto = service.getObject(dto);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            
            return defaultMapper.map(resultDto, IFHMBSELFBICDPP0063Payload.Response.class);
    }
}
