package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0088;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0088Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0088Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Unique code for the survey record to be added.A numeric sequence can be used. Connex will automatically concatenate the field source as prefix in this field, to avoid duplicated records from different partners.", example = "0000544697")
        @NotNull @NotBlank @NotEmpty
        private String integrationId;
        @Schema(description = "Connex asset Id associated with the survey.   Must be a valid Connex id.", example = "1-2R8M-518")
        private String assetId;
        @Schema(description = "Connex contact Id associated with the survey., Must be a valid Connex id.", example = "1-LK2UJ")
        private String contactId;
        @Schema(description = "Connex account Id associated with the survey. Must be a valid Connex id.", example = "1-4VKWG9")
        private String accountId;
        @Schema(description = "Connex dealer Id associated with the survey. Must be a valid Connex id.", example = "1-WT-51")
        private String dealerId;
        @Schema(description = "Survey date.Format: YYYY-MM-DD", example = "2014-05-16")
        private String researchDate;
        @Schema(description = "Survey name.", example = "Vendas")
        @NotNull @NotBlank @NotEmpty
        private String researchName;
        @Schema(description = "External source.", example = "AMARO")
        @NotNull @NotBlank @NotEmpty
        private String source;
        @Schema(description = "Survey status.", example = "Pesquisado")
        private String status;
        @Schema(description = "Survey sub status.", example = "*")
        private String substatus;
        @Schema(description = "Overall rating.", example = "100")
        private String ratingAll;
        @Schema(description = "Attendant rating.", example = "100")
        private String ratingAttendant;
        @Schema(description = "Mechanic rating.", example = "100")
        private String ratingMechanic;
        @Schema(description = "SNA code.", example = "947183")
        private String snaCode;
        @Schema(description = "SNA date.Format: YYYY-MM-DD", example = "2014-05-17")
        private String snaDate;
        @Schema(description = "SNA type.", example = "Observação/Sugestão")
        private String snaType;
        @Schema(description = "SNA comment.", example = "A cliente informou que houve demora para fazer a nota fiscal.")
        private String snaComment;
        @Schema(description = "Protocolo", example = "HMB8761468242")
        private String srProtocol;
        @Schema(description = "Serial Number", example = "9BHBG51DADP011621")
        private String serialNumber;
        @Valid @JsonProperty("ListOfAmaroCSISurveyAnswer")
        List<AmaroCSISurveyAnswer> listOfAmaroCSISurveyAnswer;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0088Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String ErrorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String ErrorSpcMessage;
    }
}
