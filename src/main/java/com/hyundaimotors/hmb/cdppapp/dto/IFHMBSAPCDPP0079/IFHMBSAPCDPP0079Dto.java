package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0079;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IFHMBSAPCDPP0079Dto {
    private String soid;
    private String dealercode;
    private String vincode;
    private float mileage;
    private String cpf;
    private String opendt;
    private String closedt;
    private int status;
    private float totalValue;
    /*private String soid;
    private String dealercode;
    private String vincode;
    private float mileage;
    private String model;
    private int zyear;
    private String plate;
    private int status;
    private String quicksrv;
    private String consultCpf;
    private String consultName;
    private String opendt;
    private String closedt;
    private String canceldt;
    private String deliverydt;
    private String schedulingdt;
    private String comments;
    private String filesentdt;
    private float totalWorkedHours;
    private float totalSoldHours;
    private float totalValue;
    private String partner;
    private String firstname;
    private String lastname;
    private String cpf;
    private String city;
    private String postlCod1;
    private String street;
    private String houseNo;
    private String country;
    private String region;
    private String taxjurcode;
    private String email;
    private String telNumber;
    private String mobNumber;
    private String blockcontact;
    private String queried;
    private String ernam;
    private String erdat;
    private String erzet;
    private String aenam;
    private String aedat;
    private String aezet;*/
    List<InboundRepairServiceDto> listOfService;
    List<InboundRepairPartsDto> listOfParts;
    private int rowId;
    private String errorSpcCode;
    private String errorSpcMessage;
}
