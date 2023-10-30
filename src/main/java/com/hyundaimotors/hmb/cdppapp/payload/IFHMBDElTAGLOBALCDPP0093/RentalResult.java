package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDElTAGLOBALCDPP0093;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalResult {
    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Rental Request No.", example = "RRN-202310-0013")
    @JsonProperty("Name")
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Rental Status", example = "Confirmed")
    @JsonProperty("Rental_Status")
    private String rentalStatus;
    @Schema(description = "Delta Protocol Number", example = " ")
    @JsonProperty("DeltaProtocolNumber")
    private String deltaProtocolNumber;
    @Schema(description = "Confirmed Model of Rental Car", example = "Volkswagen Polo")
    @JsonProperty("ConfirmedModelofRentalCar")
    private String confirmedModelofRentalCar;
    @Schema(description = "Confirmed Rental Start Date", example = "2023-10-12")
    @JsonProperty("ConfirmedRentalStartDate")
    private String confirmedRentalStartDate;
    @Schema(description = "Confirmed Rental End Date", example = "2023-10-20")
    @JsonProperty("ConfirmedRentalEndDate")
    private String confirmedRentalEndDate;
}
