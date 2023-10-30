package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "ListOfContactHobby")
@Getter
@Setter
public class ListOfContactHobby {
    @Schema(description = "Hobby name", example = "Dance")
    @NotNull
    private String hobbyDescription;
}
