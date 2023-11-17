package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Chat")
@Getter
@Setter
public class Chat {
    @Schema(description = "Chat Code", example = "CH0006")
    @NotNull @NotBlank @NotEmpty
    private String chatCode;
    @Schema(description = "Date Chat", example = "2023-10-24T15:00:02-0300")
    private String date;
    @Schema(description = "Source Chat", example = "WhatsApp")
    private String source;
    @Schema(description = "Operator Chat", example = "HMBJVICTOR")
    private String operator;

    @JsonProperty("ListOfMessage")
    List<Message> listOfMessage;
}
