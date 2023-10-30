package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0033;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Contact")
@Getter
@Setter
public class Contact {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("IntegrationId")
    private String integrationId;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("BirthDate")
    private String birthDate;
    private String document;
    @JsonProperty("Sex")
    private String sex;
    private String personType;
    private String postalCode;
    @JsonProperty("Street")
    private String street;
    private String number;
    private String complement;
    private String county;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("HomePhone")
    private String homePhone;
    @JsonProperty("WorkPhone")
    private String workPhone;
    @JsonProperty("CellPhone")
    private String cellPhone;
    @JsonProperty("EmailAddress")
    private String emailAddress;
    private String relationshipType;
    private String relationshipStatus;
}
