package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0012;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class ChannelPartnerContact {
    @Schema(description = "External system unique identifier.", example = "1-7890WX")
    @JsonProperty("IntegrationId")
    private String integrationId;
    @Schema(description = "Individual's document number (numbers only)", example = "12337343006")
    @JsonProperty("CPF")
    private String cpf;
    @Schema(description = "Contact first name", example = "Jose")
    @NotNull
    @JsonProperty("FirstName")
    private String firstName;
    @Schema(description = "Contact last name", example = "Ciclano")
    @NotNull
    @JsonProperty("LastName")
    private String lastName;
    @Schema(description = "Contact email address.", example = "kilosolution2s@gmail.com")
    @NotNull
    @JsonProperty("Email")
    private String emailAddress;
    @Schema(description = "Contact home phone.", example = "2345678")
    @JsonProperty("HomePhone")
    private String homePhone;
    @Schema(description = "Contact work phone.", example = "3456789")
    @JsonProperty("WorkPhone")
    private String workPhone;
    @Schema(description = "Contact cell phone.", example = "11941319501")
    @JsonProperty("CellPhone")
    private String cellPhone;
    @Schema(description = "Contact job Title", example = "Uniinformed")
    @JsonProperty("JobTitle")
    private String jobTitle;
    @Schema(description = "Dealer Contact Status,  HMBDealerContactStatusonDealer", example = "Active")
    @JsonProperty("Status")
    private String status;
    @Schema(description = "Dealer Contact Note,  HMBDealerContactNotesonDealer", example = "30694501808")
    @JsonProperty("Notes")
    private String notes;
    @Schema(description = "Dealer Contact row_id", example = "1-4O3QLT")
    @JsonProperty("Id")
    private String id;
}
