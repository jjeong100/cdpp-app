package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0026.IFHMBSAPEAICDPP0026Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0026.IFHMBSAPEAICDPP0026Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0026Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Product List Inbound WF", description = "SAP EAI Product Create/Update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0026Controller {

    private static final String IF_ID = "IF031";
    
    @Autowired
    private final IFHMBSAPEAICDPP0026Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "UpsertProductList", description = "UpsertProductList")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0026Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBProductListInboundWF")
    public Object insertObject(@RequestBody IFHMBSAPEAICDPP0026Payload.Request request)throws Exception{
       
        IFHMBSAPEAICDPP0026Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0026Dto.class);

        IFHMBSAPEAICDPP0026Dto result = service.insertObject(dto);

        return defaultMapper.map(result, IFHMBSAPEAICDPP0026Payload.Response.class);
    }    
}
