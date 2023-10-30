package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0023;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "IFHMBINNOCEANCDPP0023Day")
@Getter
@Setter
public class IFHMBINNOCEANCDPP0023Day {
    @Schema(description = "Day name. Possible values are: Sunday ~ Saturday ", example = "Friday")
    @JsonProperty("day-name")
    private String dayName;
    @Schema(description = "First working period start time. Format: HH:MM:SS", example = "2017-11-15 08:00:00 AM")
    private String period1Start;
    @Schema(description = "Second working period end time. Format: HH:MM:SS", example = "2017-11-15 12:00:00 AM")
    private String period1End;
    @Schema(description = "Second working period start time. Format: HH:MM:SS", example = "2017-11-15 14:00:00 PM")
    private String period2Start;
    @Schema(description = "Second working period end time. Format: HH:MM:SS", example = "2017-11-15 18:00:00 PM")
    private String period2End;
    @Schema(description = "Third working period start time. Format: HH:MM:SS", example = "2017-11-15 20:00:00 PM")
    private String period3Start;
    @Schema(description = "Third working period end time. Format: HH:MM:SS", example = "2017-11-15 22:00:00 PM")
    private String period3End;
}
