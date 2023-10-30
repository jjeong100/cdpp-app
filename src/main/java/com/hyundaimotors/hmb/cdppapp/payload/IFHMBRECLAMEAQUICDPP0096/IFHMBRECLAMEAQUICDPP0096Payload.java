package com.hyundaimotors.hmb.cdppapp.payload.IFHMBRECLAMEAQUICDPP0096;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBRECLAMEAQUICDPP0096Payload {
    
    @Schema(name = "IFHMBRECLAMEAQUICDPP0096Payload.Request")
    @Getter
    @Setter
    public static class Request{
        
    }

    @Schema(name = "IFHMBRECLAMEAQUICDPP0096Payload.Response")
    @Getter
    @Setter
    public static class Response{
        List<RetrieveTicketId> data;
    }
}
