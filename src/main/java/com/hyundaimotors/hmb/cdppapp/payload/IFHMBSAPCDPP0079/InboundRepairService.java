package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0079;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboundRepairService {
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
    @Schema(description = "sotype", example = "CSP-ISP")
    @JsonProperty("SOTYPE")
    private String sotype;
    @Schema(description = "codsrc", example = "A02E5")
    @JsonProperty("CODSRC")
    private String codsrc;
    @Schema(description = "zdesc", example = "TEST")
    @JsonProperty("ZDESC")
    private String zdesc;
    @Schema(description = "zqty", example = "3")
    @JsonProperty("ZQTY")
    private float zqty;
    @Schema(description = "value", example = "120")
    @JsonProperty("VALUE")
    private float value;
    @Schema(description = "erdat", example = "20230927")
    @JsonProperty("ERDAT")
    private String erdat;
    @Schema(description = "erzet", example = "182636")
    @JsonProperty("ERZET")
    private String erzet;
    @Schema(description = "aedat", example = "20230927")
    @JsonProperty("AEDAT")
    private String aedat;
    @Schema(description = "aezet", example = "183832")
    @JsonProperty("AEZET")
    private String aezet;
    /* 
    @Schema(description = "ernam", example = "SAPUSR01")
    private String ernam;
    @Schema(description = "itmnum", example = "001")
    @JsonProperty("COD_ITEM")
    private String itmnum;
    @Schema(description = "unit", example = "H")
    @JsonProperty("UNIDADE")
    private String unit;
    @Schema(description = "totalValue", example = "360")
    @JsonProperty("VALOR_TOTAL_ITEM")
    private float totalValue;
    @Schema(description = "aenam", example = "SAPUSR01")
    private String aenam;
    */
}
