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
public class PipeInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pipeInspectionId;

    private String inspectionDate;
    private String location;
    private String inspectionName;
    private String exposeReason;

    private boolean inspectorQualified;
    private boolean cathodicProtection;
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
