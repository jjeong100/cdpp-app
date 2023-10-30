package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalLeadDto {
    private String protocol;
    private String reason;
    private String origin;
    private String method;
    private String openDate;
    private String closeDate;
    private String status;
    private String level1;
    private String level2;
    private String level3;
    private String level4;
    private String predictiveTemp;
    private String dealerCode;
    private String dealerNick;
    private String relatedModel;
    private String quoteTransmission;
    private String sourceTag;
    private String mediumTag;
    private String contentTag;
    private String campaignTag;
    private String form;
    private String tdConfirmed;
    private String tdCompleted;
    private String updated;
    private String tdModel;
    private String reserveAmount;
    private String paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    private String tdVersion;
    private String description;
    private String usadoMarca;
    private String usadoModelo;
    private String usadoChassi;
    private String usadocor;
    private String usadoQuilometragem;
    private String usadoprecoMaximo;
    private String usadoprecoMedio;
    private String usadoprecoMinimo;
    private String usadoPlaca;
    private String usadoVersao;
    private String usadoAno;
    private String quoteColor;
    private String quoteColorPrice;
    private String quoteVersionPrice;
    private String quotePrice;
    private String quoteReplaceIntention;
    private String contactRowId;
    List<TotalContactDto> contact;
    TotalActionDto action;
}
