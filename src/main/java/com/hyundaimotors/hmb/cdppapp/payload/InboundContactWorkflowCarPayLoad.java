package com.hyundaimotors.hmb.cdppapp.payload;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Schema(name = "car")
@Getter
@Setter
public class InboundContactWorkflowCarPayLoad {
    @NotNull
    @Schema(description = "Car name.", example = "HB20")
    @JsonProperty("Name")
    public String name;
    @NotNull
    @Schema(description = "Car model year..", example = "2015")
    @JsonProperty("YearModel")
    public String yearModel;
    @NotNull
    @Schema(description = "Intention to change car. Valid values:Coming soon, From 1 to 3 months, I do not know, 1 Month .", example = "Comimg soon")
    @JsonProperty("IntentionToChange")
    public String intentionToChange;
    @NotNull
    @Schema(description = "Flag to define if the car is customer's current car..", example = "Y")
    @JsonProperty("IsCurrent")
    public String isCurrent;
    @NotNull
    @Schema(description = "Car model.", example = "2015")
    @JsonProperty("CarModel")
    public String carModel;
    @Schema(description = "Car mileage.", example = "1000")
    public int mileage;
    @Schema(description = "Vehicle Client Expected Value information.", example = "5")
    @JsonProperty("ClientExpectedValue")
    public int clientExpectedValue;
}
