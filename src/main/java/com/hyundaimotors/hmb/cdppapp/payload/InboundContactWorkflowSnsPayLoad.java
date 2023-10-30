package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Schema(name = "socialMedia")
@Getter
@Setter
public class InboundContactWorkflowSnsPayLoad {
    @Schema(description = "Social media name. Valid values: Facebook", example = "Facebook")
    @NotNull
    @JsonProperty("Name")
    public String name;
    @Schema(description = "User name in the social media. (not login name, but the display name)", example = "Gianca")
    @NotNull
    @JsonProperty("User")
    public String user;
    @Schema(description = "Social media join date.", example = "1980-10-21")
    @NotNull
    @JsonProperty("JoinDate")
    public String joinDate;
    @Schema(description = "Indicates if customer liked HMB page on facebook. Valid values:true, False", example = "False")
    @NotNull
    @JsonProperty("LikeHMB")
    public String likeHMB;
}
