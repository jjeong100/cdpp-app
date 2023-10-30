package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Action")
@Getter
@Setter
public class Action {
    @Schema(description = "Action Activity UID", example = "1-19FH7")
    private String integrationId;
    @Schema(description = "Service request/action", example = "Contact made")
    private String result;
    @Schema(description = "Comment For Dealer", example = "Ana, bom dia! Por gentileza, verificar qual o Dealer envolvido para que eu possa passar a solicita 00E7 00E3o a diante. Fico no aguardo! Elis Ribeiro")
    private String answer;
    @Schema(description = "Action Status", example = "Done")
    private String status;
    @Schema(description = "Action inbound interface", example = "123")
    private String hotlineId;
    @Schema(description = "Action inbound interface", example = "2014-08-18")
    private String hotlineCreation;
    @Schema(description = "Action inbound interface", example = "1235469845")
    private String pwaId;
    @Schema(description = "Created for Call Report", example = "1-19FJ8")
    private String pwaCreation;
    @Schema(description = "Action inbound interface", example = "123456")
    private String roId;
    @Schema(description = "Action inbound interface", example = "2014-08-18")
    private String roCreation;
    @Schema(description = "Action inbound interface", example = "123456")
    private String mobisId;
    @Schema(description = "Action inbound interface", example = "em faturamento")
    private String mobisStatus;
    @Schema(description = "Action inbound interface", example = "2014-08-18")
    private String expectedDelivery;
    @Schema(description = "Action inbound interface", example = "123456")
    private String purchasePurposeId;
    @Schema(description = "Action Type", example = "E-mail - Sa 00EDda")
    @NotNull
    @NotEmpty
    private String type;
    @Schema(description = "Protocol Numer", example = "HMB8761468242")
    private String srProtocol;
    @Schema(description = "Action Priority", example = "Medium")
    private String priority;
    @Schema(description = "Action Owner", example = "SADMIN")
    private String owner;
    @Schema(description = "Comment", example = "Pe 00E7o para ligar para o cliente e desfazer o mal entendido,")
    private String description;
    @Schema(description = "Action Contact Id", example = "1-19XYZ1")
    private String contactId;
    @Schema(description = "Action Dealer Code", example = "B05AM19029")
    private String dealerCode;
    @Schema(description = "Serial Number", example = "123456790")
    private String serialNumber;
    @Schema(description = "Action Created", example = "2012-10-15  5:46:06 PM")
    private String creationDate;
    @Schema(description = "Follow-up Date", example = "2012-10-15  6:52:26 PM")
    private String plannedDt;
    @Schema(description = "Action Order Numero", example = "1-19FJ6")
    private String orderNum;
    @Schema(description = "action inbound interface", example = "Henrique Duarte")
    private String dpUser;
    @Schema(description = "stock", example = "stock")
    private String estoque;
}
