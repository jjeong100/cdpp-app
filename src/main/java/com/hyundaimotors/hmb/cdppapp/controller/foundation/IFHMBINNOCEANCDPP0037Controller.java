package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.IFHMBINNOCEANCDPP0037Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0037Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Update Contact IN WF", description = "Innocean, SAP EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0037Controller {

    private static final String IF_ID = "IF046";
    
    @Autowired
    private final IFHMBINNOCEANCDPP0037Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Person Account Update", description = "Person Account Update")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0037Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBUpdateContactINWF")
    public Object updateObject(@RequestBody IFHMBINNOCEANCDPP0037Payload.Request request)throws Exception{

        IFHMBINNOCEANCDPP0037Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0037Dto.class);

        HashMap<String, Object> result = service.updateObject(dto);
        
        return defaultMapper.map(result, IFHMBINNOCEANCDPP0037Payload.Response.class);
    }

}
