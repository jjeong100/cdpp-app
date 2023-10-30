package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0015;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Color")
@Getter
@Setter
public class Color {
    @NotNull
    @Schema(description = "Type", example = "AUTO_EXTERIOR")
    @JsonProperty("Type")
    private String type;
    @Schema(description = "LIC", example = "RAR")
    @JsonProperty("Code")
    private String code;
    @Schema(description = "Value and Language = ENU", example = "TROPIC RED")
    @JsonProperty("description-EM")
    private String descriptionEM;
    @NotNull
    @Schema(description = "Value and Language = PTB", example = "VERMELHO TROPICAL")
    @JsonProperty("description-PT")
    private String descriptionPT;
    @Schema(description = "Low", example = "S")
    @JsonProperty("color_type")
    private String colorType;
    @Schema(description = "High", example = "Solid")
    @JsonProperty("color_description")
    private String colorDescription;

}
