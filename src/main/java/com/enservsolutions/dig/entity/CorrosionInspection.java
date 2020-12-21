package com.enservsolutions.dig.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CorrosionInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer corrosionInspectionId;

    private String dateFrom;
    private String segmentName;
    private boolean inspectorQualified;
    private boolean supervisorApproved;

    private String removeReason;
    private String location;
    private String locationName;
    private String inWayOf;
    private String city;
    private String county;
    private String state;

    private boolean cathodicProtection;
    private String pipeReading;
    private String bareOrCoated;
    private String coatingType;
    private String coatingCondition;
    private String pipelineCondition;
    private String outerDiameter;
    private String wallThickness;
    private String lengthFrom;
    private String lengthTo;
    private String grade;
    private String internalConditionDesc;
    private String internalCondition;
    private String corrLength;
    private String deepestDefect;
    private String wallThicknessLossPercentage;
    private String largestCorrPitDiameter;
    private boolean sentToLab;
    private String labName;
    private String labAddress;
    private String completedBy;
}
