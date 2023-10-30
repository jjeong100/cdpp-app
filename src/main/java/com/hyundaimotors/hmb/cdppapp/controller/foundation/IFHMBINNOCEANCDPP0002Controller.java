package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.ApiLogDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0002.IFHMBINNOCEANCDPP0002Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0002Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0002Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Inbound Contact Interface Workflow", description = "INNOCEAN, SAP EAI insert Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0002Controller {

    private static final String IF_ID = "IF003";

    private final ApiLogService logService;

    private final IFHMBINNOCEANCDPP0002Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "Person Account Insert", description = "Person Account Insert.")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0002Payload.Request.class)))
    @PostMapping(value = "/api/v1/HMBInboundContactInterfaceWorkflow")
    public Object insertInboundContactWorkflow(@RequestBody IFHMBINNOCEANCDPP0002Payload.Request request)
            throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();

        this.logApi(ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));

        IFHMBINNOCEANCDPP0002Payload.Response response = new IFHMBINNOCEANCDPP0002Payload.Response();
        try {
            IFHMBINNOCEANCDPP0002Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0002Dto.class);

            this.logApi(ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBINNOCEANCDPP0002Dto resultDto = service.insertObject(dto);
            this.logApi(ApiLogStep.STEP2, IF_TR_ID, null);

            response = defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0002Payload.Response.class);
            this.logApi(ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        } catch (Exception e) {
            response.setError_spcCode("500");
            response.setError_spcMessage(e.getLocalizedMessage());
            this.logApi(ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }

        return response;
    }

    private void logApi(ApiLogStep step, UUID ifTrUuid, String strJson) {
        logApi(step, ifTrUuid, strJson, null);
    }

    private void logApi(ApiLogStep step, UUID ifTrUuid, String strJson, Throwable e) {
        ApiLogDto dto = new ApiLogDto();
        dto.setIfId(IF_ID);
        dto.setIfTrId(ifTrUuid.toString());

        Timestamp now = new Timestamp((new Date()).getTime());
        switch (step) {
            case START:
                dto.setIfRequestAt(now);
                dto.setIfReqJson(strJson);
                break;
            case STEP1:
                dto.setIfStep1At(now);
                break;
            case STEP2:
                dto.setIfStep2At(now);
                break;
            case STEP3:
                dto.setIfStep3At(now);
                break;
            case FINISH:
                dto.setIfResponseAt(new Timestamp((new Date()).getTime()));
                dto.setIfResJson(strJson);
                if (e != null) {
                    dto.setIfErrFlag("Y");
                    dto.setIfErrMsg(ExceptionUtils.getStackTrace(e));
                }
                break;

            default:
                break;
        }
        logService.writeStepLogging(step, dto);
    }
}
