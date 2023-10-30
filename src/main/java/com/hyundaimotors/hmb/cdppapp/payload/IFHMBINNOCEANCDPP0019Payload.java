package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class IFHMBINNOCEANCDPP0019Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0019Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Dealer Code", example = "B05AM19023")
        @JsonProperty("dealer-code")
        private String dealerCode;
        @Schema(description = "Year to search for calendar availability, Format: YYYY", example = "2017")
        private String year;
        @Schema(description = "Month to search for calendar availability", example = "11")
        private String month;
        @Schema(description = "Name of requester system.", example = "Source")
        @JsonProperty("Source")
        private String source;

    }

    @Schema(name = "IFHMBINNOCEANCDPP0019Payload.Response")
    @Getter
    @Setter
    @SuperBuilder
    public static class Response{
        @Schema(description = "Returns 0 when success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Returns OK when success.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        List<ListOfDays> listOfDays;
    }

    @Schema(name = "ListOfDays")
    @Getter
    @Setter
    public static class ListOfDays{
        @Schema(description = "Day number", example = "06")
        private String description;
        @Schema(description = "Day availability flag, containing Y or N.", example = "Y")
        private String available;
    }
}
