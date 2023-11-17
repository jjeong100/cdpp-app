package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ServiceRequestChatInput")
@Getter
@Setter
public class ServiceRequestChatInput {
    
    @Schema(description = "Owner By Id", example = "1-3LHJF40")
    @JsonProperty("OwnedById")
    private String ownedById;
    @Schema(description = "Protocol unique identifier. If an update is needed, value on this tag must be provided.", example = "HMB98949022323")
    private String protocol;
    @Schema(description = "Protocol reason. Valid values:Complaint, Compliment", example = "Information")
    @NotNull @NotBlank @NotEmpty
    private String reason;
    @Schema(description = "VOC level 1. Values are according business definitions for each situation.", example = "Sales")
    @NotNull @NotBlank @NotEmpty
    private String level1;
    @Schema(description = "VOC level 2. Values are according business definitions for each situation.", example = "Request a quote")
    private String level2;
    @Schema(description = "VOC level 3. Values are according business definitions for each situation.", example = "Direct sales")
    private String level3;
    @Schema(description = "VOC level 4. Values are according business definitions for each situation.", example = "Acceleration 0 - 100 km/h")
    private String level4;
    @Schema(description = "Protocol source. Valid values: Call Center, Complaint Site, Dealer, Director, Facebook, Other", example = "Call Center")
    @NotNull @NotBlank @NotEmpty
    private String source;
    @Schema(description = "Protocol entry method. Valid values: Chat, Email, Internet, Mail/Letter, Other Social Media", example = "Email")
    private String method;
    @Schema(description = "Protocol description.", example = "Campaing Massiva Prova Full PBL2 venda HMB20")
    private String description;
    @Schema(description = "Protocol status. Valid values: Open, In Progress BO, Canceled, Closed", example = "Open")
    private String status;
    @Schema(description = "Protocol priority. Valid values: Low, Medium, High, Critical", example = "Medium")
    private String priority;
    @Schema(description = "HMB vision about dealer on this protocol. Valid values: Dealer Appropriate treatment, Dealer Inappropriate treatment", example = "Answered Question")
    private String solution;
    @Schema(description = "Vehicle chassis related with the protocol.", example = "9BHBH41DBGP633658")
    private String serialNumber;
    @Schema(description = "Flag indicating that the protocol does not have a customer associated. Valid values: Y , N", example = "Y")
    private String anonymousFlag;
    @Schema(description = "Connex contact Id.", example = "1-1GTF")
    private String contactId;
    @Schema(description = "Connex account Id.", example = "1-1GSL")
    private String accountId;
    @Schema(description = "Customer tendency on this protocol : Negative, Neutral, Positive", example = "Negative")
    private String tendency;
    @Schema(description = "Customer satisfaction level on this protocol. Valid values: Customer Dissatisfied, Customer Satisfied, Normal Condition", example = "Customer Satified")
    private String satisfaction;
    @Schema(description = "Dealer code related with this protocol.", example = "B05AM19029")
    private String dealerId;
    @Schema(description = "Protocol causing area.Valid values: Dealer, Generalli, HMB, Mobis", example = "Dealer")
    private String causingArea;
    @Schema(description = "Vehicle immobilized date. Format: MM/DD/YYYY", example = "2023-10-24T15:00:02-0300")
    private String imobilizationDate;
    @Schema(description = "Vehicle model related with the protocol. Valid values: HB20, HB20 FOR YOU", example = "HB20")
    private String relatedModel;
    @Schema(description = "Open text field, with quote description.", example = "Long")
    private String quoteDescription;
    @Schema(description = "Open text field with descriptions for model, engine and transmission related with a quote.", example = " 4 Portas 1.6 Gamma Transmiss\u00E3o Autom\u00E1tica")
    private String engineTransmission;
    @Schema(description = "Vehicle version related with a quote. Valid values: Comfort Plus, Comfort Plus com Audio Hyundai BTH", example = "Comfort Plus com Audio Hyundai BTH")
    private String version;
    @Schema(description = "Open text field to accommodate vehicle price for a quote. ", example = "Comfort com Audio Hyundai")
    private String versionPrice;
    @Schema(description = "Color description related with a quote. Valid values: Blue Ocean, Clay Brown, Blue Sky", example = "Blue Sky")
    private String color;
    @Schema(description = "Open text field to store color price for a quote.", example = "3539500")
    private String colorPrice;
    @Schema(description = "Open text field to store vehicle final price for a quote.", example = "3539500")
    private String finalPrice;
    @Schema(description = "Describes when customer plans to replace his current car. Valid values: 1 Month, Coming soon", example = "Coming soon")
    private String carReplacementIntention;
    @Schema(description = "Roadside assistance Id.", example = "1-1540HW")
    private String roadserviceRequest;
    @Schema(description = "External system integration key value.", example = "1-1540HE")
    private String integrationId;
    @Schema(description = "Flag indicating if test drive is confirmed. Valid values: Y, N", example = "Y")
    private String tdConfirmed;
    @Schema(description = "Test drive scheduled time.", example = "09:00~10:00")
    private String tdTime;
    @Schema(description = "Test drive date.", example = "2023-10-24T15:00:02")
    private String tdDate;
    @Schema(description = "Sales representative's CPF.", example = "1-1540PO")
    private String salesrepId;
    @Schema(description = "Flag", example = "Y")
    private String pneFlag;
    @Schema(description = "VIP List Campaign Id.", example = "1-4GZNHT")
    private String campaignId;
    @Schema(description = "VIP List Campaign source tag.", example = "CRM")
    private String sourceTag;
    @Schema(description = "VIP List Campaign stock.", example = "Own stock")
    private String estoque;
    @Schema(description = "VIP List Campaign medium tag.", example = "E-mail")
    private String medium;
    @Schema(description = "VIP List Campaign content tag.", example = "Email_NewHB20SCustomer_Loyalty")
    private String content;
    @Schema(description = "VIP List Campaign tag.", example = "Email_LoyaltyProgram_Outubro15")
    private String campaign;
    @Schema(description = "Service request additional comments. Field currently not in use. Was created for synergy project between Connex and Dealer Portal and was not used.", example = "Comentarios adicionais")
    private String additionalComments;
    @Schema(description = "Dealer employee related with a complaint.", example = "Pessoa causadora")
    private String causingPerson;
    @Schema(description = "Person representing customer for this particular service request.", example = "Fiance")
    private String custRepresentative;
    @Schema(description = "Relationship between the person representing customer and the customer itself. Valid values: Cousin, Father", example = "Father")
    private String custRepresentativeRel;
    @Schema(description = "Flag indicating if dealer encountered difficulties in problem diagnosis. Valid values: Y, N", example = "Y")
    private String diagnosisDifficultyFlg;
    @Schema(description = "Flag indicating if diagnose is pending. Valid values: Y, N", example = "N")
    private String diagnosisPendingFlg;
    @Schema(description = "Dealer answer about what happened in a complaint.", example = "Descri 00E7 00E3o do dealer")
    private String dlrDescription;
    @Schema(description = "Dealer answer about follow up that he maintained with customer in a complaint.", example = "sim")
    private String dlrFup;
    @Schema(description = "Dealer answer about what is pending to solve the problem in a complaint.", example = "Pend 00EAncia do Dealer")
    private String dlrPending;
    @Schema(description = "Flag indicating if customer wants a retraction from dealer in a complaint. Valid values: Y, N", example = "N")
    private String dlrRetractionFlg;
    @Schema(description = "Dealer answer about what is the reversal action to solve a complaint.", example = "Revers 00E3o do deale")
    private String dlrReversal;
    @Schema(description = "Flag indicating if there is a hotline related with the complaint. Valid values: Y, N", example = "N")
    private String hotlineFlg;
    @Schema(description = "Hotline number.", example = "HOT001")
    private String hotlineNum;
    @Schema(description = "Hotline open date.", example = "2023-10-24T15:00:02-0300")
    private String hotlineOpenDt;
    @Schema(description = "Purchase proposal number for complaints related with delayed delivery.", example = "PROPOSTA002")
    private String purchaseProposalNum;
    @Schema(description = "Flag indicating if there is a PWA (Pre-warranty approval) related with the complaint. Valid values: Y, N", example = "Y")
    private String pwaFlg;
    @Schema(description = "PWA number.", example = "PWA001")
    private String pwaNum;
    @Schema(description = "PWA opened date.", example = "2023-10-24T15:00:02-0300")
    private String pwaOpenDt;
    @Schema(description = "Flag indicating if the complaint is recurring. Valid values: Y, N", example = "Y")
    private String recurrenceFlg;
    @Schema(description = "Number of complaint recurrences.", example = "23456789")
    private int recurrenceNum;
    @Schema(description = "Date of vehicle delivery, either for purchases or repairs.", example = "2023-10-24T15:00:02-0300")
    private String vehicleDeliveryDt;
    @Schema(description = "Flag indicating if the vehicle was delivered, either for purchases or repairs. Valid values: Y, N", example = "Y")
    private String vehicleDeliveryFlg;
    @Schema(description = "Flag indicating if customer wants a loan in a quote. Valid values: Y, N", example = "Y")
    @JsonProperty("wants_loan")
    private String wantsLoan;
    @Schema(description = "Loan type. Possible values are according to business definitions. Connex will accept any string limited to 50 characters. Suggested values: Hyundai Financiamento, Hyundai Financiamento, Compra Certa", example = "Compra Certa")
    @JsonProperty("loan_type")
    private String loanType;
    @Schema(description = "Desired installments amount for the loan.", example = "14300")
    @JsonProperty("installments_amt")
    private int installmentsAmt;
    @Schema(description = "Down payment value.", example = "60")
    @JsonProperty("down_payment")
    private int downPayment;
    @Schema(description = "Flag indicating if customer wants to give his current car as down payment in a quote. Valid values: Y, N", example = "Y")
    @JsonProperty("used_car_as_down_paymnt")
    private String usedCarAsDownPaymnt;
    @Schema(description = "Dealer temperature indicates the level for close deal. Valid values: Q, M, F", example = "Q")
    private String dlrTemperature;


    @Valid @JsonProperty("Chat")
    Chat chat;
    
}
