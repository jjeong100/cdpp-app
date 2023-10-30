package com.hyundaimotors.hmb.cdppapp.payload.IFHMBBLUELINKCDPP0091;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBBLUELINKCDPP0091Payload {
    
    @Schema(name = "IFHMBBLUELINKCDPP0091Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "YYYY-MM-DD, Bluelink date to capture.", example = "2023-10-08")
        @JsonProperty("Date_Input")
        private String dateInput;
        @Schema(description = "Vehicle number", example = "9BHBG51DADP011617")
        @JsonProperty("Vin")
        private String vin;

    }

    @Schema(name = "IFHMBBLUELINKCDPP0091Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String ErrorSpcCode;
        @Schema(description = "Returns OK when success.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String ErrorSpcMessage;
        @JsonProperty("ListOfBluelink")
        List<GetBluelink> listOfBluelink;

    }
}
