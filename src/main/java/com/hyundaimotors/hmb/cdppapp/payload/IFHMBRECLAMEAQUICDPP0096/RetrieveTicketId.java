package com.hyundaimotors.hmb.cdppapp.payload.IFHMBRECLAMEAQUICDPP0096;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetrieveTicketId {
    private int id;
    @JsonProperty("_id")
    private String underId;
    @JsonProperty("source_external_id")
    private String sourceExternalId;
    @JsonProperty("back_doing_business")
    private String backDoingBusiness;
    @JsonProperty("comments_count")
    private int commentsCount;
    private String company;
    @JsonProperty("company_consideration")
    private String companyConsideration;
    @JsonProperty("company_consideration_date")
    private String companyConsiderationDate;
    @JsonProperty("complaint_content")
    private String complaintContent;
    @JsonProperty("complaint_title")
    private String complaintTitle;
    @JsonProperty("consumer_consideration")
    private String consumerConsideration;
    @JsonProperty("consumer_consideration_date")
    private String consumerConsiderationDate;
    @JsonProperty("creation_date")
    private String creationDate;
    private String customer;
    private String frozen;
    @JsonProperty("last_replica_date")
    private String lastReplicaDate;
    private String moderation;
    @JsonProperty("personalized_fields")
    private String personalizedFields;
    @JsonProperty("public_treatment_time")
    private String publicTreatmentTime;
    @JsonProperty("Reclame_Aqui")
    private String reclameAqui;
    @JsonProperty("ra_feeling")
    private String raFeeling;
    @JsonProperty("ra_reason")
    private String raReason;
    @JsonProperty("ra_status")
    private String raStatus;
    private String rafone;
    @JsonProperty("rating_without_response")
    private String ratingWithoutResponse;
    @JsonProperty("request_evaluation")
    private String requestEvaluation;
    @JsonProperty("request_moderation")
    private String requestModeration;
    @JsonProperty("resolved_issue")
    private String resolvedIssue;
    @JsonProperty("ticket_moderations_count")
    private int ticketModerationsCount;
    @JsonProperty("assignment_count")
    private int assignmentCount;
    @JsonProperty("can_like")
    private String canLike;
    @JsonProperty("company_interactions_count")
    private int companyInteractionsCount;
    @JsonProperty("customer_interactions_count")
    private int customerInteractionsCount;
    @JsonProperty("favorable_assessment")
    private String favorableAssessment;
    @JsonProperty("feed_type")
    private String feedType;
    private String filed;
    private String historical;
    @JsonProperty("hugme_status")
    private String hugmeStatus;
    @JsonProperty("hugme_ticket_type")
    private String hugmeTicketType;
    @JsonProperty("information_source")
    private String informationSource;
    @JsonProperty("interactions_count")
    private int interactionsCount;
    @JsonProperty("interactions_not_readed_count")
    private int interactionsNotReadedCount;
    @JsonProperty("last_modification_date")
    private String lastModificationDate;
    @JsonProperty("private_treatment_time")
    private String privateTreatmentTime;
    @JsonProperty("redistributions_count")
    private int redistributionsCount;
    @JsonProperty("redistributions_reason")
    private String redistributionsReason;
    private String source;
    private String tags;
    @JsonProperty("ticket_detail_type_id")
    private String ticketDetailTypeId;
    @JsonProperty("ticket_interaction_type")
    private String ticketInteractionType;
    @JsonProperty("ticket_messages_count")
    private int ticketMessagesCount;
    @JsonProperty("last_feeling")
    private String lastFeeling;
    @JsonProperty("status")
    private String moderationStatus;
    @JsonProperty("reason")
    private String moderationReason;
    @JsonProperty("request_date")
    private String moderationRequestDate;
    @JsonProperty("response_date")
    private String moderationResponseDate;
    @JsonProperty("replicas_count")
    public int replicasCount;
    @JsonProperty("source_id")
    public int sourceId;
    @JsonProperty("source_name")
    public String sourceName;
    @JsonProperty("deactivation_date")
    public String deactivationDate;
    @JsonProperty("deactivation_reason")
    public String deactivationReason;
    @JsonProperty("internal_process")
    public String internalProcess;
    @JsonProperty("blackfriday")
    public String blackFriday;
    public String userName;
    public String userAssignmentDate;
    public String account;
    @JsonProperty("expiration_date")
    public String rafoneExpirationDate;
    @JsonProperty("status_id")
    public String rafoneStatusId;
    @JsonProperty("status_name")
    public String rafoneStatusName;
    public String commentary;
    @JsonProperty("insertion_date")
    public String insertionDate;
    @JsonProperty("closed_date")
    public String closedDate;
    @JsonProperty("complaint_response_content")
    public String complaintResponseContent;
    @JsonProperty("complaint_response_date")
    public String complaintResponseDate;
    @JsonProperty("rating_time")
    public String ratingTime;
    public String rating;
    @JsonProperty("rating_date")
    public String ratingDate;
    @JsonProperty("contact_us")
    public String contactUs;
    @JsonProperty("rule_id")
    public String ruleId;
    public String active;

    @JsonProperty("ticket_interaction_id")
    public String ticketInteractionId;
    @JsonProperty("ticket_interaction_type_id")
    public int ticketInteractionTypeId;
    @JsonProperty("ticket_interaction_name")
    public String ticketInteractionName;
    @JsonProperty("customer_id")
    public String customerId;
    @JsonProperty("responsible_id")
    public String responsibleId;
    @JsonProperty("responsible_name")
    public String responsibleName;
    public String message;
    public String privacy;
    public String interactionCreationDate;
    @JsonProperty("modification_date")
    public String modificationDate;
    public String delivered;
    public String readed;
    public String visualized;
    public String video;
    public String picture;

    public String birthday;
    public String cpf;
    public String rg;
    public String gender;
    public String email;
    @JsonProperty("phone_numbers")
    public String phoneNumbers;
    public String firstName;
    public String lastName;

}
