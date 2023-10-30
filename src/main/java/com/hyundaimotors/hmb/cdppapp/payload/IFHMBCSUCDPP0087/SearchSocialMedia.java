package com.hyundaimotors.hmb.cdppapp.payload.IFHMBCSUCDPP0087;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "SearchSocialMedia")
@Getter
@Setter
public class SearchSocialMedia {
    @Schema(description = "Social media name. Valid values: Facebook", example = "Facebook")
    @JsonProperty("SocialMediaName")
    private String socialMediaName;
    @Schema(description = "User name in the social media. (not login name, but the display name)", example = "Gianca")
    @JsonProperty("SocialMediaUser")
    private String socialMediaUser;
    @Schema(description = "Source City", example = "Brasil")
    @JsonProperty("SourceCity")
    private String sourceCity;
}
