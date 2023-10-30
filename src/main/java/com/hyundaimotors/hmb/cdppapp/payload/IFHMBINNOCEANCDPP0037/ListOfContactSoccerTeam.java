package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ListOfContactSoccerTeam")
@Getter
@Setter
public class ListOfContactSoccerTeam {
    @Schema(description = "Soccer team name. Valid values: Ponte Preta", example = "Ponte Preta")
    @NotNull
    private String soccerTeam;
}
