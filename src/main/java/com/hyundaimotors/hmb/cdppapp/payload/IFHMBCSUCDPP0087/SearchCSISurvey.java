package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchCSISurvey")
@Getter
@Setter
public class SearchCSISurvey {
    @Schema(description = "Unique code for the survey record to be added. A numeric sequence can be used. Connex will automatically concatenate the field source as prefix in this field, to avoid duplicated records from different partners.", example = "0000544697")
    @JsonProperty("integrationId")
    private String integrationId;
    @Schema(description = "Connex asset Id associated with the survey.   Must be a valid Connex id.", example = "1-KS4ZX")
    @JsonProperty("assetId")
    private String assetId;
    @Schema(description = "Asset VIN", example = "9BHBG51DADP011620")
    @JsonProperty("AssetVIN")
    private String assetVin;
    @Schema(description = "Dealer Customer SAP", example = "B05AM19029")
    @JsonProperty("DealerCustomerSAP")
    private String dealerCustomerSap;
    @Schema(description = "Survey date. Format: YYYY-MM-DD", example = "2014-05-16")
    @JsonProperty("Date")
    private String date;
    @Schema(description = "Survey status.", example = "Pesquisado")
    @JsonProperty("status")
    private String status;
    @Schema(description = "Description", example = "Vendas")
    @JsonProperty("Description")
    private String description;
    @Schema(description = "SR Id", example = "1-3KQWVL")
    @JsonProperty("SRId")
    private String srId;
    @Schema(description = "SR Number", example = "9BHBG51DADP011621")
    @JsonProperty("SrNumber")
    private String srNumber;
}
