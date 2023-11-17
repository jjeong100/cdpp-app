package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0034;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Part")
@Getter
@Setter
public class Part {
    @Schema(description = "Part backorder date. Format: MM/DD/YYYY ", example = "2023-10-24T15:00:02")
    private String backOrderDate;
    @Schema(description = "Flag to define if part have backorder. Valid values: Y, N", example = "Y")
    @NotNull @NotBlank @NotEmpty
    private String backOrderFlg;
    @Schema(description = "Part backorder number.", example = "238729")
    private String backOrderNum;
    @Schema(description = "Part backorder status.", example = "Ativos")
    private String backOrderStatus;
    @Schema(description = "Part unique code.", example = "084A510043EB")
    @NotNull @NotBlank @NotEmpty
    private String partCode;
    @Schema(description = "Part description.", example = "PROTETOR DE PORTA")
    @NotNull @NotBlank @NotEmpty
    private String partDescription;
}
