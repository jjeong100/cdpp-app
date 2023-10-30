package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboundRepairService {
    @Schema(description = "soid", example = "0002345")
    @JsonProperty("CODIGO_OS")
    private String soid;
    @Schema(description = "dealercode", example = "B05AM12345")
    @JsonProperty("DEALER_CODE")
    private String dealercode;
    @Schema(description = "vincode", example = "9BH12345678901234")
    @JsonProperty("CHASSI")
    private String vincode;
    @Schema(description = "itmnum", example = "001")
    @JsonProperty("COD_ITEM")
    private String itmnum;
    @Schema(description = "sotype", example = "CSP-ISP")
    @JsonProperty("TIPO_OS")
    private String sotype;
    @Schema(description = "codsrc", example = "A02E5")
    @JsonProperty("COD_SERVICO")
    private String codsrc;
    @Schema(description = "zdesc", example = "TEST")
    @JsonProperty("DESCRICAO_ITEM")
    private String zdesc;
    @Schema(description = "zqty", example = "3")
    @JsonProperty("QUANTIDADE_ITEM")
    private float zqty;
    @Schema(description = "unit", example = "H")
    @JsonProperty("UNIDADE")
    private String unit;
    @Schema(description = "value", example = "120")
    @JsonProperty("VALOR_UNITARIO_ITEM")
    private float value;
    @Schema(description = "totalValue", example = "360")
    @JsonProperty("VALOR_TOTAL_ITEM")
    private float totalValue;
    /* 
    @Schema(description = "ernam", example = "SAPUSR01")
    private String ernam;
    @Schema(description = "erdat", example = "27092023")
    private String erdat;
    @Schema(description = "erzet", example = "182636")
    private String erzet;
    @Schema(description = "aenam", example = "SAPUSR01")
    private String aenam;
    @Schema(description = "aedat", example = "27092023")
    private String aedat;
    @Schema(description = "aezet", example = "183832")
    private String aezet;
    */
}
