package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0013;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "IFHMBINNOCEANCDPP0013Contact")
@Getter
@Setter
public class ListOfContacts {
    @Schema(description = "External system unique identifier. HMBDealerContactIntegrationId", example = "73522541960")
    private String integrationId;
    @Schema(description = "Individual's document number (numbers only), HMBDealerContactCPF", example = "73522541960")
    private String cpf;
    @Schema(description = "Dealer Contact first name, HMBDealerContactFirstName", example = "MARQUITO")
    @NotNull @NotBlank @NotEmpty
    private String firstName;
    @Schema(description = "Dealer Contact last name, HMBDealerContactLasttName", example = "DAS FLORES")
    @NotNull @NotBlank @NotEmpty
    private String lastName;
    @Schema(description = "Dealer Contact email address. HMBDealerContactEmail", example = "MARQUITO.FLORES@ABRAOREZE.COM.BR")
    @NotNull @NotBlank @NotEmpty
    private String emailAddress;
    @Schema(description = "Dealer Contact home phone. HMBDealerContactHomePhone", example = "+55(15)30349000")
    private String homePhone;
    @Schema(description = "Dealer Contact work phone. HMBDealerContactWorkPhone", example = "3456789")
    private String workPhone;
    @Schema(description = "Dealer Contact job Title, HMBDealerContactJobTitle", example = "Sales Consultant")
    private String jobTitle;
    @Schema(description = "Dealer Contact Note,  HMBDealerContactNotesonDealer", example = "30694501808")
    private String notes;
    @Schema(description = "Dealer Contact Status,  HMBDealerContactStatusonDealer", example = "Active")
    private String status;

}
