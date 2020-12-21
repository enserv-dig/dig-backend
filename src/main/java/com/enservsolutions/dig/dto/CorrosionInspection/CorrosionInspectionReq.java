package com.enservsolutions.dig.dto.CorrosionInspection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorrosionInspectionReq {
    private Integer digId;

    private String dateFrom;
    private String segmentName;
    private String inspectorQualified;
    private String supervisorApproved;

    private String removeReason;
    private String location;
    private String locationName;
    private String inWayOf;
    private String city;
    private String county;
    private String state;

    private String cathodicProtection;
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
    private String sentToLab;
    private String labName;
    private String labAddress;
    private String completedBy;
}
