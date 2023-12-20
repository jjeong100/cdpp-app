package com.hyundaimotors.hmb.cdppapp.output;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBRECLAMEAQUICDPP0096.IFHMBRECLAMEAQUICDPP0096Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBRECLAMEAQUICDPP0096.IFHMBRECLAMEAQUICDPP0096Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBRECLAMEAQUICDPP0096.RetrieveTicketId;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBRECLAMEAQUICDPP0096Service;

@EnableScheduling
@Component
public class IFHMBRECLAMEAQUICDPP0096OutPut {
    
    @Autowired
    private IFHMBRECLAMEAQUICDPP0096Service service; 
    
    private ModelMapper defaultMapper;

    // 매 시간 실행 (크론 표현식) 
    //@Scheduled(cron = "0 */5 * * * *")
    public void getAllTicket() throws ParseException {
        
        ModelMapper modelMapper = new ModelMapper();

        String accessToken = getToken();
        
        // 현재 날짜 구하기(Paris)
        LocalDate brazilNow = LocalDate.now(ZoneId.of("America/Sao_Paulo"));

        String brazilDate = "?date=\'"+brazilNow+"\'";
        
        // REST API 호출 및 데이터 처리 로직
        HttpClient client = HttpClient.newHttpClient();
        
        // REST API 엔드포인트 URL 설정
        String apiUrl = "https://apitest.hyundai-brasil.com:8065/integration/reclame-aqui/v1.0/api/ticket/v1/tickets";

        // HTTP 요청 초기화
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl+brazilDate))
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

            JSONArray jsonArr = (JSONArray) jsonObj.get("data");

            List<RetrieveTicketId> ticketList = new ArrayList<RetrieveTicketId>();
            for(Object arr : jsonArr) {
                JSONObject obj = (JSONObject) arr;

                RetrieveTicketId retrieveTicketId = new RetrieveTicketId();
                JSONObject hugmeStatus;
                JSONObject raStatus;
                JSONObject favorableAssessment;
                JSONObject informationSource;
                JSONObject source;
                JSONObject company;
                JSONObject lastFeeling;
                JSONObject feedType;
                JSONObject moderation;
                JSONObject ra;
                JSONObject user;
                JSONObject account;
                JSONObject rafone;
                JSONObject interactions;
                JSONObject customer;
                JSONObject customerName;
                JSONObject attach;

                if(obj.containsKey("hugme_status")){
                    hugmeStatus = (JSONObject) obj.get("hugme_status");
                    if(hugmeStatus.containsKey("name"))retrieveTicketId.setHugmeStatus(String.valueOf(hugmeStatus.get("name")));
                }

                if(obj.containsKey("ra_status")){
                    raStatus = (JSONObject) obj.get("ra_status");
                    if(raStatus.containsKey("name"))retrieveTicketId.setRaStatus(String.valueOf(raStatus.get("name")));
                }

                if(obj.containsKey("favorable_assessment")){
                    favorableAssessment = (JSONObject) obj.get("favorable_assessment");
                    if(favorableAssessment.containsKey("description"))retrieveTicketId.setFavorableAssessment(String.valueOf(favorableAssessment.get("description")));
                }

                if(obj.containsKey("information_source")){
                    informationSource = (JSONObject) obj.get("information_source");
                    if(informationSource.containsKey("name"))retrieveTicketId.setInformationSource(String.valueOf(informationSource.get("name")));
                }

                if(obj.containsKey("source")){
                    source = (JSONObject) obj.get("source");
                    if(source.containsKey("name"))retrieveTicketId.setSource(String.valueOf(source.get("name")));
                }

                if(obj.containsKey("company")){
                    company = (JSONObject) obj.get("company");
                    if(company.containsKey("name"))retrieveTicketId.setCompany(String.valueOf(company.get("name")));
                }

                if(obj.containsKey("last_feeling")){
                    lastFeeling = (JSONObject) obj.get("last_feeling");
                    if(lastFeeling.containsKey("name"))retrieveTicketId.setLastFeeling(String.valueOf(lastFeeling.get("name")));
                }

                if(obj.containsKey("feed_type")){
                    feedType = (JSONObject) obj.get("feed_type");
                    if(feedType.containsKey("name"))retrieveTicketId.setFeedType(String.valueOf(feedType.get("name")));
                }

                if(obj.containsKey("moderation")){
                    moderation = (JSONObject) obj.get("moderation");
                    if(moderation.get("status") != null){
                        if(moderation.containsKey("status"))retrieveTicketId.setModerationStatus(String.valueOf(moderation.get("status")));
                    }

                    if(moderation.get("reason") != null){
                        if(moderation.containsKey("reason"))retrieveTicketId.setModerationReason(String.valueOf(moderation.get("reason")));
                    }

                    if(moderation.get("request_date") != null){
                        if(moderation.containsKey("request_date")&& moderation.containsValue("request_date"))retrieveTicketId.setModerationRequestDate(String.valueOf(moderation.get("request_date")));
                    }
                    
                    if(moderation.get("response_date") != null){
                        if(moderation.containsKey("response_date")&& moderation.containsValue("response_date"))retrieveTicketId.setModerationResponseDate(String.valueOf(moderation.get("response_date")));
                    }
                }
                
                if(obj.containsKey("ra")){
                    ra = (JSONObject) obj.get("ra");
                    if(ra.containsKey("replicas_count"))retrieveTicketId.setReplicasCount(Integer.parseInt(String.valueOf(ra.get("replicas_count"))));
                    if(ra.containsKey("source_id"))retrieveTicketId.setSourceId(Integer.parseInt(String.valueOf(ra.get("source_id"))));
                    if(ra.containsKey("source_name"))retrieveTicketId.setSourceName(String.valueOf(ra.get("source_name")));
                    if(ra.containsKey("deactivation_date"))retrieveTicketId.setDeactivationDate(String.valueOf(ra.get("deactivation_date")));
                    if(ra.containsKey("deactivation_reason"))retrieveTicketId.setDeactivationReason(String.valueOf(ra.get("deactivation_reason")));
                    if(ra.containsKey("internal_process"))retrieveTicketId.setInternalProcess(String.valueOf(ra.get("internal_process")));
                    if(ra.containsKey("blackfriday"))retrieveTicketId.setBlackFriday(String.valueOf(ra.get("blackfriday")));
                }
                
                if(obj.containsKey("user")){
                    user = (JSONObject) obj.get("user");
                    if(user.containsKey("name"))retrieveTicketId.setUserName(String.valueOf(user.get("name")));
                    if(user.containsKey("assignment_date"))retrieveTicketId.setUserAssignmentDate(String.valueOf(user.get("assignment_date")));
                }

                if(obj.containsKey("account")){
                    account = (JSONObject) obj.get("account");
                    if(account.containsKey("name"))retrieveTicketId.setAccount(String.valueOf(account.get("name")));
                }
                if(obj.containsKey("rafone")){
                    rafone = (JSONObject) obj.get("rafone");
                    if(rafone.containsKey("expiration_date"))retrieveTicketId.setRafoneExpirationDate(String.valueOf(rafone.get("expiration_date")));
                    if(rafone.containsKey("status_id"))retrieveTicketId.setRafoneStatusId(String.valueOf(rafone.get("status_id")));
                    if(rafone.containsKey("status_name"))retrieveTicketId.setRafoneStatusName(String.valueOf(rafone.get("status_name")));
                }
                JSONArray attached = (JSONArray) obj.get("attached");
                if(0 < attached.size()){
                    attach = (JSONObject)attached.get(0);
                    if(attach.containsKey("detail_description"))retrieveTicketId.setDetailDescription(String.valueOf(attach.get("detail_description")));
                    if(attach.containsKey("creation_date"))retrieveTicketId.setAttachCreationDate(String.valueOf(attach.get("creation_date")));
                    if(attach.containsKey("name"))retrieveTicketId.setAttachName(String.valueOf(attach.get("name")));
                    if(attach.containsKey("id"))retrieveTicketId.setAttachId(String.valueOf(attach.get("id")));
                }
                JSONArray jsonInteractions = (JSONArray) obj.get("interactions");
                if(0 < jsonInteractions.size()){
                    interactions = (JSONObject)jsonInteractions.get(jsonInteractions.size()-1);
                    if(interactions.containsKey("ticket_interaction_id"))retrieveTicketId.setTicketInteractionId(String.valueOf(interactions.get("ticket_interaction_id")));
                    if(interactions.containsKey("ticket_interaction_type_id")){
                        retrieveTicketId.setTicketInteractionTypeId(Integer.parseInt(String.valueOf(interactions.get("ticket_interaction_type_id"))));
                        if(1 == retrieveTicketId.getTicketInteractionTypeId()){
                            if(obj.containsKey("complaint_content"))retrieveTicketId.setComplaintContent(String.valueOf(obj.get("complaint_content")));
                            //retrieveTicketId.setMessage("Manifestation answer");
                        }else if(2 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Answer");
                        }else if(3 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Private Message - Company");
                        }else if(4 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Tweet");
                        }else if(5 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Facebook Post");
                        }else if(6 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Private Message - Consumer");
                        }else if(7 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Third Party Comment");
                        }else if(8 == retrieveTicketId.getTicketInteractionTypeId()){
                            retrieveTicketId.setRaModerationRequestMessage("Mediation Request");
                            //if(interactions.containsKey("message"))retrieveTicketId.setRaModerationRequestMessage(String.valueOf(interactions.get("message")));
                            //retrieveTicketId.setMessage("Mediation Request");
                        }else if(9 == retrieveTicketId.getTicketInteractionTypeId()){
                            retrieveTicketId.setRaModerationResponseMessage("Mediation Response");
                            //if(interactions.containsKey("message"))retrieveTicketId.setRaModerationResponseMessage(String.valueOf(interactions.get("message")));
                            //retrieveTicketId.setMessage("Mediation Response");
                        }else if(10 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Redistribution");
                        }else if(11 == retrieveTicketId.getTicketInteractionTypeId()){
                        	int temp = retrieveTicketId.getTicketInteractionTypeId();
                            //retrieveTicketId.setMessage("Evaluation");
                        }
                    }
                    //if(interactions.containsKey("ticket_interaction_name"))retrieveTicketId.setTicketInteractionName(String.valueOf(interactions.get("ticket_interaction_name")));
                    if(interactions.containsKey("customer_id"))retrieveTicketId.setCustomerId(String.valueOf(interactions.get("customer_id")));
                    if(interactions.containsKey("responsible_id"))retrieveTicketId.setResponsibleId(String.valueOf(interactions.get("responsible_id")));
                    if(interactions.containsKey("responsible_name"))retrieveTicketId.setResponsibleId(String.valueOf(interactions.get("responsible_name")));
                    if(interactions.containsKey("privacy"))retrieveTicketId.setPrivacy(String.valueOf(interactions.get("privacy")));
                    if(interactions.containsKey("creation_date"))retrieveTicketId.setInteractionCreationDate(String.valueOf(interactions.get("creation_date")));
                    if(interactions.containsKey("modification_date"))retrieveTicketId.setModificationDate(String.valueOf(interactions.get("modification_date")));
                    if(interactions.containsKey("delivered"))retrieveTicketId.setDelivered(String.valueOf(interactions.get("delivered")));
                    if(interactions.containsKey("readed"))retrieveTicketId.setReaded(String.valueOf(interactions.get("readed")));
                    if(interactions.containsKey("visualized"))retrieveTicketId.setVisualized(String.valueOf(interactions.get("visualized")));
                    if(interactions.containsKey("video"))retrieveTicketId.setVideo(String.valueOf(interactions.get("video")));
                    if(interactions.containsKey("picture"))retrieveTicketId.setPicture(String.valueOf(interactions.get("picture")));
                }

                if(obj.containsKey("customer")){
                    customer = (JSONObject) obj.get("customer");
                    JSONArray birthday = (JSONArray) customer.get("birthday");
                    if(0 < birthday.size()){
                        retrieveTicketId.setBirthday(String.valueOf(birthday.get(0)));
                    }
                    JSONArray cpf = (JSONArray) customer.get("cpf");
                    if(0 < cpf.size()){
                        retrieveTicketId.setCpf(String.valueOf(cpf.get(0)));
                    }
                    JSONArray rg = (JSONArray) customer.get("cpf");
                    if(0 < rg.size()){
                        retrieveTicketId.setRg(String.valueOf(rg.get(0)));
                    }
                    JSONArray gender = (JSONArray) customer.get("gender");
                    if(0 < gender.size()){
                        retrieveTicketId.setGender(String.valueOf(gender.get(0)));
                    }
                    JSONArray email = (JSONArray) customer.get("email");
                    if(0 < email.size()){
                        retrieveTicketId.setEmail(String.valueOf(email.get(0)));
                    }
                    JSONArray phoneNumbers = (JSONArray) customer.get("phone_numbers");
                    if(0 < phoneNumbers.size()){
                        retrieveTicketId.setPhoneNumbers(String.valueOf(phoneNumbers.get(0)));
                    }

                    JSONArray state = (JSONArray) customer.get("state");
                    if(0 < state.size()){
                        JSONObject adressState = (JSONObject)state.get(0);
                        if(adressState.containsKey("name"))retrieveTicketId.setAddressState(String.valueOf(adressState.get("name")));
                    }

                    JSONArray city = (JSONArray) customer.get("city");
                    if(0 < city.size()){
                        JSONObject customCity = (JSONObject)city.get(0);
                        if(customCity.containsKey("name"))retrieveTicketId.setCity(String.valueOf(customCity.get("name")));
                    }
                    
                    if(customer.containsKey("name")){
                        String subCustomName = customer.get("name").toString();
                        
                        int idx = subCustomName.indexOf(" ");

                        retrieveTicketId.setFirstName(subCustomName.substring(0, idx));
                        retrieveTicketId.setLastName(subCustomName.substring(idx+1));
                    }

                }

                if(obj.containsKey("_id"))retrieveTicketId.setUnderId(String.valueOf(obj.get("_id")));
                if(obj.containsKey("id"))retrieveTicketId.setId(Integer.parseInt(String.valueOf(obj.get("id"))));
                if(obj.containsKey("source_external_id"))retrieveTicketId.setSourceExternalId(String.valueOf(obj.get("source_external_id")));
                if(obj.containsKey("can_like"))retrieveTicketId.setCanLike(String.valueOf(obj.get("can_like")));
                if(obj.containsKey("commentary"))retrieveTicketId.setCommentary(String.valueOf(obj.get("commentary")));
                if(obj.containsKey("creation_date") && obj.containsValue("creation_date"))retrieveTicketId.setCreationDate(String.valueOf(obj.get("creation_date")));
                if(obj.containsKey("insertion_date") && obj.containsValue("insertion_date"))retrieveTicketId.setInsertionDate(String.valueOf(obj.get("insertion_date")));
                if(obj.containsKey("complaint_title"))retrieveTicketId.setComplaintTitle(String.valueOf(obj.get("complaint_title")));
                if(obj.containsKey("filed"))retrieveTicketId.setFiled(String.valueOf(obj.get("filed")));
                if(obj.containsKey("last_modification_date") && obj.containsValue("last_modification_date"))retrieveTicketId.setLastModificationDate(String.valueOf(obj.get("last_modification_date")));
                if(obj.containsKey("closed_date") && obj.containsValue("closed_date"))retrieveTicketId.setClosedDate(String.valueOf(obj.get("closed_date")));
                if(obj.containsKey("request_moderation"))retrieveTicketId.setRequestModeration(String.valueOf(obj.get("request_moderation")));
                if(obj.containsKey("request_evaluation"))retrieveTicketId.setRequestEvaluation(String.valueOf(obj.get("request_evaluation")));
                if(obj.containsKey("frozen"))retrieveTicketId.setFrozen(String.valueOf(obj.get("frozen")));
                if(obj.containsKey("ra_reason"))retrieveTicketId.setRaReason(String.valueOf(obj.get("ra_reason")));
                if(obj.containsKey("ra_feeling"))retrieveTicketId.setRaFeeling(String.valueOf(obj.get("ra_feeling")));
                if(obj.containsKey("complaint_response_content"))retrieveTicketId.setComplaintResponseContent(String.valueOf(obj.get("complaint_response_content")));
                if(obj.containsKey("complaint_response_date") && obj.containsValue("complaint_response_date"))retrieveTicketId.setComplaintResponseDate(String.valueOf(obj.get("complaint_response_date")));
                if(obj.containsKey("interactions_count"))retrieveTicketId.setInteractionsCount(Integer.parseInt(String.valueOf(obj.get("interactions_count"))));
                if(obj.containsKey("interactions_not_readed_count"))retrieveTicketId.setInteractionsNotReadedCount(Integer.parseInt(String.valueOf(obj.get("interactions_not_readed_count"))));
                if(obj.containsKey("resolved_issue"))retrieveTicketId.setResolvedIssue(String.valueOf(obj.get("resolved_issue")));
                if(obj.containsKey("back_doing_business"))retrieveTicketId.setBackDoingBusiness(String.valueOf(obj.get("back_doing_business")));
                
                if(obj.get("consumer_consideration") != null){
                    if(obj.containsKey("consumer_consideration"))retrieveTicketId.setConsumerConsideration(String.valueOf(obj.get("consumer_consideration")));
                }
                
                if(obj.get("consumer_consideration_date") != null){
                    if(obj.containsKey("consumer_consideration_date"))retrieveTicketId.setConsumerConsiderationDate(String.valueOf(obj.get("consumer_consideration_date")));
                }    
                
                //if(obj.containsKey("consumer_consideration_date") && obj.containsValue("consumer_consideration_date"))retrieveTicketId.setConsumerConsiderationDate(String.valueOf(obj.get("consumer_consideration_date")));
                if(obj.containsKey("company_consideration"))retrieveTicketId.setCompanyConsideration(String.valueOf(obj.get("company_consideration")));
                if(obj.containsKey("company_consideration_date") && obj.containsValue("company_consideration_date"))retrieveTicketId.setCompanyConsiderationDate(String.valueOf(obj.get("company_consideration_date")));
                if(obj.containsKey("private_treatment_time"))retrieveTicketId.setPrivateTreatmentTime(String.valueOf(obj.get("private_treatment_time")));
                if(obj.containsKey("public_treatment_time"))retrieveTicketId.setPublicTreatmentTime(String.valueOf(obj.get("public_treatment_time")));
                if(obj.containsKey("rating_time"))retrieveTicketId.setRatingTime(String.valueOf(obj.get("rating_time")));
                if(obj.containsKey("rating"))retrieveTicketId.setRating(String.valueOf(obj.get("rating")));
                if(obj.containsKey("rating_date") && obj.containsValue("rating_date"))retrieveTicketId.setRatingDate(String.valueOf(obj.get("rating_date")));
                if(obj.containsKey("comments_count"))retrieveTicketId.setCommentsCount(Integer.parseInt(String.valueOf(obj.get("comments_count"))));
                if(obj.containsKey("redistributions_count"))retrieveTicketId.setRedistributionsCount(Integer.parseInt(String.valueOf(obj.get("redistributions_count"))));
                if(obj.containsKey("redistributions_reason"))retrieveTicketId.setRedistributionsReason(String.valueOf(obj.get("redistributions_reason")));
                if(obj.containsKey("ticket_moderations_count"))retrieveTicketId.setTicketModerationsCount(Integer.parseInt(String.valueOf(obj.get("ticket_moderations_count"))));
                if(obj.containsKey("ticket_messages_count"))retrieveTicketId.setTicketMessagesCount(Integer.parseInt(String.valueOf(obj.get("ticket_messages_count")))); 
                if(obj.containsKey("last_replica_date") && obj.containsValue("last_replica_date"))retrieveTicketId.setLastReplicaDate(String.valueOf(obj.get("last_replica_date")));
                if(obj.containsKey("contact_us"))retrieveTicketId.setContactUs(String.valueOf(obj.get("contact_us")));
                if(obj.containsKey("rating_without_response"))retrieveTicketId.setRatingWithoutResponse(String.valueOf(obj.get("rating_without_response")));
                if(obj.containsKey("hugme_ticket_type"))retrieveTicketId.setHugmeTicketType(String.valueOf(obj.get("hugme_ticket_type")));
                if(obj.containsKey("customer_interactions_count"))retrieveTicketId.setCustomerInteractionsCount(Integer.parseInt(String.valueOf(obj.get("customer_interactions_count"))));
                if(obj.containsKey("company_interactions_count"))retrieveTicketId.setCompanyInteractionsCount(Integer.parseInt(String.valueOf(obj.get("company_interactions_count"))));
                if(obj.containsKey("assignment_count"))retrieveTicketId.setAssignmentCount(Integer.parseInt(String.valueOf(obj.get("assignment_count"))));
                if(obj.containsKey("rule_id"))retrieveTicketId.setAssignmentCount(Integer.parseInt(String.valueOf(obj.get("rule_id"))));
                if(obj.containsKey("active"))retrieveTicketId.setActive(String.valueOf(obj.get("active")));
                /*
                if(obj.containsKey("id"))retrieveTicketId.setId(Integer.parseInt(String.valueOf(obj.get("id"))));
                if(obj.containsKey("customer"))retrieveTicketId.setCustomer(String.valueOf(obj.get("customer")));
                if(obj.containsKey("personalized_fields"))retrieveTicketId.setPersonalizedFields(String.valueOf(obj.get("personalized_fields")));
                if(obj.containsKey("Reclame_Aqui"))retrieveTicketId.setReclameAqui(String.valueOf(obj.get("Reclame_Aqui")));
                if(obj.containsKey("historical"))retrieveTicketId.setHistorical(String.valueOf(obj.get("historical")));
                if(obj.containsKey("tags"))retrieveTicketId.setTags(String.valueOf(obj.get("tags")));
                if(obj.containsKey("ticket_detail_type_id"))retrieveTicketId.setTicketDetailTypeId(String.valueOf(obj.get("ticket_detail_type_id")));
                if(obj.containsKey("ticket_interaction_type"))retrieveTicketId.setTicketInteractionType(String.valueOf(obj.get("ticket_interaction_type")));
                */
                ticketList.add(retrieveTicketId);
            }
            
            
 

            IFHMBRECLAMEAQUICDPP0096Payload.Response payload = new IFHMBRECLAMEAQUICDPP0096Payload.Response();

            payload.setData(ticketList);

            IFHMBRECLAMEAQUICDPP0096Dto dto = new IFHMBRECLAMEAQUICDPP0096Dto();

             dto = modelMapper.map(payload, IFHMBRECLAMEAQUICDPP0096Dto.class);

            service.insertAllTicketList(dto);
        } catch (Exception e) {
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


        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPoint))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .POST(body)
                .build();
        
        
        
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        int statusCode = response.statusCode();

        responseBody = response.body();
        
     
        JSONObject jsonObj = (JSONObject) new JSONParser().parse(responseBody);

        accessToken = String.valueOf(jsonObj.get("access_token"));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return accessToken;
    }

}
