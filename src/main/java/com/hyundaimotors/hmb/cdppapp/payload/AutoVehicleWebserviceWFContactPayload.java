package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AutoVehicleWebserviceWFContactPayload {
    @Schema(description = "Connex contact id., HKME Asset Contact Id", example = "1-U1V4")
    @NotNull
    @JsonProperty("ConnexContactId")
    public String connexContactId;
    @Schema(description = "Relationship type between asset and contact. Valid values: Assignee, Driver, Family, First owner, Mechanic, Other, Owner, Unspecified.", example = "Driver")
    @JsonProperty("Type")
    public String contactType;
    @Schema(description = "Status of the relationship between asset and contact. Valid values: Active, Inactive.", example = "Active")
    @JsonProperty("status")
    public String contactStatus;
    @Schema(description = "Is Buyer Employee Flag? Valid values: Y, N.", example = "Y")
    public String employee;
    
}
