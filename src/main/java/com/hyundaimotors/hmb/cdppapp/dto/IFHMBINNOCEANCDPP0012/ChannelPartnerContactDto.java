package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0012;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelPartnerContactDto {
    @JsonProperty("IntegrationId")
    private String integrationId;
    @JsonProperty("CPF")
    private String cpf;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Email")
    private String emailAddress;
    @JsonProperty("HomePhone")
    private String homePhone;
    @JsonProperty("WorkPhone")
    private String workPhone;
    @JsonProperty("CellPhone")
    private String cellPhone;
    @JsonProperty("JobTitle")
    private String jobTitle;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("Id")
    private String id;
}
