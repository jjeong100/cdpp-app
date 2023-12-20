package com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0013;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountContactRelationDto {
	private String account__external_id__c;  // character varying(255) COLLATE pg_catalog."default",
	private String accountid;                // character varying(18) COLLATE pg_catalog."default",
    private boolean isdeleted;               // boolean,
    private Timestamp systemmodstamp;        // timestamp without time zone,
    private String external_id__c;           //character varying(255) COLLATE pg_catalog."default",
    private String contact__external_id__c;  //character varying(255) COLLATE pg_catalog."default",
    private Timestamp createddate;           //timestamp without time zone,
    private String contactid;                // character varying(18) COLLATE pg_catalog."default",
    private String sfid;                      // character varying(18) COLLATE pg_catalog.ucs_basic,
    private Integer id;                       // integer NOT NULL DEFAULT nextval('replica.accountcontactrelation_id_seq'::regclass),
    private String _hc_lastop;                // character varying(32) COLLATE pg_catalog."default",
    private String _hc_err;                   // text COLLATE pg_catalog."default",
}
