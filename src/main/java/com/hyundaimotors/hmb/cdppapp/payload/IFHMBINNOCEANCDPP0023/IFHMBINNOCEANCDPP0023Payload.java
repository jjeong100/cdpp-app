package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0023;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0023Payload {
    @Schema(name = "IFHMBINNOCEANCDPP0023Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Valid @NotNull  
        EmpAvailabIn empAvailabIn;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0023Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Returns 0 when success.", example = "0")
        private String errorSpcCode;
        @Schema(description = "Returns OK when success.", example = "OK")
        private String errorSpcMessage;

    }
}
