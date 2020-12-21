package com.enservsolutions.dig.dto.PipeInspection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PipeInspectionReq {

    private Integer digId;
    private String inspectionDate;
    private String location;
    private String inspectionName;
    private String exposeReason;

    private String inspectorQualified;
    private String cathodicProtection;
    private String pipeReading;
    private String bareOrCoated;
    private String coatingType;
    private String coatingCondition;
    private String pipelineCondition;
    private String internalPipelineCondition;

    private String signature;
    private String company;
    private String title;

}
