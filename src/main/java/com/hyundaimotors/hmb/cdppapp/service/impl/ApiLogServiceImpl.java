package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundaimotors.hmb.cdppapp.dto.ApiLogDto;
import com.hyundaimotors.hmb.cdppapp.mapper.ApiLogMapper;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiLogServiceImpl implements ApiLogService {

    private static final Logger logger = LoggerFactory.getLogger(ApiLogServiceImpl.class);

    @Autowired
    private final ApiLogMapper mapper;

    @Override
    public void writeStepLogging(ApiLogStep step, ApiLogDto dto) {
        Timestamp now = new Timestamp((new Date()).getTime());
        int resultCnt = 0;
        try {
            if (!"START".equalsIgnoreCase(step.name()) && dto.getSeqNo() == null)
                dto.setSeqNo(mapper.selectSeqNo(dto.getIfTrId()));

            switch (step) {
                case START:
                    if (dto.getIfRequestAt() == null)
                        dto.setIfRequestAt(now);
                    if (dto.getIfTrId() == null)
                        dto.setIfTrId(UUID.randomUUID().toString());
                    resultCnt = mapper.insertObject(dto);
                    break;
                case FINISH:
                    if (dto.getIfResponseAt() == null)
                        dto.setIfResponseAt(now);
                    resultCnt = mapper.updateObject(dto);
                    break;
                case STEP1:
                    if (dto.getIfStep1At() == null)
                        dto.setIfStep1At(now);
                    resultCnt = mapper.updateObject(dto);
                    break;
                case STEP2:
                    if (dto.getIfStep2At() == null)
                        dto.setIfStep2At(now);
                    resultCnt = mapper.updateObject(dto);
                    break;
                case STEP3:
                    if (dto.getIfStep3At() == null)
                        dto.setIfStep3At(now);
                    resultCnt = mapper.updateObject(dto);
                    break;

                default:
                    resultCnt = mapper.updateObject(dto);
                    break;
            }

        } catch (Exception e) {
            logger.error("ApiLog Error : " + e.getMessage(), e);
        }
    }

}
