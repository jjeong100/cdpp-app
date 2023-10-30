package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0062;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "TotalAction")
@Getter
@Setter
public class TotalAction {
    @Schema(description = "yyyy-MM-ddThh24:mi:ssZ", example = "2020-05-02T08:07:46-0300")
    private String fstInteraction;
    @Schema(description = "Get Lead date, yyyy-MM-DDThh24:mi:ssZ", example = "2020-05-01T13:16:09-0300")
    @JsonProperty("GetLead")
    private String getLead;
    @Schema(description = "WebMotors DMS = “Y” or “N”", example = "Y")
    @JsonProperty("LeadManagerFlag")
    private String leadManagerFlag;
    @Schema(description = "Action Status", example = "Done")
    @JsonProperty("Status")
    private String status;
    @Schema(description = "Sent date for Score", example = "2020-05-01T13:13:26-0300")
    @JsonProperty("dt_envio")
    private String dtEnvio;
    @Schema(description = "Lead Closed date", example = "2020-05-01T13:13:26-0300")
    @JsonProperty("dt_fechamento")
    private String dtFechamento;
    @Schema(description = "Conducted Visit date on dealer", example = "2020-05-01T13:13:26-0300")
    private String visitconducted;
    @Schema(description = "Scheduled Visit date on dealer", example = "2020-05-01T13:13:26-0300")
    private String visitsched;
    @Schema(description = "Visit on dealer status", example = "2020-05-01T13:13:26-0300")
    private String visitstat;
    @JsonProperty("Temperature")
    List<TotalTemperature> temperature;
}
