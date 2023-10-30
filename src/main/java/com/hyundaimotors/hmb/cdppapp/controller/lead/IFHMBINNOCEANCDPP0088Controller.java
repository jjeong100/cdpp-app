package com.hyundaimotors.hmb.cdppapp.controller.lead;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0088.IFHMBINNOCEANCDPP0088Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0088.IFHMBINNOCEANCDPP0088Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0088Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Amaro CSI Survey WS", description = "This web service can be used to send survey data to Connex.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0088Controller {

    private static final String IF_ID = "IF088";

    private final IFHMBINNOCEANCDPP0088Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Amaro CSI Survey WS", description = "HMB Amaro CSI Survey WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0088Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBAmaroCSISurveyWS")
    public Object updateObject(@RequestBody IFHMBINNOCEANCDPP0088Payload.Request request)throws Exception{

        IFHMBINNOCEANCDPP0088Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0088Dto.class);
        
        IFHMBINNOCEANCDPP0088Dto resultDto = new IFHMBINNOCEANCDPP0088Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0088Payload.Response.class);
    }
}
