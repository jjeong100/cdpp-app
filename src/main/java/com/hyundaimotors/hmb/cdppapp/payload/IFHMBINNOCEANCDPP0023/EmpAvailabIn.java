package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0023;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpAvailabIn {
        @Schema(description = "Name of requester system.", example = "Source")
        @NotNull @NotBlank @NotEmpty
        private String source;
        @Schema(description = "Employee document number.", example = "30311079800")
        @NotNull @NotBlank @NotEmpty
        private String employeeCPF;
        @Schema(description = "Dealer Code", example = "B05AM99999")
        @NotNull @NotBlank @NotEmpty
        private String dealerCode;

        @Valid @NotNull
        List<IFHMBINNOCEANCDPP0023Day>listOfDays;
}
