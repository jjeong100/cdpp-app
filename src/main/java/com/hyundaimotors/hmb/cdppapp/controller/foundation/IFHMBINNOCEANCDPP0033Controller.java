package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.IFHMBINNOCEANCDPP0033Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0033.IFHMBINNOCEANCDPP0033Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0033Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLog;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Get Vehicle WF", description = "This web service can be used to retrieve from Connex whole sales data and retail sales data with their associated individuals and legal entities. Whole sales will have status \"Dealer Owned\", while retail sales will have status \"Customer Owned\".")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0033Controller {

    private static final String IF_ID = "IF038";
    
    private final ApiLogService logService;

    private final IFHMBINNOCEANCDPP0033Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get Vehicle WF", description = "HMB Get Vehicle WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0033Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetVehicleWF")
    public Object getObject(@Valid @RequestBody IFHMBINNOCEANCDPP0033Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBINNOCEANCDPP0033Payload.Response response = new IFHMBINNOCEANCDPP0033Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
        
        String checkInterfaceVal = request.getIdInterface();

        if(Objects.isNull(request.getIdInterface()) && Objects.isNull(request.getSource())){
        	throw new IOException("haven't IdInterface or Source");
        }else{
            if("1".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getSerialNumber()) || request.getSerialNumber().isEmpty()){
                    throw new IOException("haven't SerialNumber");    
                }
            }else if("2".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getLicenseNumber()) || request.getLicenseNumber().isEmpty()){
                	throw new IOException("haven't LicenseNumber");
                }
            }else if("3".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getRenavamCode()) || request.getRenavamCode().isEmpty()){
                	throw new IOException("haven't RenavamCode");
                }
            }else if("4".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getCpf()) || request.getCpf().isEmpty()){
                	throw new IOException("haven't Cpf");
                }
            }else if("5".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getCnpj()) || request.getCnpj().isEmpty()){
                	throw new IOException("haven't Cnpj");
                }
            }else if("6".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getStartDate()) || Objects.isNull(request.getEndDate()) || request.getStartDate().isEmpty()  || request.getEndDate().isEmpty()){
                	throw new IOException("haven't RenavamCode");
                }
            }else if("7".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getConnexid()) || request.getConnexid().isEmpty()){
                	throw new IOException("haven't Connexid");
                }
            }else if("8".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getEndDate()) || request.getEndDate().isEmpty()){
                	throw new IOException("haven't EndDate");
                }
            }else if("9".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getStartDate()) || Objects.isNull(request.getEndDate()) || request.getStartDate().isEmpty()  || request.getEndDate().isEmpty()){
                	throw new IOException("haven't RenavamCode");
                }
            }else if("10".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getStartDate()) || request.getStartDate().isEmpty()){
                	throw new IOException("haven't StartDate");
                }
            }else if("11".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getSerialNumber()) || request.getSerialNumber().isEmpty()){
                	throw new IOException("haven't SerialNumber");
                }
            }else if("12".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getDealerCode()) || request.getDealerCode().isEmpty() || Objects.isNull(request.getStartDate()) || request.getStartDate().isEmpty() || Objects.isNull(request.getEndDate()) || request.getEndDate().isEmpty()){
                	throw new IOException("haven't DealerCode");
                }
            }else{
            	throw new IOException("haven't IdInterface");
            }
        }
        
        try {
            IFHMBINNOCEANCDPP0033Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0033Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            IFHMBINNOCEANCDPP0033Dto resultDto = service.getObject(dto);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
            
            response = defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0033Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());

            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
