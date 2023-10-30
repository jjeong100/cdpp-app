package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0085.IFHMBCSUCDPP0085Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0085.IFHMBCSUCDPP0085Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0085Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Closest Dealer WS", description = "This web service will be created to be used to search Closest Dealer (individuals) by CEP  and return channet /Contact information.")
@RestController
@RequiredArgsConstructor
public class IFHMBCSUCDPP0085Controller {

    private static final String IF_ID = "IF085";

    private final IFHMBCSUCDPP0085Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Closest Dealer WS", description = "HMB Closest Dealer WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBCSUCDPP0085Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBClosestDealerWS")
    public Object insertObject(@RequestBody IFHMBCSUCDPP0085Payload.Request request)throws Exception{
        IFHMBCSUCDPP0085Dto dto = defaultMapper.map(request, IFHMBCSUCDPP0085Dto.class);
        
        IFHMBCSUCDPP0085Dto resultDto = new IFHMBCSUCDPP0085Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBCSUCDPP0085Payload.Response.class);
    }
}
