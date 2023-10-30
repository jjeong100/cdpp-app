package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadFinanciamentoOPV {
    @Schema(description = "Quer Finaciamento", example = "Y")
    @JsonProperty("QuerFinanciar")
    private String querFinanciar;
    @Schema(description = "Tipo do Financiamento", example = "Programa de financiamento da Hyundai")
    @JsonProperty("TipoFinanciamento")
    private String tipoFinanciamento;
    @Schema(description = "Valor Incial Fianciamento", example = "50000")
    @JsonProperty("ValorEntradaFinanciamento")
    private String valorEntradaFinanciamento;
    @Schema(description = "Numero do parcelas", example = "12")
    @JsonProperty("QtdParcelaFinanciamento")
    private String qtdParcelaFinanciamento;
    @Schema(description = "ValorParcelaFinanciamento", example = "50000")
    @JsonProperty("ValorParcelaFinanciamento")
    private String valorParcelaFinanciamento;
}
