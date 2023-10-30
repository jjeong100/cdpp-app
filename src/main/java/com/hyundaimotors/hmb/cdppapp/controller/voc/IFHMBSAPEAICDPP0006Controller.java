package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0006Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.IFHMBSAPEAICDPP0006Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0006Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Action Inbound Webservice WF", description = "This web service can be used to  update Action information")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0006Controller {

    private static final String IF_ID = "IF008";
    
    private final IFHMBSAPEAICDPP0006Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Action Inbound Webservice WF", description = "HMB Action Inbound Webservice WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0006Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBActionInboundWebserviceWF")
    public Object insertObject(@RequestBody IFHMBSAPEAICDPP0006Payload.Request request)throws Exception{
        IFHMBSAPEAICDPP0006Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0006Dto.class);
        
        IFHMBSAPEAICDPP0006Dto resultDto = new IFHMBSAPEAICDPP0006Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBSAPEAICDPP0006Payload.Response.class);
    }
}
