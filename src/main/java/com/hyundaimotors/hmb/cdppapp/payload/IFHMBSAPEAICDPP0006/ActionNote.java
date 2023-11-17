package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ActionNote")
@Getter
@Setter
public class ActionNote {
    @Schema(description = "Action Note type", example = "Vendedor")
    private String noteType;
    @Schema(description = "Action Note date", example = "2023-10-20T15:14:33-0300")
    private String noteDate;
    @Schema(description = "Action Note Description", example = "<Long>")
    private String noteDescription;
    @Schema(description = "Action Note Creator", example = "HMBDEALER")
    private String noteCreator;
}
