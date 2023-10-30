package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLead {
    private GetLeadContact contato;
    List<GetLeadVeiculo> veiculo;
    private GetLeadOpv opv;
    private GetLeadFinanciamentoOPV financiamentoOPV;
    List<GetLeadTemperature> temperature;
    List<GetLeadAgendamento> agendamento;
    private GetLeadResult result;
    List<GetLeadInteraction> interaction;
    private GetLeaDveiculoEntradaOPV veiculoEntradaOPV;
}
