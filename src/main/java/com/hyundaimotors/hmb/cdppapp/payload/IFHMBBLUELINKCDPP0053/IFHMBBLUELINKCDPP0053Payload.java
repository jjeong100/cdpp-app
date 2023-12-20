package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0053;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBBLUELINKCDPP0053Payload {
    
    @Schema(name = "IFHMBBLUELINKCDPP0053Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "This tag was deactivated. serialNumber should be used instead.", example = "9BHBG51DADP011617")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("Chassi")
        private String chassi;
        @Schema(description = "Latest Mileage of Asset", example = "1000")
        @JsonProperty("LatestMileage")
        private String latestMileage;
        @JsonProperty("ListOfBluelink")
        List<Bluelink> listOfBluelink;
    }

    @Schema(name = "IFHMBBLUELINKCDPP0053Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;

    }
}
