package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Schema(name = "soccerTeam")
@Getter
@Setter
public class InboundContactWorkflowSoccerTeamPayLoad {
    @NotNull
    @Schema(description = "Soccer team name. Valid values:Ponte Preta", example = "Ponte Preta")
    @JsonProperty("Name")
    public String name; 
}
