package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0063;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Vehicle")
@Getter
@Setter
public class Vehicle {
    @JsonProperty("Chassi")
    private String chassi;
    @JsonProperty("SalesDate")
    private String salesDate;
    @JsonProperty("SalesDealerCode")
    private String salesDealerCode;
    @JsonProperty("SalesDealerNick")
    private String salesDealerNick;
    @JsonProperty("SalesCode")
    private String salesCode;
    @JsonProperty("SalesVersion")
    private String salesVersion;
    @JsonProperty("SalesFSCOCN")
    private String salesFSCOCN;
    @JsonProperty("SalesMotor")
    private String salesMotor;
    @JsonProperty("VINModel")
    private String vinModel;
    @JsonProperty("VINColor")
    private String vinColor;
    @JsonProperty("Updated")
    private String updated;
    @JsonProperty("DelHome")
    private String delHome;
    @JsonProperty("DigitalSales")
    private String digitalSales;
    @JsonProperty("TDHome")
    private String tdHome;
    @JsonProperty("SalesCancelled")
    private String salesCancelled;
    @JsonProperty("Contact")
    List<ContactGetVin> ListOfContact;
    @JsonProperty("Account")
    List<AccountGetVin> ListOfAccount;
}
