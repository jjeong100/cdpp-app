package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0031;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchServiceRequest")
@Getter
@Setter
public class SearchServiceRequest {
    @Schema(description = "RSA Integration Id", example = "MONDIAL29129941")
    @JsonProperty("RSAIntegrationId")
    private String rsaIntegrationId;
    @Schema(description = "Id", example = "Id")
    @JsonProperty("Id")
    private String id;
    @Schema(description = "TestDriveDate", example = "1-1238L")
    @JsonProperty("TestDriveDate")
    private String testDriveDate;
    @Schema(description = "Test DriveD ate", example = "14:00~16:00")
    @JsonProperty("TestDriveTime")
    private String testDriveTime;
    @Schema(description = "Test Drive Time", example = "2015-09-12")
    @JsonProperty("TestDriveConfirmed")
    private String testDriveConfirmed;
    @Schema(description = "Created", example = "2015-09-10")
    @JsonProperty("Created")
    private String created;
    @Schema(description = "Created By", example = "1-1GQA")
    @JsonProperty("CreatedBy")
    private String createdBy;
    @Schema(description = "Updated", example = "2015-09-14")
    @JsonProperty("Updated")
    private String updated;
    @Schema(description = "Updated By", example = "1-1GQA")
    @JsonProperty("UpdatedBy")
    private String updatedBy;
    @Schema(description = "Sales Rep FirstName", example = "Jose")
    @JsonProperty("SalesRepFirstName")
    private String salesRepFirstName;
    @Schema(description = "Sales Rep LastName", example = "Ciclano")
    @JsonProperty("SalesRepLastName")
    private String salesRepLastName;
    @Schema(description = "Dealer", example = "B05AM09004")
    @JsonProperty("Dealer")
    private String dealer;
    @Schema(description = "Conflict Id", example = "N")
    @JsonProperty("ConflictId")
    private String conflictId;
    @Schema(description = "Mod Id", example = " ")
    @JsonProperty("ModId")
    private String modId;
    @Schema(description = "Codigo Sap TD", example = "345678")
    @JsonProperty("CodigoSAPTD")
    private String codigoSAPTD;
    @Schema(description = "Número do protocolo", example = "HMB98949022323")
    @JsonProperty("Protocol")
    private String protocol;
    @Schema(description = "Seach  Specification", example = "Y")
    @JsonProperty("Searchspec")
    private String searchspec;
    @Schema(description = "Status", example = "Canceled")
    @JsonProperty("Status")
    private String status;
    @Schema(description = "Model", example = "HB20")
    @JsonProperty("Model")
    private String model;
    @Schema(description = "ContactId", example = "1-3U58H1")
    @JsonProperty("ContactId")
    private String contactId;
    @Schema(description = "Area", example = "Test drive")
    @JsonProperty("Area")
    private String area;
    @Schema(description = "CPF", example = "12337343006")
    @JsonProperty("CPF")
    private String cpf;
    @Schema(description = "Origem", example = "Customer")
    @JsonProperty("Origem")
    private String origem;
    @Schema(description = "SRId", example = "1-1GQA")
    @JsonProperty("SRId")
    private String srId;
    @Schema(description = "Selected SR Routing Dealer Code", example = "B05AM09004")
    @JsonProperty("SelectedSRRoutingDealerCode")
    private String selectedSRRoutingDealerCode;
}
