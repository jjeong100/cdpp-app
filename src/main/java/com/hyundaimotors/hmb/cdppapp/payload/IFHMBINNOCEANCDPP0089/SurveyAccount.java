package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0089;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyAccount {
    @Schema(description = "Connex account id.", example = "1-TYU56")
    @JsonProperty("Id")
    private String id;
    @Schema(description = "Connex account integration id.", example = "B05AM99999")
    @JsonProperty("IntegrationId")
    private String integrationId;
    @Schema(description = "Company name", example = "Motonet Comercio de Veiculos M")
    @JsonProperty("Name")
    private String name;
    @Schema(description = "Company nickname", example = "Abrão Reze - Sorocaba")
    @JsonProperty("Nickname")
    private String nickname;
    @Schema(description = "Legal entity CNPJ number.", example = "78753880000164")
    private String document;
    @Schema(description = "It will return PJ, meaning a legal entity.", example = "PJ")
    private String personType;
    @Schema(description = "Address zip code.", example = "4007001")
    @JsonProperty("ZipCode")
    private String zipCode;
    @Schema(description = "Address street name.", example = "Rua Tutoia")
    @JsonProperty("StreetAddress")
    private String streetAddress;
    @Schema(description = "Address house number", example = "380")
    @JsonProperty("StreetAddress2")
    private String streetAddress2;
    @Schema(description = "Address complement.", example = "Andar 3")
    @JsonProperty("StreetAddress3")
    private String streetAddress3;
    @Schema(description = "Address city.", example = "Brasil")
    @JsonProperty("City")
    private String city;
    @Schema(description = "Address state.", example = "São Paulo ")
    @JsonProperty("State")
    private String state;
    @Schema(description = "Main phone.", example = "2345678")
    @JsonProperty("MainPhone")
    private String mainPhone;
    @Schema(description = "Main Fax phone.", example = "3456789")
    @JsonProperty("Fax")
    private String fax;
    @Schema(description = "Company email address.", example = "kilosolution2s@gmail.com")
    private String mainEmailAddress;
}
