package com.enservsolutions.dig.dto.EncroachmentAgree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EncroachmentAgreeReq {
    private Integer digId;

    private String dateFrom;
    private String companyName;
    private String sectionNumber;
    private String legalDescription;
    private String county;
    private String state;
    private String alignmentSheetNumber;
    private String milePost;
    private String tractNumber;
    private String encroachmentType;

    private String ticketNumber;
    private String callPerson;
    private String dispatchPerson;
    private String activity;
    private String remarks;
    private String followUpAction;
    private String explaination;

    private String personMet;
    private String partyName;
    private String partyTitle;
    private String partyCompany;
    private String partyAddress;
    private String partyCity;
    private String partyState;
    private String partyZip;
    private String partyPhone;

    private String referencePoint;
    private String referencePointEsn;
    private String distAndDirFromReference;
    private String calcEsnCrossing;
    private String facilitySize;
    private String encased;
    private String encaseSize;
    private String casingType;
    private String coatingType;

    private String pipelineCoatingType;
    private String pipelineCoatingCondition;
    private String psGround;
    private String psDitch;
    private String pipelineCondition;

    private String companyContact;
    private String emergency;
    private String companyRep;
    private String phoneNumber;
    private String encroachingPartyRep;
    private String personMetRep;

}
