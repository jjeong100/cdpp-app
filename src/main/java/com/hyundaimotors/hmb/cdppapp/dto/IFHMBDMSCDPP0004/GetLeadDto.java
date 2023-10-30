package com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004.GetLeadVeiculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadDto {
    private GetLeadContactDto contato;
    List<GetLeadVeiculo> veiculo;
    private GetLeadOpvDto opv;
    private GetLeadFinanciamentoOPVDto financiamentoOPV;
    List<GetLeadTemperatureDto> temperature;
    List<GetLeadAgendamentoDto> agendamento;
    private GetLeadResultDto result;
    List<GetLeadInteractionDto> interaction;
    private GetLeaDveiculoEntradaOPVDto veiculoEntradaOPV;
}
