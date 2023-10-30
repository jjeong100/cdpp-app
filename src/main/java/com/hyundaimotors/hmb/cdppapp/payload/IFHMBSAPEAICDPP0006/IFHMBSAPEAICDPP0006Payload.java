package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0006Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0006Payload.Request")
    @Getter
    @Setter
    public static class Request{


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
        @Schema(description = "Action Created", example = "2023-10-20T15:14:33-0300")
        private String creationDate;
        @Schema(description = "Follow-up Date", example = "2012-10-15T06:52:26-0300")
        private String plannedDt;
        @Schema(description = "Action Order Numero", example = "1-19FJ6")
        private String orderNum;
        @Schema(description = "action inbound interface", example = "Henrique Duarte")
        private String dpUser;
        @Schema(description = "stock", example = "stock")
        private String estoque;

        @JsonProperty("ListOfNotes")
        List<ActionNote> actionNote;
        @JsonProperty("ListOfProducts")
        List<ActionProducts> actionProducts;
        @JsonProperty("ListOfFields")
        List<SynergyActionAudit> synergyActionAudit;
    }

    @Schema(name = "IFHMBSAPEAICDPP0006Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex Action Id", example = "1-40O0EX4")
        @JsonProperty("ActionId")
        private String actionId;
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        
    }
}
