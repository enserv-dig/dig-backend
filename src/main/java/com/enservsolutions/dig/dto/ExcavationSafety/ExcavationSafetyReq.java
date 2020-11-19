package com.enservsolutions.dig.dto.ExcavationSafety;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ExcavationSafetyReq {
    private Integer digId;
    private String dateFrom;
    private String dateTo;
    private String description;
    private String competentPerson;
    private String siteSupervisor;
    private String siteForman;
    private String contractorCompetentPerson;
    private String protectiveSystem;
    private String reviewStatus;
    private String obstructions;
    private String landOwners;
    private String utilities;
    private String water;
    private String sewer;
    private String tools;
    private String blackHoe;
    private String excavator;
    private String trenchBox;
    private String trenchShields;
    private String signs;
    private String barricades;
    private String waterRemovalEquipment;
    private String safetyObserver;

    private String exacavationMonitored;

    private String hazardCondition;
    private String excavation20;
    private String contractorsAware;
    private String checklistPriorProvided;
    private String contractorAdvised;
    private String comments;
    private String completedBy;
    private String completedBySignature;

}
