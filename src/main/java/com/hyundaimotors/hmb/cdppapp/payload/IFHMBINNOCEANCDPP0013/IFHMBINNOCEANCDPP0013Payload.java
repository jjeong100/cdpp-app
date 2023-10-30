package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0013;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0013Payload {
    
    
    @Schema(name = "IFHMBINNOCEANCDPP0013Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "External system unique identifier.", example = "B05AM99999")
        @JsonProperty("IntegrationId")
        private String integrationId;
        @Schema(description = "Company document number (numbers only)", example = "78753880000164")
        @JsonProperty("CNPJ")
        private String cnpj;
        @Schema(description = "Company name", example = "Motonet Comercio de Veiculos M")
        @JsonProperty("Name")
        @NotNull
        private String name;
        @Schema(description = "Company nickname", example = "Abr00E3o Reze - Sorocaba")
        @JsonProperty("Nickname")
        private String nickname;
        @Schema(description = "Account Status", example = "Active")
        @JsonProperty("AccountStatus")
        private String accountStatus;
        @Schema(description = "Reason Status", example = "Fiscal Check")
        @JsonProperty("ReasonStatus")
        private String reasonStatus;
        @Schema(description = "Dealer Type", example = "HMB")
        @JsonProperty("DealerType")
        private String dealerType;
        @Schema(description = "Dealer Code", example = "B05AM23007")
        @JsonProperty("DealerCode")
        @NotNull
        private String dealerCode;
        @Schema(description = "Main phone.", example = "551530349000")
        @JsonProperty("MainPhone")
        private String mainPhone;
        @Schema(description = "Main Fax phone.", example = "551530349001")
        @JsonProperty("Fax")
        private String fax;
        @Schema(description = "Company email address.", example = "carlos.spinosa@abraoreze.com.br")
        @JsonProperty("MainEmailAddress")
        private String mainEmailAddress;
        @Schema(description = "Work Email Address", example = "contatohb@abraoreze.com.br")
        @JsonProperty("WorkEmailAddress")
        private String workEmailAddress;
        @Schema(description = "Sales Dealer Flag", example = "Y")
        @JsonProperty("SalesDealerFlag")
        private String salesDealerFlag;
        @Schema(description = "Service Dealer Flag", example = "N")
        @JsonProperty("ServiceDealerFlag")
        private String serviceDealerFlag;
        @Schema(description = "Partner Start Date", example = "41192")
        @JsonProperty("PartnerStartDate")
        private String partnerStartDate;
        @Schema(description = "Partner End Date", example = "42287")
        @JsonProperty("PartnerEndDate")
        private String partnerEndDate;
        @Schema(description = "Region", example = "R5")
        @JsonProperty("Region")
        private String region;
        @Schema(description = "Working Hour", example = "8")
        @JsonProperty("WorkingHours")
        private String workingHours;
        @Schema(description = "Facebook Page", example = "Prueba Hyundai")
        @JsonProperty("FacebookPage")
        private String facebookPage;
        @Schema(description = "URL ", example = "www.prueba.com.br")
        @JsonProperty("HomePage")
        private String homepage;
        @Schema(description = "Address street name.", example = "Av Sao 001")
        @JsonProperty("StreetAddress")
        private String streetAddress;
        @Schema(description = "Address house number", example = "1083")
        @JsonProperty("StreetAddress2")
        private String streetAddress2;
        @Schema(description = "Address complement.", example = "Andar 3")
        @JsonProperty("StreetAddress3")
        private String streetAddress3;
        @Schema(description = "Address county.", example = "Alem Ponte")
        @JsonProperty("County")
        private String county;
        @Schema(description = "Address city.", example = "Sorocaba")
        @JsonProperty("City")
        private String city;
        @Schema(description = "Address state.", example = "SP")
        @JsonProperty("State")
        private String state;
        @Schema(description = "Address Latitude", example = "23.497694")
        @JsonProperty("Latitude")
        private int latitude;
        @Schema(description = "Address Longitude", example = "47.441679")
        @JsonProperty("Longitude")
        private int longitude;
        @Schema(description = "Address zip code.", example = "18085450")
        @JsonProperty("PostalCode")
        private String postalCode;

        @Schema(description = "Dealer Group", example = "50")
        @JsonProperty("DealerGroup")
        private String dealerGroup;
        @Schema(description = "Salse Group", example = "SP3")
        @JsonProperty("SalseGroup")
        private String salesGroup;
        @Schema(description = "Sales Manager", example = "ALEXANDRE CINTRA")
        @JsonProperty("SalesManager")
        private String salesManager;
        @Schema(description = "Sevice Manager", example = "GUSTAVO RODRIGUES DE CARVALHO")
        @JsonProperty("SeviceManager")
        private String serviceManager;
        @Schema(description = "Service WhatsApp Number", example = "(11) 96904-0287")
        @JsonProperty("ServiceWhatsAppNumber")
        private String serviceWhatsAppNumber;
        @Schema(description = "Sales WhatsApp Number", example = "(11) 98360-8844")
        @JsonProperty("SalesWhatsAppNumber")
        private String salesWhatsAppNumber;
        @Schema(description = "Sales District", example = "SE003")
        @JsonProperty("SalesDistrict")
        private String salesDistrict;
        @Schema(description = "Sales Office", example = "R5")
        @JsonProperty("SalesOffice")
        private String salesOffice;
        @Schema(description = "Division", example = "11")
        @JsonProperty("Division")
        private String division;

        @JsonProperty("ListOfContacts")
        List<ListOfContacts> contactList;

    }

    @Schema(name = "IFHMBINNOCEANCDPP0013Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;

    }
}
