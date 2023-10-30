package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class AccountPayLoad {
    
    @Schema(name = "AccountPayLoad.Request")
    @Getter
    @Setter
    public static class Request{
        @NotNull
		@Schema(description = "Extanal Id", example = "1-7890WX")
        private String integrationId;
        @Schema(description = "CPF Only Number", example = "134135136136")
        private String cpf;
        @Schema(description = "이름", example = "jone")
        private String firstName;
        private String lastName;
        private String birthDate;
        private String gender;
        private String source;
        private String homePhone;
        private String workPhone;
        private String cellPhone;
        private String emailAddress;
        private String wayOfContact;
        private String occupation;
        private String maritalStatus;
        private String income;
        private String carOfInterest;
        private String calledBy;
        private String literacy;
        private String behavioralSegment;
        private String valueSegment;
        private String googleSegment;
        private String facebookSegment;
        private String lifeCycleSegment;
        private String interestSegment;
        private String contactOptIn;
        private String streetAddress;
        private String streetAddress2;
        private String streetAddress3;
        private String county;
        private String city;
        private String state;
        private String postalCode;
        private String suppressAllCalls;
        private String suppressAllMailings;
        private String suppressAllEmails;
        private String suppressAllSMS;
        private String printedCard;
        private String already_customer;
        private List<App> app;
        private List<Car> car;
    }

    @Schema(name = "AccountPayLoad.Response")
    @Getter
    @Setter
    public static class Response {
        @Schema(description = "커넥스 ContactId", example = "1-7890WX")
        private String contactId;
        private String errorSpcCode;
        private String errorSpcMessage;
    }
}
