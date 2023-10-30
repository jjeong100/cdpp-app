package com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadFinanciamentoOPVDto {
    private String querFinanciar;
    private String tipoFinanciamento;
    private String valorEntradaFinanciamento;
    private String qtdParcelaFinanciamento;
    private String valorParcelaFinanciamento;
}
