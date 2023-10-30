package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBMAPFRECDPP0009.IFHMBMAPFRECDPP0009Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBMAPFRECDPP0009Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Auto Vehicle RSA Claim WS", description = "This web service can be used to insert or update Auto Vehicle Information")
@RestController
@RequiredArgsConstructor
public class IFHMBMAPFRECDPP0009Controller {

    private static final String IF_ID = "IF010";
    @Autowired
    private final IFHMBMAPFRECDPP0009Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Auto Vehicle RSA Claim WS", description = "HMB Auto Vehicle RSA Claim WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBMAPFRECDPP0009Payload.Request.class)))
    @PostMapping(value = "/api/v1/HMBAutoVehicleRSAClaimWS")
    public Object upsertObject(@RequestBody IFHMBMAPFRECDPP0009Payload.Request request)throws Exception{
         IFHMBMAPFRECDPP0009Dto dto = defaultMapper.map(request, IFHMBMAPFRECDPP0009Dto.class);

         IFHMBMAPFRECDPP0009Dto resultDto = service.upsertObject(dto);

         return ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBMAPFRECDPP0009Payload.Response.class) : null;
         
    }
}
