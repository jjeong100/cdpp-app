package com.hyundaimotors.hmb.cdppapp.payload.IFHMBMAPFRECDPP0009;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "IFHMBMAPFRECDPP0009RSAServicePayload")
@Getter
@Setter
public class IFHMBMAPFRECDPP0009RSAServicePayload {
    
    @Schema(description = "Integration Id", example = "Conveni 00EAncia-Rede el 00E1stica para porta-malas")
    @JsonProperty("ServiceId")
    private String serviceId;
    @Schema(description = "Service Date", example = "2015-08-09")
    @JsonProperty("CreateDate")
    private String createDate;
    @Schema(description = "Service Code", example = "R40 - CONSERTO MEC 00C2NICO NO LOCAL")
    @JsonProperty("ServiceCode")
    private String serviceCode;
    @Schema(description = "Specialty Code", example = "R40M - PADR00C3O")
    @JsonProperty("Specialty")
    private String specialty;
    @Schema(description = "Service Provider Name", example = "R$229.2600")
    @JsonProperty("Provider")
    private String provider;
    @Schema(description = "Vehicle Issue Code", example = "Apagou. C00F3d 0")
    @JsonProperty("VehicleProblem")
    private String vehicleProblem;
    @Schema(description = "Problem Description", example = "VCL N00C3O LIGA")
    @JsonProperty("ProblemDescription")
    private String problemDescription;
    @Schema(description = "Expected Arrival", example = "1230000")
    @JsonProperty("TMCPredicted")
    private int tmcPredicted;
    @Schema(description = "Important Description", example = "VCL EM GARANTIA // SOMENTE RECARGA DE BATERIA // VCL NO 2\u00BA SUBSOLO // AGILIDADE CLT ATRASADO")
    @JsonProperty("Important")
    private String important;
    @Schema(description = "Request Status", example = "1")
    @JsonProperty("RequestStatus")
    private String requestStatus;
    @Schema(description = "Actuation Status", example = "Enviando limusine")
    @JsonProperty("ActuationStatus")
    private String actuationStatus;
    @Schema(description = "Address street name.", example = "Rua Tutoia")
    @JsonProperty("AddressName")
    private String addressName;
    @Schema(description = "Address house number", example = "380")
    @JsonProperty("AddressNumber")
    private String addressNumber;
    @Schema(description = "Address complement.", example = "Andar 3")
    @JsonProperty("AddressComplement")
    private String addressComplement;
    @Schema(description = "Address county.", example = "Paraiso")
    @JsonProperty("County")
    private String county;
    @Schema(description = "Address city.", example = "Brasil")
    @JsonProperty("City")
    private String city;
    @Schema(description = "Address state.", example = "S00E3o Paulo ")
    @JsonProperty("State")
    private String state;
    @Schema(description = "Address latitude", example = "1230000")
    @JsonProperty("Latitude")
    private int latitude;
    @Schema(description = "Address longitude", example = "1230000")
    @JsonProperty("Longitude")
    private int longitude;
    @Schema(description = "Address reference", example = "G2 // PROX AO MERCADO PRINCESA // PROX A RENAULT")
    @JsonProperty("Reference")
    private String reference;
    @Schema(description = "Address zip code.", example = "4007001")
    @JsonProperty("ZipCode")
    private String zipCode;
    @Schema(description = "Dealer Name", example = "CAOA S/A")
    private String dealerName;
    @Schema(description = "Dealer Nickname", example = "Rua P00E2ntano da Ignom00EDnia")
    private String dealerNickname;
    @Schema(description = "Expense", example = "R$229.2600")
    @JsonProperty("Expense")
    private String expense;
}
