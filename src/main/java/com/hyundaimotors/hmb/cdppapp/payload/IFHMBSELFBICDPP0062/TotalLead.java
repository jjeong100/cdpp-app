package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0062;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "TotalLead")
@Getter
@Setter
public class TotalLead {
    @Schema(description = "Protocol unique identifier. If an update is needed, value on this tag must be provided.", example = "HMB98949022323")
    @JsonProperty("Protocol")
    private String protocol;
    @Schema(description = "Protocol reason. Valid values", example = "Information")
    @JsonProperty("Reason")
    private String reason;
    @Schema(description = "Protocol source. Valid values:", example = "Email")
    @JsonProperty("Origin")
    private String origin;
    @Schema(description = "Protocol entry method. Valid values:", example = "Email")
    @JsonProperty("Method")
    private String method;
    @Schema(description = "yyyy-MM-ddThh24:mi:ssZ", example = "2020-05-01T13:19:03-0300")
    @JsonProperty("OpenDate")
    private String openDate;
    @Schema(description = "yyyy-MM-ddThh24:mi:ssZ", example = "2020-05-01T13:19:03-0300")
    @JsonProperty("CloseDate")
    private String closeDate;
    @Schema(description = "Protocol status. Valid values:", example = "Open")
    @JsonProperty("Status")
    private String status;
    @Schema(description = "VOC level 1. Values are according business definitions for each situation.", example = "Sales")
    @JsonProperty("Level1")
    private String level1;
    @Schema(description = "VOC level 2. Values are according business definitions for each situation.", example = "Request a quote")
    @JsonProperty("Level2")
    private String level2;
    @Schema(description = "VOC level 3. Values are according business definitions for each situation.", example = "Direct sales")
    @JsonProperty("Level3")
    private String level3;
    @Schema(description = "VOC level 4. Values are according business definitions for each situation.", example = "Acceleration 0 - 100 km/h")
    @JsonProperty("Level4")
    private String level4;
    @Schema(description = "Dealer temperature indicates the level for close deal.", example = "Q")
    @JsonProperty("PredictiveTemp")
    private String predictiveTemp;
    @Schema(description = "Dealer code related with this protocol.", example = "B05AM19029")
    @JsonProperty("DealerCode")
    private String dealerCode;
    @Schema(description = "Dealer Nickname", example = "CAOA São Paulo")
    @JsonProperty("DealerNick")
    private String dealerNick;
    @Schema(description = "Vehicle model related with the protocol. Valid values:", example = "HB20")
    @JsonProperty("RelatedModel")
    private String relatedModel;
    @Schema(description = "Open text field with descriptions for model, engine and transmission related with a quote.", example = "4 Portas 1.6 Gamma Transmissão Automática")
    @JsonProperty("QuoteTransmission")
    private String quoteTransmission;
    @Schema(description = "Vehicle version related with a quote. Valid values:", example = "Comfort Plus com Audio Hyundai")
    @JsonProperty("QuoteVersion")
    private String quoteVersion;
    @Schema(description = "VIP List Campaign source tag.", example = "CRM")
    @JsonProperty("SourceTag")
    private String sourceTag;
    @Schema(description = "VIP List Campaign medium tag.", example = "E-mail")
    @JsonProperty("MediumTag")
    private String mediumTag;
    @Schema(description = "VIP List Campaign content tag.", example = "Email_NewHB20SCustomer_Loyalty")
    @JsonProperty("ContentTag")
    private String contentTag;
    @Schema(description = "VIP List Campaign tag.", example = "Email_LoyaltyProgram_Outubro15")
    @JsonProperty("CampaignTag")
    private String campaignTag;
    @Schema(description = "VIP List Campaign tag.", example = "Email_LoyaltyProgram_Outubro15")
    @JsonProperty("Form")
    private String form;
    @Schema(description = "Flag indicating if test drive is confirmed. Valid values:", example = "Y")
    @JsonProperty("TDConfirmed")
    private String tdConfirmed;
    @Schema(description = "Test Drive Concluded", example = "Y")
    @JsonProperty("TDCompleted")
    private String tdCompleted;
    @Schema(description = "yyyy-MM-ddThh24:mi:ssZ", example = "2020-05-01T13:23:23-0300")
    @JsonProperty("Updated")
    private String updated;
    @Schema(description = "yyyy-MM-ddThh24:mi:ssZ", example = "2020-05-01T13:23:23-0300")
    @JsonProperty("TDModel")
    private String tdModel;
    @Schema(description = "payment amount of reservation a new hmb car", example = "1000")
    @JsonProperty("ReserveAmount")
    private String reserveAmount;
    @Schema(description = "payment date of reservation a new hmb car", example = "2023-10-02T11:11:23-0300")
    @JsonProperty("PaymentDate")
    private String paymentDate;
    @Schema(description = "payment method of reservation a new hmb car", example = "PIX, Credit Card")
    @JsonProperty("PaymentMethod")
    private String paymentMethod;
    @Schema(description = "payment status of reservation a new hmb car", example = "Pending")
    @JsonProperty("PaymentStatus")
    private String paymentStatus;
    @Schema(description = "Vehicle version", example = "CRETA SPORT 2.0 6AT AV+SEN+CAM+ESC+DAC")
    @JsonProperty("TDVersion")
    private String tdVersion;
    @Schema(description = "Protocol description.", example = "Campaing Massiva Prova Full PBL2 venda HMB20")
    @JsonProperty("Description")
    private String description;
    @Schema(description = "if customer wants to give your own car as a payment (car brand)", example = "Hyundai")
    private String usadoMarca;
    @Schema(description = "if customer wants to give your own car as a payment (car model)", example = "HB20")
    private String usadoModelo;
    @Schema(description = "if customer wants to give your own car as a payment (chassi)", example = "9BHBH51DADP010362")
    private String usadoChassi;
    @Schema(description = "if customer wants to give your own car as a payment (car color)", example = "Black")
    private String usadocor;
    @Schema(description = "if customer wants to give your own car as a payment (car km)", example = "50000")
    private String usadoQuilometragem;
    @Schema(description = "if customer wants to give your own car as a payment (car max price provided by auto avaliar)", example = "60000")
    private String usadoprecoMaximo;
    @Schema(description = "if customer wants to give your own car as a payment (car medium price provided by auto avaliar)", example = "56000")
    private String usadoprecoMedio;
    @Schema(description = "if customer wants to give your own car as a payment (car min price provided by auto avaliar)", example = "54000")
    private String usadoprecoMinimo;
    @Schema(description = "if customer wants to give your own car as a payment (car plate)", example = "XXX-1234")
    private String usadoPlaca;
    @Schema(description = "if customer wants to give your own car as a payment (car version)", example = "HB20S Confort Plus")
    private String usadoVersao;
    @Schema(description = "if customer wants to give your own car as a payment (car year)", example = "2017")
    private String usadoAno;
    @Schema(description = "Color description related with a quote. Valid values:", example = "Blue Sky")
    @JsonProperty("QuoteColor")
    private String quoteColor;
    @Schema(description = "Open text field to store color price for a quote.", example = "R$34.395,00")
    @JsonProperty("QuoteColorPrice")
    private String quoteColorPrice;
    @Schema(description = "Open text field to accommodate vehicle price for a quote. ", example = "Comfort com Audio Hyundai")
    @JsonProperty("QuoteVersionPrice")
    private String quoteVersionPrice;
    @Schema(description = "Open text field to store vehicle final price for a quote.", example = "R$35.395,00")
    @JsonProperty("QuotePrice")
    private String quotePrice;
    @Schema(description = "Describes when customer plans to replace his current car. Valid values:", example = "Coming Soon")
    @JsonProperty("QuoteReplaceIntention")
    private String quoteReplaceIntention;
    @JsonProperty("Contact")
//    List<TotalContact> contact;//20231030 Object Type 으로 수정 Mapping Spec 확인
    TotalContact contact;
    @JsonProperty("Action")
    TotalAction action;
}
