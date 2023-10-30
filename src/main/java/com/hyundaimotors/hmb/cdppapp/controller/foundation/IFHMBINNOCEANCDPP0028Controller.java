package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0028Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0028Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0028Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Register Loyalty Benefit Used WS", description = "Innocean Benefit insert or update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0028Controller {

    private static final String IF_ID = "IF033";
    
    @Autowired
    private final IFHMBINNOCEANCDPP0028Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Benefit imfomation upsert", description = "Benefit imfomation upsert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0028Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBRegisterLoyaltyBenefitUsedWS")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0028Payload.Request request)throws Exception{
        IFHMBINNOCEANCDPP0028Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0028Dto.class);
        
        IFHMBINNOCEANCDPP0028Dto resultDto = service.upsertObject(dto);

        return ObjectUtils.isNotEmpty(resultDto) ? defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0028Payload.Response.class) : null;
    }


}
