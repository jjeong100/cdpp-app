package com.hyundaimotors.hmb.cdppapp.mapper;

import com.hyundaimotors.hmb.cdppapp.dto.bluelinkMileageDto;

public interface BluelinkMapper {
    public bluelinkMileageDto selectProcessBlueLinkInfo(bluelinkMileageDto bluelinkMileage)throws Exception;

    public void updateProcessBlueLink(bluelinkMileageDto bluelinkMileage)throws Exception;

    public bluelinkMileageDto selectReplicaBlueLinkInfo(bluelinkMileageDto bluelinkMileage)throws Exception;

    public void updateReplicaBlueLink(bluelinkMileageDto bluelinkMileage)throws Exception;
}
