package com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Message")
@Getter
@Setter
public class Message {
    @Schema(description = "Message Code", example = "HMBJVICTOR")
    private String msgCode;
    @Schema(description = "Date Message", example = "2023-10-24T15:00:02")
    private String date;
    @Schema(description = "Sent By Mesage", example = "Bot")
    private String sentBy;
    @Schema(description = "Message ", example = "Voc 00EA pode me perguntar algo ou escolher uma ")
    private String msg;
    @Schema(description = "Status Message", example = "Sent")
    private String msgStatus;
}
