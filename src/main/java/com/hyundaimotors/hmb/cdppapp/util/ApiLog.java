package com.hyundaimotors.hmb.cdppapp.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.hyundaimotors.hmb.cdppapp.dto.ApiLogDto;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;

public class ApiLog {
    

    public static void logApi(ApiLogService logService,String IF_ID,ApiLogStep step, UUID ifTrUuid, String strJson) {
        logApi(logService, IF_ID, step, ifTrUuid, strJson, null);
    }

    public static void logApi(ApiLogService logService, String IF_ID,ApiLogStep step, UUID ifTrUuid, String strJson, Throwable e) {
        ApiLogDto dto = new ApiLogDto();
        dto.setIfId(IF_ID);
        dto.setIfTrId(ifTrUuid.toString());

        Timestamp now = new Timestamp((new Date()).getTime());
        switch (step) {
            case START:
                dto.setIfRequestAt(now);
                dto.setIfReqJson(strJson);
                break;
            case STEP1:
                dto.setIfStep1At(now);
                break;
            case STEP2:
                dto.setIfStep2At(now);
                break;
            case STEP3:
                dto.setIfStep3At(now);
                break;
            case FINISH:
                dto.setIfResponseAt(new Timestamp((new Date()).getTime()));
                dto.setIfResJson(strJson);
                if (e != null) {
                    dto.setIfErrFlag("Y");
                    dto.setIfErrMsg(ExceptionUtils.getStackTrace(e));
                }
                break;

            default:
                break;
        }
        try {
        	
            logService.writeStepLogging(step, dto);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
            System.out.println("■ "+simpleDateFormat.format(new Date())+" ["+step+"] : "+dto);
        }catch(Exception ex) {
        	System.out.println("err ■ ("+step+")"+dto.getSeqNo());
            //테스트후 삭제 필요.
            ex.printStackTrace();
        }
        
    }
}
