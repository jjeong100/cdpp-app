package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0019Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0019Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0019Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Dealer Calendar", description = "This web service can be used to query availability of dealer's maintenance service schedule for a specific month.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0019Controller {

    private static final String IF_ID = "IF019";
    
    private final IFHMBINNOCEANCDPP0019Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Dealer Calendar", description = "HMB MNTSRVC Dealer Calendar ")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0019Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCDealerCalendar")
    public Object getList(@RequestBody IFHMBINNOCEANCDPP0019Payload.Request request)throws Exception{
        ModelMapper modelMapper = new ModelMapper();
    
        IFHMBINNOCEANCDPP0019Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0019Dto.class);

        List<IFHMBINNOCEANCDPP0019Dto> resultList = new ArrayList<>();

        resultList = service.getList(dto);
        
        return IFHMBINNOCEANCDPP0019Payload.Response.builder()
                .errorSpcCode("0")
                .errorSpcMessage("OK")
                .listOfDays(resultList.size() > 0 ? defaultMapper.map(resultList, new TypeToken<List<IFHMBINNOCEANCDPP0019Payload.ListOfDays>>() {}.getType()) : null)
                .build();
    }
}
