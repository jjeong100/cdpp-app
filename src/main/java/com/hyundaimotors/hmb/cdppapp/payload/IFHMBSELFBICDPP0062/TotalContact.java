package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0062;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "TotalContact")
@Getter
@Setter
public class TotalContact {
    @Schema(description = "Contact birth date. YYYY-MM-DD", example = "1996-02-22")
    @JsonProperty("BirthDate")
    private String birthDate;
    @Schema(description = "Gender.", example = "Male")
    @JsonProperty("Gender")
    private String gender;
    @Schema(description = "If PCD, special condicion", example = "Y")
    @JsonProperty("PCD")
    private String pcd;
    @Schema(description = "Siebel identification", example = "1-5JCWF9")
    @JsonProperty("IdSiebel")
    private String idSiebel;
    @Schema(description = "SuppressAllCalls", example = "Y")
    @JsonProperty("SuppressAllCalls")
    private String suppressAllCalls;
    @Schema(description = "Suppress All Emails", example = "Y")
    @JsonProperty("SuppressAllEmails")
    private String suppressAllEmails;
    @Schema(description = "Suppress All Mailings", example = "Y")
    @JsonProperty("SuppressAllMailings")
    private String suppressAllMailings;
    @Schema(description = "Suppress All Mobile Phone", example = "Y")
    @JsonProperty("SuppressAllMobilePhone")
    private String suppressAllMobilePhone;
    @Schema(description = "Suppress all SMS, Y or N.", example = "Y")
    @JsonProperty("SuppressAllSMS")
    private String suppressAllSMS;
    @Schema(description = "Suppress all VideoCall, Y or N.", example = "Y")
    @JsonProperty("SuppressAllVideoCall")
    private String suppressAllVideoCall;
    @Schema(description = "Suppress all Whatsapp, Y or N.", example = "Y")
    @JsonProperty("SuppressAllWhatsapp")
    private String suppressAllWhatsapp;
}
