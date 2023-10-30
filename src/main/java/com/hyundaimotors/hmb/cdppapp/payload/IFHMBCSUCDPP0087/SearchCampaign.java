package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchCampaign")
@Getter
@Setter
public class SearchCampaign {
    @Schema(description = "Campaign Id", example = "1-1VBS2K")
    @JsonProperty("CampaignId")
    private String campaignId;
    @Schema(description = "Type", example = "Marketing Campaign")
    @JsonProperty("Type")
    private String type;
    @Schema(description = "Campaign Name", example = "HMB Evento After Sales BH")
    @JsonProperty("CampaignName")
    private String campaignName;
}
