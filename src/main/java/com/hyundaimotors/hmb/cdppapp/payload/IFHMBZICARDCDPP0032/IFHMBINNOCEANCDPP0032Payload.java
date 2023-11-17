package com.hyundaimotors.hmb.cdppapp.payload.IFHMBZICARDCDPP0032;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0032Payload {
    
    @Schema(name = "IFHMBZICARDCDPP0032Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "cpfNumber", example = "21955839832")
        @NotNull @NotBlank @NotEmpty
        private String cpf;

        @Schema(description = "ContactId", example = "proc00236829361")
        @NotNull @NotBlank @NotEmpty
        private String contactId;
    }

    @Schema(name = "IFHMBZICARDCDPP0032Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        
        @JsonProperty("SearchContactTD_Output")
        private List<SearchContactTD> listOfSearchContactTD;        
    }
}
