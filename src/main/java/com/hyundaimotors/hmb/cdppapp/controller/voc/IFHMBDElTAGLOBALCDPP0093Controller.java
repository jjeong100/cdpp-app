package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDElTAGLOBALCDPP0093.IFHMBDElTAGLOBALCDPP0093Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDElTAGLOBALCDPP0093.IFHMBDElTAGLOBALCDPP0093Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDElTAGLOBALCDPP0093Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Delta Global - Inbound Rental Car Request Results", description = "Delta Global - Inbound Rental Car Request Results")
@RestController
@RequiredArgsConstructor
public class IFHMBDElTAGLOBALCDPP0093Controller {
    
    private final IFHMBDElTAGLOBALCDPP0093Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Delta Global - Inbound Rental Car Request Results", description = "Delta Global - Inbound Rental Car Request Results")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBDElTAGLOBALCDPP0093Payload.Response.class)))
    @PostMapping(value = "/api/v1/InboundRentalCarRequestResults")
    public Object insertObject(@RequestBody IFHMBDElTAGLOBALCDPP0093Payload.Request request)throws Exception{
        IFHMBDElTAGLOBALCDPP0093Dto dto = defaultMapper.map(request, IFHMBDElTAGLOBALCDPP0093Dto.class);
        
        IFHMBDElTAGLOBALCDPP0093Dto resultDto = new IFHMBDElTAGLOBALCDPP0093Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBDElTAGLOBALCDPP0093Payload.Response.class);
    }
}
