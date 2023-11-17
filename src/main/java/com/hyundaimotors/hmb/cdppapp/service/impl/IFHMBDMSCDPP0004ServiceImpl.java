package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeaDveiculoEntradaOPVDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadAgendamentoDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadFinanciamentoOPVDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadInteractionDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadOpvDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadResultDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.GetLeadTemperatureDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBDMSCDPP0004.IFHMBDMSCDPP0004Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBDMSCDPP0004Mapper;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004.GetLeadVeiculo;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBDMSCDPP0004Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBDMSCDPP0004ServiceImpl implements IFHMBDMSCDPP0004Service{
    
    private final IFHMBDMSCDPP0004Mapper mapper;

    public IFHMBDMSCDPP0004Dto insertObject(IFHMBDMSCDPP0004Dto dto)throws Exception{
        IFHMBDMSCDPP0004Dto resultDto = new IFHMBDMSCDPP0004Dto();
        
        List<IFHMBDMSCDPP0004Dto> getLeadInfoList = new ArrayList<>();

        List<GetLeadDto> listOfLead = new ArrayList<>();
        GetLeadContactDto contato = new GetLeadContactDto();
        List<GetLeadVeiculo> veiculoInfoList = new ArrayList<>();
        GetLeadOpvDto opv = new GetLeadOpvDto();
        GetLeadFinanciamentoOPVDto financiamentoOPV = new GetLeadFinanciamentoOPVDto();
        List<GetLeadTemperatureDto> temperatureList = new ArrayList<>();
        List<GetLeadAgendamentoDto> agendamentoList = new ArrayList<>();
        GetLeadResultDto result = new GetLeadResultDto();
        List<GetLeadInteractionDto> interactionList = new ArrayList<>();
        GetLeaDveiculoEntradaOPVDto veiculoEntradaOPV = new GetLeaDveiculoEntradaOPVDto();
        List<String> protocalList = new ArrayList<>();

        getLeadInfoList = mapper.getLeadInfoList(dto);

        
        if(0 < getLeadInfoList.size()){
            for(int i=0; i < getLeadInfoList.size(); i++){
                protocalList.add(getLeadInfoList.get(i).getProtocol());
                GetLeadDto getLeadDto = new GetLeadDto();
                contato = mapper.getContactInfo(getLeadInfoList.get(i));
                if(contato != null){
                    getLeadDto.setContato(contato);
                }

                veiculoInfoList = mapper.getVeiculoInfoList(getLeadInfoList.get(i));
                if(0 < veiculoInfoList.size()){
                    getLeadDto.setVeiculo(veiculoInfoList);
                }
                
                opv = mapper.getOpvInfo(getLeadInfoList.get(0));
                if(opv != null){
                    getLeadDto.setOpv(opv);
                }

                financiamentoOPV = mapper.getfinanciamentoOpv(getLeadInfoList.get(i));
                if(financiamentoOPV != null){
                    getLeadDto.setFinanciamentoOPV(financiamentoOPV);
                }

                temperatureList = mapper.getTemperatureList(getLeadInfoList.get(i));
                if(0 < temperatureList.size()){
                    getLeadDto.setTemperature(temperatureList);
                }

                agendamentoList = mapper.getAgendamentoList(getLeadInfoList.get(i));
                if(0 < agendamentoList.size()){
                    getLeadDto.setAgendamento(agendamentoList);
                }

                result = mapper.getResult(getLeadInfoList.get(i));
                if(result != null){
                    getLeadDto.setResult(result);
                }

                interactionList = mapper.getInteractionList(getLeadInfoList.get(i));
                if(0 < interactionList.size()){
                    getLeadDto.setInteraction(interactionList);
                }

                veiculoEntradaOPV = mapper.getVeiculoEntradaOPV(getLeadInfoList.get(i));
                if(veiculoEntradaOPV != null){
                    getLeadDto.setVeiculoEntradaOPV(veiculoEntradaOPV);
                }
                listOfLead.add(getLeadDto);
            }
            resultDto.setListOfLead(listOfLead);
            resultDto.setErrorspcCode("0");
            resultDto.setErrorspcMessage("OK");

            String[] param = protocalList.toArray(new String[protocalList.size()]);
            
            HashMap<String, String[]> map = new HashMap<>();
            map.put("param_id", param);
            
            UpdateOppt(map);

        }else{
            resultDto.setErrorspcCode("1");
            resultDto.setErrorspcMessage("No Data");
        }

        return resultDto;
    }
    @Async
    public void UpdateOppt(HashMap<String, String[]> map)throws Exception{
        mapper.transferProcess(map);
        mapper.transferReplica(map);
    } 
}
