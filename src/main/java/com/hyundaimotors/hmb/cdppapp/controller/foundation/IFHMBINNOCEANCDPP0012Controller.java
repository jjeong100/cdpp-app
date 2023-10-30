package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0012.IFHMBINNOCEANCDPP0012Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012.IFHMBINNOCEANCDPP0012Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0012Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Channel Partner Get Webservice Inbound WF", description = "This web service will be created to be used to search Channel Partner  (individuals) by source and return channet /Contact information.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0012Controller {

    private static final String IF_ID = "IF013";

    @Autowired
    private final IFHMBINNOCEANCDPP0012Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Channel Partner Get Webservice Inbound WF", description = "HMB Channel Partner Get Webservice Inbound WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0012Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBChannelPartnerGetWebserviceInboundWF")
    public Object getObject(@RequestBody IFHMBINNOCEANCDPP0012Payload.Request request)throws Exception{
        IFHMBINNOCEANCDPP0012Dto resultDto = new IFHMBINNOCEANCDPP0012Dto();

        IFHMBINNOCEANCDPP0012Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0012Dto.class);
        
        resultDto = service.getObject(dto);

        return defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0012Payload.Response.class);
    }
}
