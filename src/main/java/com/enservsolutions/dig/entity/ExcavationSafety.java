package com.enservsolutions.dig.entity;

import com.enservsolutions.dig.dto.ExcavationSafety.ExcavationSafetyReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExcavationSafety {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer worksheetId;

    private String dateFrom;
    private String dateTo;
    private String description;
    private String competentPerson;
    private String siteSupervisor;
    private String siteForman;
    private String contractorCompetentPerson;
    private String protectiveSystem;
    private boolean reviewStatus;
    private String obstructions;
    private boolean landOwners;
    private boolean utilities;
    private boolean water;
    private boolean sewer;
    private boolean tools;
    @ElementCollection
    private List<String> protectiveEquipments;

    private boolean exacavationMonitored;

    private boolean hazardCondition;
    private boolean excavation20;
    private boolean contractorsAware;
    private boolean checklistPriorProvided;
    private boolean contractorAdvised;
    private String comments;
    private String completedBy;
    private String completedBySignature;
}
