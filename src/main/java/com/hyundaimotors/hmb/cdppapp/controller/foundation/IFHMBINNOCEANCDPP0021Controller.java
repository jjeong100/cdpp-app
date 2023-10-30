package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0021Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0021.IFHMBINNOCEANCDPP0021Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0021Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Maintenance Service", description = "This web service can be used to query availability of maintenance services in the dealers.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0021Controller {

    private static final String IF_ID = "IF022";

    @Autowired
    private final IFHMBINNOCEANCDPP0021Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Maintenance Service", description = "This web service can be used to query availability of maintenance services in the dealers.")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0021Payload.Response.class)))
    @PostMapping(value = "/api/v1/getHMBMNTSRVCMaintenanceService")
    public Object getList(@RequestBody IFHMBINNOCEANCDPP0021Payload.Request request)throws Exception{
        IFHMBINNOCEANCDPP0021Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0021Dto.class);

        IFHMBINNOCEANCDPP0021Dto resultdto = service.getObject(dto);
        dto.setErrorSpcCode("0");
        dto.setErrorSpcMessage("OK");

        return defaultMapper.map(resultdto, IFHMBINNOCEANCDPP0021Payload.Response.class);
    }
}
