package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadVeiculo {
    @JsonProperty("Modelo")
    @Schema(description = "Veiculo Modelo", example = "HB20")
    private String modelo;
    @Schema(description = "Veiculo Motor", example = "Manual 6")
    @JsonProperty("Motor")
    private String motor;
    @Schema(description = "Veiculo Transmissao", example = "A")
    @JsonProperty("Transmissao")
    private String transmissao;
    @Schema(description = "Veiculo Versao", example = "Comfort Plus")
    @JsonProperty("Versao")
    private String versao;
    @Schema(description = "Veiculo Cor", example = "Blue Sky")
    @JsonProperty("Cor")
    private String cor;
    @Schema(description = "Veiculo Preco", example = "50000")
    @JsonProperty("Preco")
    private String preco;
}
