package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchServiceRequestContact")
@Getter
@Setter
public class SearchServiceRequestContact {
    @JsonProperty("SRCreated")
    private String srCreated;
    @JsonProperty("SRNumber")
    private String srNumber;
    @JsonProperty("DealerCode")
    private String dealerCode;
    @JsonProperty("ModelCar")
    private String modelCar;
    @JsonProperty("VehicleVersion")
    private String vehicleVersion;
    @JsonProperty("VehicleColor")
    private String vehicleColor;
    @JsonProperty("EngTrans")
    private String engTrans;
    @JsonProperty("Area")
    private String area;

}
