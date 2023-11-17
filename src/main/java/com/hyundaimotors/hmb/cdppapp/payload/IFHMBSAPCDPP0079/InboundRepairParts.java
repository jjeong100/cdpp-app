package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboundRepairParts {
    @Schema(description = "soid", example = "0002345")
    @JsonProperty("SO_ID")
    private String soid;
    @Schema(description = "dealercode", example = "B05AM12345")
    @JsonProperty("DEALERCODE")
    private String dealercode;
    @Schema(description = "vincode", example = "9BH12345678901234")
    @JsonProperty("VINCODE")
    private String vincode;
    @Schema(description = "itmnum", example = "001")
    @JsonProperty("COD_ITEM")
    private String itmnum;
    @Schema(description = "sotype", example = "CSR-GSS")
    @JsonProperty("SOTYPE")
    private String sotype;
    @Schema(description = "pncode", example = "4300780900")
    @JsonProperty("PNCODE")
    private String pncode;
    @Schema(description = "zdesc", example = "SHELL HELIX ULTRA AH 5W-30 SN")
    @JsonProperty("ZDESC")
    private String zdesc;
    @Schema(description = "zqty", example = "2,900")
    @JsonProperty("ZQTY")
    private float zqty;
    @Schema(description = "value", example = "71,70")
    @JsonProperty("VALUE")
    private float value;
    @Schema(description = "erdat", example = "20230927")
    @JsonProperty("ERDAT")
    private String erdat;
    @Schema(description = "erzet", example = "183540")
    @JsonProperty("ERZET")
    private String erzet;
    @Schema(description = "aedat", example = "20230927")
    @JsonProperty("AEDAT")
    private String aedat;
    @Schema(description = "aezet", example = "183753")
    @JsonProperty("AEZET")
    private String aezet;    
    /*
    @Schema(description = "ernam", example = "AXAPIRFC01")
    private String ernam;
    @Schema(description = "itmnum", example = "0001")
    @JsonProperty("COD_ITEM")
    private String itmnum;
    @Schema(description = "unit", example = "LT")
    @JsonProperty("UNIDADE")
    private String unit;
    @Schema(description = "total_Value", example = "207,93")
    @JsonProperty("VALOR_TOTAL_ITEM")
    private float totalValue;
    @Schema(description = "aenam", example = "AXAPIRFC01")
    private String aenam;
    
    
    */

}
