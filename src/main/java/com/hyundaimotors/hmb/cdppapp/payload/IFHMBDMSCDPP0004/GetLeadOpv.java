package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadOpv {
    @Schema(description = "Protocolo", example = "HMB8761468242")
    @JsonProperty("Protocolo")
    private String protocolo;
    @Schema(description = "CodigoConcessionaria", example = "B05AM19029")
    @JsonProperty("CodigoConcessionaria")
    private String codigoConcessionaria;
    @Schema(description = "Origem", example = "Homepage")
    @JsonProperty("Origem")
    private String origem;
    @Schema(description = "Metodo", example = "Internet")
    @JsonProperty("Metodo")
    private String metodo;
    @Schema(description = "mm/dd/yyyy hh24:mi:ss", example = "2020-03-04  4:42:45 PM")
    @JsonProperty("DataAbertura")
    private String dataAbertura;
    @Schema(description = "NomeResponsavel", example = "HMBPrueba")
    @JsonProperty("NomeResponsavel")
    private String nomeResponsavel;
    @Schema(description = "Status", example = "Open")
    @JsonProperty("Status")
    private String status;
    @Schema(description = "Prioridade", example = "Normal")
    @JsonProperty("Prioridade")
    private String prioridade;
    @Schema(description = "Y or N", example = "Y")
    @JsonProperty("IdentificacaoPCD")
    private String identificacaoPCD;
    @Schema(description = "TipoContato", example = "Customer")
    @JsonProperty("TipoContato")
    private String tipoContato;
    @Schema(description = "ClienteHyundai", example = "Y")
    @JsonProperty("ClienteHyundai")
    private String clienteHyundai;
    @Schema(description = "UsadoNaTroca", example = "Y")
    @JsonProperty("UsadoNaTroca")
    private String usadoNaTroca;
    @Schema(description = "OptInCotacao", example = "N")
    @JsonProperty("OptInCotacao")
    private String optInCotacao;
    @Schema(description = "OptInContato", example = "N")
    @JsonProperty("OptInContato")
    private String optInContato;
    @Schema(description = "NomeConcessionaria", example = "CAOA - Barra II")
    @JsonProperty("NomeConcessionaria")
    private String nomeConcessionaria;
    @Schema(description = "StatusConcessionaria", example = "Active")
    @JsonProperty("StatusConcessionaria")
    private String statusConcessionaria;
    @Schema(description = "Comentario", example = "gostaria de simula 00E7 00F5es para financiamento do veiculo. em 60 vezes")
    @JsonProperty("Comentario")
    private String comentario;
    @Schema(description = "yyyy-MM-ddThh24:mi:ss", example = "2023-10-02T10:47:32")
    @JsonProperty("DataFechamento")
    private String dataFechamento;
    @Schema(description = "MetodoContato", example = "Internet")
    @JsonProperty("MetodoContato")
    private String metodoContato;
    @Schema(description = "ObservacoesContato", example = "gostaria de simula 00E7 00F5es para financiamento do veiculo. em 60 vezes")
    @JsonProperty("ObservacoesContato")
    private String observacoesContato;
    @Schema(description = "DadosCampanha", example = "Massive Campaigns")
    @JsonProperty("DadosCampanha")
    private String dadosCampanha;
    @Schema(description = "SourceTag", example = " ")
    @JsonProperty("SourceTag")
    private String sourceTag;
    @Schema(description = "MediumTag", example = " ")
    @JsonProperty("MediumTag")
    private String mediumTag;
    @Schema(description = "ContentTag", example = " ")
    @JsonProperty("ContentTag")
    private String contentTag;
    @Schema(description = "Form", example = " ")
    @JsonProperty("Form")
    private String form;
}
