package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.IFHMBINNOCEANCDPP0033Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0033.IFHMBINNOCEANCDPP0033Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0033Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Get Vehicle WF", description = "This web service can be used to retrieve from Connex whole sales data and retail sales data with their associated individuals and legal entities. Whole sales will have status \"Dealer Owned\", while retail sales will have status \"Customer Owned\".")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0033Controller {

    private static final String IF_ID = "IF038";

    private final IFHMBINNOCEANCDPP0033Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get Vehicle WF", description = "HMB Get Vehicle WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0033Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetVehicleWF")
    public Object getObject(@RequestBody IFHMBINNOCEANCDPP0033Payload.Request request)throws Exception{
        
        String checkInterfaceVal = request.getIdInterface();

        if(Objects.isNull(request.getIdInterface()) && Objects.isNull(request.getSource())){
            throw new Exception("haven't IdInterface or Source");
        }else{
            if("1".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getSerialNumber()) || request.getSerialNumber().isEmpty()){
                    throw new Exception("haven't SerialNumber");    
                }
            }else if("2".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getLicenseNumber()) || request.getLicenseNumber().isEmpty()){
                    throw new Exception("haven't LicenseNumber");
                }
            }else if("3".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getRenavamCode()) || request.getRenavamCode().isEmpty()){
                    throw new Exception("haven't RenavamCode");
                }
            }else if("4".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getCpf()) || request.getCpf().isEmpty()){
                    throw new Exception("haven't Cpf");
                }
            }else if("5".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getCnpj()) || request.getCnpj().isEmpty()){
                    throw new Exception("haven't Cnpj");
                }
            }else if("6".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getStartDate()) || Objects.isNull(request.getEndDate()) || request.getStartDate().isEmpty()  || request.getEndDate().isEmpty()){
                    throw new Exception("haven't RenavamCode");
                }
            }else if("7".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getConnexid()) || request.getConnexid().isEmpty()){
                    throw new Exception("haven't Connexid");
                }
            }else if("8".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getEndDate()) || request.getEndDate().isEmpty()){
                    throw new Exception("haven't EndDate");
                }
            }else if("9".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getSerialNumber()) || request.getSerialNumber().isEmpty()){
                    throw new Exception("haven't SerialNumber");
                }
            }else if("10".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getStartDate()) || request.getStartDate().isEmpty()){
                    throw new Exception("haven't StartDate");
                }
            }else if("11".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getSerialNumber()) || request.getSerialNumber().isEmpty()){
                    throw new Exception("haven't SerialNumber");
                }
            }else if("12".equals(checkInterfaceVal)){
                if(Objects.isNull(request.getSerialNumber()) || request.getSerialNumber().isEmpty()){
                    throw new Exception("haven't SerialNumber");
                }
            }else{
                throw new Exception("haven't IdInterface");
            }
        }
            IFHMBINNOCEANCDPP0033Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0033Dto.class);
            IFHMBINNOCEANCDPP0033Dto resultDto = service.getObject(dto);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            
            return defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0033Payload.Response.class);
    }
}
