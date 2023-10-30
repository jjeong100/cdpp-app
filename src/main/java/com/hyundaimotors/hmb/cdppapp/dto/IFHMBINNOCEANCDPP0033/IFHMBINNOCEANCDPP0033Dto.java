package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBINNOCEANCDPP0033Dto {
    private String idInterface;
    private String source;
    private String serialNumber;
    private String licenseNumber;
    private String renavamCode;
    private String cpf;
    private String cnpj;
    private String startDate;
    private String endDate;
    private String connexid;
    private String dealerCode;
    private String contactInputId;
    private String accountInputId;
    private String assetInputId;
    private String ErrorSpcCode;
    private String ErrorSpcMessage;
    List<HMBVehicleDto> listOfHMBVehicle;
}
