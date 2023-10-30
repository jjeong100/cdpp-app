package com.hyundaimotors.hmb.cdppapp.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.hyundaimotors.hmb.cdppapp.dto.ApiLogDto;

public interface ApiLogMapper {

    public int insertObject(ApiLogDto dto) throws SQLException;

    public int updateObject(ApiLogDto dto) throws SQLException;

    public int selectSeqNo(@Param("ifTrId") String ifTrId) throws SQLException;
}
