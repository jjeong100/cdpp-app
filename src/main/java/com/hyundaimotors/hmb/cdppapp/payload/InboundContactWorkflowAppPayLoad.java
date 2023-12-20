package com.hyundaimotors.hmb.cdppapp.payload;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Schema(name = "app")
@Getter
@Setter
public class InboundContactWorkflowAppPayLoad {
    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "App name download by customer. Valid values:HB20", example = "HB20")
    @JsonProperty("Name")
    public String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Download date. Format: MM/DD/YYYY", example = "1980-10-21")
    @JsonProperty("StartDate")
    public String startDate;
    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Flag to inform if app is still active or was removed by customer. Valid values: Y, N", example = "Y")
    @JsonProperty("Status")
    public String status;
}
