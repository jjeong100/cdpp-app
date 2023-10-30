package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SynergyActionAudit")
@Getter
@Setter
public class SynergyActionAudit {
    @Schema(description = "Action Audit Name", example = "1-G01ZXG")
    private String fieldName;
    @Schema(description = "Action Audit Vallue", example = "N00E3o")
    private String fieldValue;
}
