package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.FileInfoDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0035Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0035Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0035Service;
import com.hyundaimotors.hmb.cdppapp.util.Attachment;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0035ServiceImpl implements IFHMBSAPEAICDPP0035Service{
    
    private final IFHMBSAPEAICDPP0035Mapper mapper;

    public IFHMBSAPEAICDPP0035Dto insertObject(IFHMBSAPEAICDPP0035Dto dto)throws Exception{
        mapper.insertObject(dto);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        // mapper.transferProcess(map);
        
        //mapper.transferReplica(map);
        
        
        /**
         * 파일 저장 (항목 attach_file text)
         */
//        map.put("PARAM_CONTENT",Attachment.uploadFile(dto.getUrl()));
        
        /** dto.getUrl() : file:///D:/작업/0.작업/20231211/IFHMBINNOCEANCDPP0019ServiceImpl.java**/
//        String path = dto.getUrl().replaceAll("/", "\\\\");
//        String path = "D:\\작업\\0.작업\\20231211\\IFHMBINNOCEANCDPP0019ServiceImpl.java";  => lo_import(p_path) 한글 안됨.
        /** dto.getUrl() :  "URL": "D:/IFHMBINNOCEANCDPP0019ServiceImpl.java",
         * 
         *  function bytea나 java의 byte[] 형태나 function 은 폴더에 한글이 안된다. java는 되는데..
         *  **/
        map.put("FILE_PATH", dto.getUrl());
        mapper.transferFile(map);
        
        /** 다운로드 
         * 
         * select 할때 cast(xxx as bytea)로 변경후 조회 한다.
         * **/
        downloadFile(dto);

        IFHMBSAPEAICDPP0035Dto resultDto = new IFHMBSAPEAICDPP0035Dto();
        resultDto.setAttachmentId(dto.getRowId());
        resultDto.setErrorSpcCode("0");
        resultDto.setErrorSpcMessage("OK");
        
        return resultDto;
    }    
    
    /**
     * 
     */
    public void downloadFile(IFHMBSAPEAICDPP0035Dto dto) throws Exception{
    	FileInfoDto fileInfo = mapper.selectFileDownload(dto);
    	
    	System.out.println("■■■■ : "+fileInfo.getAttachFile());
    	
//    	Attachment.writeToFile("IFHMBINNOCEANCDPP0019ServiceImpl.java",fileInfo.getAttachFile());
    	
    	Attachment.SaveFile("D:\\Downloads\\test\\","IFHMBINNOCEANCDPP0019ServiceImpl.java",fileInfo.getAttachFile());
    }

}
