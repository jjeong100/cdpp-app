package com.hyundaimotors.hmb.cdppapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class bluelinkMileageDto {
    private Long row_id;
    private String chassi;
    private double latestmileage;

}
