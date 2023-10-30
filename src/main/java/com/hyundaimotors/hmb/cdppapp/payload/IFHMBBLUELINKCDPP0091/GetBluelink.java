package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0091;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBluelink {
    @Schema(description = "Vehicle number", example = "9BHCP51BBNP343387")
        @JsonProperty("AssetNum")
    private String assetNum;
    @Schema(description = "YYYY-MM-DD hh24:mi:ss, billing date", example = "0")
        @JsonProperty("AssetDate")
    private String assetDate;
    @Schema(description = "Bluelink Type", example = "ENROLLMENT (VIA TMU)")
        @JsonProperty("Type")
    private String type;
    @Schema(description = "If the event is related to FirstActivation or not.", example = "N")
        @JsonProperty("FirstActivation")
    private String firstActivation;
    @Schema(description = "Bluelink Event Date", example = "08/14/2022 23:05:40")
        @JsonProperty("EventDate")
    private String eventDate;
}
