package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0001Payload {
    
    @Schema(name = "IFHMBZICARDCDPP0001Payload.Request")
    @Getter
    @Setter
    public static class Request{
        
        @Schema(description = "phone Number", example = "+5515997501064")
        @JsonProperty("phone")
        private String phoneNumber;
        
        @Schema(description = "cpfNumber", example = "21955839832")
        @JsonProperty("cpf")
        private String cpf;
        
    }

    @Schema(name = "IFHMBZICARDCDPP0001Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "cpfNumber", example = "12337343006")
        @JsonProperty("CPF")
        private String cpf;
        @Schema(description = "ContactId", example = "1-90ABC")
        @JsonProperty("ContactId")
        private String contactId;
        @Schema(description = "Full name", example = "Jo\u00E3o de Jesus Atan\u00E1zio")
        @JsonProperty("Name")
        private String name;
        @Schema(description = "personCell", example = "5511976588820")
        @JsonProperty("PersonCell")
        private String personCell;
        @Schema(description = "protocolNumber", example = "HMB98949022323")
        @JsonProperty("ProtocolNumber")
        private String protocolNumber;
        @Schema(description = "protocolOwnerLogin", example = "HMBJBSOUZA")
        @JsonProperty("ProtocolOwnerLogin")
        private String protocolOwnerLogin;
        @Schema(description = "protocolOwnerName", example = "Joaquim de Sousa")
        @JsonProperty("ProtocolOwnerName")
        private String protocolOwnerName;
        @Schema(description = "protocolStatus", example = "In Progress BO")
        @JsonProperty("ProtocolStatus")
        private String protocolStatus;
        @Schema(description = "errorSpcCode", example = "SBL-12Z3Z")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "errorSpcMessage", example = "Erro ao executar a tarefa  X do Connex.")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}