package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ChannelPartner")
@Getter
@Setter
public class ChannelPartner {
    @Schema(description = "External system unique identifier.", example = "B05AM99999")
    @JsonProperty("IntegrationId")
    private String integrationId;
    @Schema(description = "Company document number (numbers only)", example = "78753880000164")
    @JsonProperty("CNPJ")
    private String cnpj;
    @Schema(description = "Company name", example = "Motonet Comercio de Veiculos M")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("Name")
    private String name;
    @Schema(description = "Company nickname", example = "Abr 00E3o Reze - Sorocaba")
    @JsonProperty("Nickname")
    private String nickname;
    @Schema(description = "Account Status", example = "Active")
    @JsonProperty("AccountStatus")
    private String accountStatus;
    @Schema(description = "Reason Status", example = "Fiscal Check")
    @JsonProperty("ReasonStatus")
    private String reasonStatus;
    @Schema(description = "Dealer Type", example = "Dealer")
    @JsonProperty("DealerType")
    private String dealerType;
    @Schema(description = "Dealer Code", example = "B05AM99999")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("DealerCode")
    private String dealerCode;
    @Schema(description = "Main phone.", example = "2345678")
    @JsonProperty("MainPhone")
    private String mainPhone;
    @Schema(description = "Main Fax phone.", example = "3456789")
    @JsonProperty("Fax")
    private String fax;
    @Schema(description = "Company email address.", example = "kilosolution2s@gmail.com")
    @JsonProperty("MainEmailAddress")
    private String mainEmailAddress;
    @Schema(description = "Work Email Address", example = "Prueba@hyundai.com")
    @JsonProperty("WorkEmailAddress")
    private String workEmailAddress;
    @Schema(description = "Sales Dealer Flag", example = "Y")
    @JsonProperty("SalesDealerFlag")
    private String salesDealerFlag;
    @Schema(description = "Service Dealer Flag", example = "N")
    @JsonProperty("ServiceDealerFlag")
    private String serviceDealerFlag;
    @Schema(description = "Partner Start Date", example = "2012-10-10")
    @JsonProperty("PartnerStartDate")
    private String partnerStartDate;
    @Schema(description = "Partner End Date", example = "2015-10-10")
    @JsonProperty("PartnerEndDate")
    private String partnerEndDate;
    @Schema(description = "Region", example = "Sul")
    @JsonProperty("Region")
    private String region;
    @Schema(description = "Working Hour", example = "8")
    @JsonProperty("WorkingHours")
    private String workingHour;
    @Schema(description = "Facebook Page", example = "Prueba Hyundai")
    @JsonProperty("FacebookPage")
    private String facebookPage;
    @Schema(description = "URL ", example = "www.prueba.com.br")
    @JsonProperty("HomePage")
    private String homepage;
    @Schema(description = "Address street name.", example = "Rua Tutoia")
    @JsonProperty("StreetAddress")
    private String streetAddress;
    @Schema(description = "Address house number", example = "380")
    @JsonProperty("StreetAddress2")
    private String streetAddress2;
    @Schema(description = "Address complement.", example = "Andar 3")
    @JsonProperty("StreetAddress3")
    private String streetAddress3;
    @Schema(description = "County.", example = "Sao Paulo")
    @JsonProperty("County")
    private String county;
    @Schema(description = "Address city.", example = "Brasil")
    @JsonProperty("City")
    private String city;
    @Schema(description = "Address state.", example = "S00E3o Paulo ")
    @JsonProperty("State")
    private String state;
    @Schema(description = "Address Neighborhood", example = "Paraiso")
    @JsonProperty("Neighborhood")
    private String neighborhood;
    @Schema(description = "Address Latitude", example = "23.497694")
    @JsonProperty("Latitude")
    private String latitude;
    @Schema(description = "Address Longitude", example = "47.441679")
    @JsonProperty("Longitude")
    private String longitude;
    @Schema(description = "Address zip code.", example = "4007001")
    @JsonProperty("ZipCode")
    private String zipCode;
    @Schema(description = "Dealer Code", example = "B05AM09004")
    @JsonProperty("CSN")
    private String csn;
    @Schema(description = "PROC ACCOUNT ROW ID", example = "1-2BRX-4802")
    @JsonProperty("Id")
    private String id;

    @JsonProperty("ListOfContacts")
    private List<ChannelPartnerContact> channelPartnerContact;
}
