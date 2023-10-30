package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboundRepairParts {
    @Schema(description = "soid", example = "0002345")
    @JsonProperty("CODIGO_OS")
    private String soid;
    @Schema(description = "dealercode", example = "B05AM12345")
    @JsonProperty("DEALER_CODE")
    private String dealercode;
    @Schema(description = "vincode", example = "9BH12345678901234")
    @JsonProperty("CHASSI")
    private String vincode;
    @Schema(description = "itmnum", example = "0001")
    @JsonProperty("COD_ITEM")
    private String itmnum;
    @Schema(description = "sotype", example = "CSR-GSS")
    @JsonProperty("TIPO_OS")
    private String sotype;
    @Schema(description = "pncode", example = "4300780900")
    @JsonProperty("COD_PRODUTO")
    private String pncode;
    @Schema(description = "zdesc", example = "SHELL HELIX ULTRA AH 5W-30 SN")
    @JsonProperty("DESCRICAO_ITEM")
    private String zdesc;
    @Schema(description = "zqty", example = "2,900")
    @JsonProperty("QUANTIDADE_ITEM")
    private float zqty;
    @Schema(description = "unit", example = "LT")
    @JsonProperty("UNIDADE")
    private String unit;
    @Schema(description = "value", example = "71,70")
    @JsonProperty("VALOR_UNITARIO_ITEM")
    private float value;
    @Schema(description = "total_Value", example = "207,93")
    @JsonProperty("VALOR_TOTAL_ITEM")
    private float totalValue;
    /*
    @Schema(description = "ernam", example = "AXAPIRFC01")
    private String ernam;
    @Schema(description = "erdat", example = "27092023")
    private String erdat;
    @Schema(description = "erzet", example = "183540")
    private String erzet;
    @Schema(description = "aenam", example = "AXAPIRFC01")
    private String aenam;
    @Schema(description = "aedat", example = "27092023")
    private String aedat;
    @Schema(description = "aezet", example = "183753")
    private String aezet;
    */

}
