package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBCSUCDPP0086Payload {
    
    @Schema(name = "IFHMBCSUCDPP0086Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Phone number with format: +PaísDDDNumber", example = "+551130675420")
        @JsonProperty("PhoneNumber")
        private String phoneNumber;
    }

    @Schema(name = "IFHMBCSUCDPP0086Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Código de erro (em caso de falha no serviço)", example = "SBL-12Z3Z")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Detalhe da mensagem de erro (em caso de falha no serviço)", example = "Erro ao executar a tarefa  X do Connex.")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @Schema(description = "Nome complete do cliente", example = "João de Jesus Atanázio")
        @JsonProperty("Name")
        private String name;
        @Schema(description = "Cpf number", example = "30311079800")
        @JsonProperty("PersonCPF")
        private String personCPF;
        @Schema(description = "Código do cliente identificado", example = "1-90ABC")
        @JsonProperty("ContactId")
        private String contactId;
        @Schema(description = "Telefone celular do cliente", example = "+5511976588820")
        @JsonProperty("PersonCell")
        private String personCell;
        @Schema(description = "Número do protocolo", example = "HMB98949022323")
        @JsonProperty("Protocol")
        private String protocol;
        @Schema(description = "Numero de Registros", example = "100")
        @JsonProperty("QtdProtocol")
        private String qtdProtocol;
    }
}
