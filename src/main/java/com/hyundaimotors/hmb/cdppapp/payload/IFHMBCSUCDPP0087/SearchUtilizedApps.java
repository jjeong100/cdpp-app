package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchUtilizedApps")
@Getter
@Setter
public class SearchUtilizedApps {
    @Schema(description = "App name download by customer. Valid values: HB20", example = "HB20")
    @JsonProperty("Name")
    private String name;
    @Schema(description = "Download date. Format: YYYY-MM-DD", example = "1980-10-21")
    @JsonProperty("StartDate")
    private String startDate;
    @Schema(description = "Flag to inform if app is still active or was removed by customer. Valid values: Y, N", example = "Y")
    @JsonProperty("Status")
    private String status;
}
