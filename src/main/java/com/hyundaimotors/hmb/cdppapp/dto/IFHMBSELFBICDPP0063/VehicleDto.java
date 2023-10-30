package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDto {
    private String chassi;
    private String salesDate;
    private String salesDealerCode;
    private String salesDealerNick;
    private String salesCode;
    private String salesVersion;
    private String salesFSCOCN;
    private String salesMotor;
    private String vinModel;
    private String vinColor;
    private String updated;
    private String delHome;
    private String digitalSales;
    private String tdHome;
    private String salesCancelled;
    private String assetId;
    List<ContactGetVinDto> ListOfContact;
    List<AccountGetVinDto> ListOfAccount;
}
