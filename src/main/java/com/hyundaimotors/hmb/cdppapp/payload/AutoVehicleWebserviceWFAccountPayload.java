package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AutoVehicleWebserviceWFAccountPayload {
    @Schema(description = "Connex account id.", example = "1-4VKWG9")
    @NotNull
    @JsonProperty("ConnexAccountId")
    public String connexAccountId;
    @Schema(description = "Relationship type between asset and account. Valid values: Assignee, Driver, Family, First owner, Mechanic, Other, Owner, Unspecified.", example = "Owner")
    @JsonProperty("Type")
    public String accountType;
    @Schema(description = "Status of the relationship between asset and account. Valid values: Active, Inactive.", example = "Active")
    @JsonProperty("status")
    public String accountStatus;
}
