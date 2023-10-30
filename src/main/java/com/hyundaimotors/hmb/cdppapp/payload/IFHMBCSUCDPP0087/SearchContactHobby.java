package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchContactHobby")
@Getter
@Setter
public class SearchContactHobby {
    @Schema(description = "Hobby name", example = "Dance")
    @JsonProperty("HobbyDescription")
    private String hobbyDescription;
}
