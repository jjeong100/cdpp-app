package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ActionProducts")
@Getter
@Setter
public class ActionProducts {
    @Schema(description = "Action Product Part Id", example = "1-G01ZTV")
    private String partId;
    @Schema(description = "Action Product Part Quantity", example = "10")
    private String partQty;
}
