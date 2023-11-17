package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeaDveiculoEntradaOPVDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadAgendamentoDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadFinanciamentoOPVDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadInteractionDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadOpvDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadResultDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadTemperatureDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004.GetLeadVeiculo;

public interface IFHMBDMSCDPP0004Mapper {

    public List<IFHMBDMSCDPP0004Dto> getLeadInfoList(IFHMBDMSCDPP0004Dto dto)throws Exception;
    
    public GetLeadContactDto getContactInfo(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public List<GetLeadVeiculo> getVeiculoInfoList(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public GetLeadOpvDto getOpvInfo(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public GetLeadFinanciamentoOPVDto getfinanciamentoOpv(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public List<GetLeadTemperatureDto> getTemperatureList(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public List<GetLeadAgendamentoDto> getAgendamentoList(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public GetLeadResultDto getResult(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public List<GetLeadInteractionDto> getInteractionList(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public GetLeaDveiculoEntradaOPVDto getVeiculoEntradaOPV(IFHMBDMSCDPP0004Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String[]> parMap)throws Exception;

    public void transferReplica(HashMap<String, String[]> parMap)throws Exception;
}
