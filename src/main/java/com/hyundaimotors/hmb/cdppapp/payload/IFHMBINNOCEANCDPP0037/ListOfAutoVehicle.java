package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ListOfAutoVehicle")
@Getter
@Setter
public class ListOfAutoVehicle {
    @Schema(description = "Asset Id", example = "1-1DL-53")
    @NotNull @NotBlank @NotEmpty
    @JsonProperty("VehicleId")
    private String vehicleId;
    @Schema(description = "Relationship Status", example = "Owner")
    @JsonProperty("RelashionshipStatus")
    private String relationshipStatus;
    @Schema(description = "Renavam Code", example = "497269414")
    @JsonProperty("HMBRenavamCode")
    private String hmbRenavamCode;
    @Schema(description = "Curren Mileage", example = "24350.0")
    @JsonProperty("CurrenMileage")
    private int currentMileage;
    @Schema(description = "Vehicle License Number", example = "FGZ 4544")
    @JsonProperty("VehicleLicenseNumber")
    private String vehicleLicenseNumber;

}
