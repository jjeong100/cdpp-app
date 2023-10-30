package com.hyundaimotors.hmb.cdppapp.payload;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBRECLAMEAQUICDPP0096.RetrieveTicketId;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBRECLAMEAQUICDPP0097Payload {
    
    @Schema(name = "IFHMBRECLAMEAQUICDPP0097Payload.Request")
    @Getter
    @Setter
    public static class Request{
        
    }

    @Schema(name = "IFHMBRECLAMEAQUICDPP0097Payload.Response")
    @Getter
    @Setter
    public static class Response{
        private String attachmentLink;
        private String attachmentName;
    }
}
