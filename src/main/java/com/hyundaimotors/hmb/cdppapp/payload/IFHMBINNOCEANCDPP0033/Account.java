package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0033;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Account")
@Getter
@Setter
public class Account {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("IntegrationId")
    private String integrationId;
    @JsonProperty("CNPJ")
    private String cnpj;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Nickname")
    private String nickname;
    private String personType;
    @JsonProperty("ZipCode")
    private String zipCode;
    @JsonProperty("StreetAddress")
    private String streetAddress;
    @JsonProperty("StreetAddress2")
    private String streetAddress2;
    @JsonProperty("StreetAddress3")
    private String streetAddress3;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Neighborhood")
    private String neighborhood;
    @JsonProperty("MainPhone")
    private String mainPhone;
    @JsonProperty("Fax")
    private String fax;
    private String mainEmailAddress;
    private String relationshipType;
    private String relationshipStatus;
}
