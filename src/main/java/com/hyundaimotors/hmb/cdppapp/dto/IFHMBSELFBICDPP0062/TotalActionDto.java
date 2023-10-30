package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalActionDto {
    private String fstInteraction;
    private String getLead;
    private String leadManagerFlag;
    private String status;
    private String dtEnvio;
    private String dtFechamento;
    private String visitconducted;
    private String visitsched;
    private String visitstat;
    List<TotalTemperatureDto> temperature;
}
