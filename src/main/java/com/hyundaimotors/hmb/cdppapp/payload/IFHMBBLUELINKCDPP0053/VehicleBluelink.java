package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "VehicleBluelink")
@Getter
@Setter
public class VehicleBluelink {
    @Schema(description = "This tag was deactivated. serialNumber should be used instead.", example = "9BHBG51DADP011617")
    @JsonProperty("Chassi")
    private String chassi;
    @Schema(description = "Latest Mileage of Asset", example = "1000")
    @JsonProperty("LatestMileage")
    private String latestMileage;
    @JsonProperty("ListOfBluelink")
    List<Bluelink> ListOfBluelink;
}
