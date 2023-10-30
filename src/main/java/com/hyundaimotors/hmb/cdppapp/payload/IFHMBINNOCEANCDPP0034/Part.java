package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0034;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Part")
@Getter
@Setter
public class Part {
    @Schema(description = "Part backorder date. Format: MM/DD/YYYY ", example = "2023-10-24T15:00:02")
    private String backOrderDate;
    @Schema(description = "Flag to define if part have backorder. Valid values: Y, N", example = "Y")
    private String backOrderFlg;
    @Schema(description = "Part backorder number.", example = "238729")
    private String backOrderNum;
    @Schema(description = "Part backorder status.", example = "Ativos")
    private String backOrderStatus;
    @Schema(description = "Part unique code.", example = "084A510043EB")
    private String partCode;
    @Schema(description = "Part description.", example = "PROTETOR DE PORTA")
    private String partDescription;
}
