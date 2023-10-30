package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0023;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpAvailabIn {
        @Schema(description = "Name of requester system.", example = "Source")
        private String source;
        @Schema(description = "Employee document number.", example = "30311079800")
        private String employeeCPF;
        @Schema(description = "Dealer Code", example = "B05AM99999")
        private String dealerCode;
        List<IFHMBINNOCEANCDPP0023Day>listOfDays;
}
