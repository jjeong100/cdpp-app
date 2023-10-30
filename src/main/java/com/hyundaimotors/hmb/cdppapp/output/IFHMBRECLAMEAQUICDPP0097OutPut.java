package com.hyundaimotors.hmb.cdppapp.output;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBRECLAMEAQUICDPP0097Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBRECLAMEAQUICDPP0097Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBRECLAMEAQUICDPP0097Service;

@EnableScheduling
@Component
public class IFHMBRECLAMEAQUICDPP0097OutPut {
    
    @Autowired
    private IFHMBRECLAMEAQUICDPP0097Service service; 

    // 매 시간 실행 (크론 표현식)
    //@Scheduled(cron = "0 */5 * * * *")
    public void getAttachmentLink() throws ParseException {
        System.out.println("GateWayAttach!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        ModelMapper modelMapper = new ModelMapper();

        String ticketDetailId = "637013269";

        String accessToken = getToken();

        HttpClient client = HttpClient.newHttpClient();
        
        // REST API 엔드포인트 URL 설정
        String apiUrl = "https://apitest.hyundai-brasil.com:8065/integration/reclame-aqui/v1.0/api/ticket/v1/tickets";

        // HTTP 요청 초기화
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl+ticketDetailId))
                .setHeader("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "text/plain")
                .GET()
                .build();

        try {
            // REST API 호출 및 응답 처리
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();

            JSONObject jsonObj = (JSONObject) new JSONParser().parse(responseBody);

            IFHMBRECLAMEAQUICDPP0097Payload.Response payload = new IFHMBRECLAMEAQUICDPP0097Payload.Response();

            
            if(jsonObj.containsKey("attachmentLink"))payload.setAttachmentLink(String.valueOf(jsonObj.get("attachmentLink")));
            if(jsonObj.containsKey("attachmentName"))payload.setAttachmentName(String.valueOf(jsonObj.get("attachmentName")));


            IFHMBRECLAMEAQUICDPP0097Dto dto = new IFHMBRECLAMEAQUICDPP0097Dto();

            dto = modelMapper.map(payload, IFHMBRECLAMEAQUICDPP0097Dto.class);
             
            dto.setTicketDetailId(ticketDetailId);

            service.insertAttachmentLink(dto);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getToken() throws ParseException{
        HttpClient client = HttpClient.newHttpClient();
        String endPoint = "https://apitest.hyundai-brasil.com:8065/integration/v1/oauth/token";
        String params =  "client_id=4217742c-7607-4663-a8eb-c02a8d4dff19&client_secret=78bf43ae-e3f0-4cda-8cb3-326a4766443f&grant_type=client_credentials";
        HttpResponse<String> response;
        String responseBody = "";
        String accessToken = "";
        try {
        
        BodyPublisher body = BodyPublishers.ofString(params);

        System.out.println("Token params: " + params);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPoint))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .POST(body)
                .build();
        
        
        
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        int statusCode = response.statusCode();

        responseBody = response.body();
        
        System.out.println("Token HTTP Status Code: " + statusCode);
        System.out.println("Token Response Body: " + responseBody);
        JSONObject jsonObj = (JSONObject) new JSONParser().parse(responseBody);

        accessToken = String.valueOf(jsonObj.get("access_token"));

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return accessToken;
    }
}
