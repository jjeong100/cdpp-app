package com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036.Message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDto {

    private int rowId;
    private String chatCode;
    private String date;
    private String source;
    private String operator;

    List<Message> listOfMessage;
}
