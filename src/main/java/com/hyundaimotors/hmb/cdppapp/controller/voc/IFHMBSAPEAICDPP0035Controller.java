package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0035Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0035Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0035Service;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Service Request Attachment", description = "This web service can be used to insert attachment  into Connex system.")
@RestController
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0035Controller {

    private static final String IF_ID = "IF044";

    private final IFHMBSAPEAICDPP0035Service service;
    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Service Request Attachment", description = "HMB Service Request Attachment")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSAPEAICDPP0035Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBServiceRequestAttachment")
    public Object upserObject(@RequestBody IFHMBSAPEAICDPP0035Payload.Request request)throws Exception{
        IFHMBSAPEAICDPP0035Dto dto = defaultMapper.map(request, IFHMBSAPEAICDPP0035Dto.class);
        IFHMBSAPEAICDPP0035Dto resultDto = new IFHMBSAPEAICDPP0035Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBSAPEAICDPP0035Payload.Response.class);
    }
    
}
