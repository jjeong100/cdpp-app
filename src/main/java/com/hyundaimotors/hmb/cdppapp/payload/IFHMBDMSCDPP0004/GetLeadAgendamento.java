package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadAgendamento {
    @Schema(description = "Numero Interaction", example = "2")
    @JsonProperty("TipoAgendamento")
    private String tipoAgendamento;
    @Schema(description = "Description Interaction", example = "04/10/2018 - O cliente fez o testdrive")
    @JsonProperty("DataAgendamento")
    private String dataAgendamento;
}
