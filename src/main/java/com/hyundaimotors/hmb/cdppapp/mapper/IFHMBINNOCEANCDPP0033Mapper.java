package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.AccountAssetDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.ContactDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.HMBVehicleDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0033.IFHMBINNOCEANCDPP0033Dto;

public interface IFHMBINNOCEANCDPP0033Mapper {
    public List<HMBVehicleDto> getAsset(IFHMBINNOCEANCDPP0033Dto dto)throws Exception;

    public List<ContactDto> getContact(IFHMBINNOCEANCDPP0033Dto dto)throws Exception;

    public List<AccountAssetDto> getAccount(IFHMBINNOCEANCDPP0033Dto dto)throws Exception;
}
