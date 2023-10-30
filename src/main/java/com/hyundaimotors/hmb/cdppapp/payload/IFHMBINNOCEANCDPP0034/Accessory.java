package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0034;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Accessory")
@Getter
@Setter
public class Accessory {
    @Schema(description = "Accessory name related with a quote.", example = "Conveni 00EAncia-Rede el 00E1stica para porta-malas")
    private String accessory;
    @Schema(description = "Accessory price related with a quote.", example = "R$92.5700")
    private String accessoryPrice;
}
