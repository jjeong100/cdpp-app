package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeaDveiculoEntradaOPV {
    @Schema(description = "UsadoNaTroca", example = "Y")
    @JsonProperty("UsadoNaTroca")
    private String usadoNaTroca;
    @Schema(description = "UsadoMarca", example = "Checrolet")
    @JsonProperty("UsadoMarca")
    private String usadoMarca;
    @Schema(description = "UsadoModelo", example = "Celta")
    @JsonProperty("UsadoModelo")
    private String usadoModelo;
    @Schema(description = "UsadoAno", example = " ")
    @JsonProperty("UsadoAno")
    private String usadoAno;
    @Schema(description = "UsadoKM", example = " ")
    @JsonProperty("UsadoKM")
    private String usadoKM;
    @Schema(description = "UsadoExpectativaValor", example = " ")
    @JsonProperty("UsadoExpectativaValor")
    private String usadoExpectativaValor;
    @Schema(description = "UsadoCor", example = " ")
    @JsonProperty("UsadoCor")
    private String usadoCor;
    @Schema(description = "UsadoPlaca", example = " ")
    @JsonProperty("UsadoPlaca")
    private String usadoPlaca;
    @Schema(description = "UsadoChassi", example = " ")
    @JsonProperty("UsadoChassi")
    private String usadoChassi;
    @Schema(description = "UsadoVersao", example = " ")
    @JsonProperty("UsadoVersao")
    private String usadoVersao;
    @Schema(description = "UsadoPrecoMin", example = " ")
    @JsonProperty("UsadoPrecoMin")
    private String usadoPrecoMin;
    @Schema(description = "UsadoPrecoMax", example = " ")
    @JsonProperty("UsadoPrecoMax")
    private String usadoPrecoMax;
    @Schema(description = "UsadoPrecoMed", example = " ")
    @JsonProperty("UsadoPrecoMed")
    private String usadoPrecoMed;
}
