package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0063;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSELFBICDPP0063Payload {
    
    @Schema(name = "IFHMBSELFBICDPP0063Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "MM/DD/YYYY, billing date to capture.", example = "2018-10-30")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("date")
        private String dateInput;

        @Schema(description = "Y or N. If you select Y, then Siebel will get all VIN searching them by Created Field. If you select N, then Siebel will get all VIN searching them by Sales date field.", example = "Y")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("created")
        private String createdOption;
        
        @Schema(description = "1=All Sales, 2=Different from Direct Sales, 3=Direct Sales", example = "1")
        @NotNull @NotBlank @NotEmpty
        private String seq;
        @Schema(description = "Vehicle number", example = "9BHGA811BKP099943")
        private String vin;
    }
    
    @Schema(name = "IFHMBSELFBICDPP0063Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "errorSpcCode", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "errorSpcMessage", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @JsonProperty("Vehicle")
        List<Vehicle> ListOfVehicle;
    }
}
