package com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0032;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ServiceRequestTD")
@Getter
@Setter
public class ServiceRequestTD {
    @JsonProperty("Searchspec")
    private String searchspec;
    @JsonProperty("CodigoSAPTD")
    private String codigoSAPTD;
    @JsonProperty("Protocol")
    private String protocol;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Dealer")
    private String dealer;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("SalesRepFirstName")
    private String salesRepFirstName;
    @JsonProperty("SalesRepLastName")
    private String salesRepLastName;
    @JsonProperty("TestDriveDate")
    private String testDriveDate;
    @JsonProperty("TestDriveTime")
    private String testDriveTime;
    @JsonProperty("TestDriveConfirmed")
    private String testDriveConfirmed;
    @JsonProperty("Area")
    private String area;
}
