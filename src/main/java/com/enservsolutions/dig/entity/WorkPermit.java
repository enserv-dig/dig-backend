package com.enservsolutions.dig.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkPermit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer permitId;

    private String permitCompletedBy;
    private String dateFrom;
    private String dateTo;
    private String confinedSpace;
    private String entryPurpose;

    private boolean isolated;
    private boolean atmosphereTested;
    private boolean otherPermits;
    private boolean testEquipmentRequired;
    private boolean signsUsed;
    private boolean meetingDone;

    private String ventilationMethod;
    private String communicationMethod;
    private String retrievalEquipment;
    private String airMonitoring;
    private String lightingRequired;

    @ElementCollection
    private List<String> physicalHazards;

    private String supervisorName;
    private String safetyAttendentName;
    private String safetyAttendentNameAlt;
    private String entrantName;
    private String clockIn;
    private String clockOut;

    @ElementCollection
    private List<Integer> oxygenReadings;
    @ElementCollection
    private List<Integer> flammabilityReadings;
    @ElementCollection
    private List<Integer> h2sReadings;
    @ElementCollection
    private List<Integer> coReadings;
    @ElementCollection
    private List<Integer> benzeneReadings;
    private String testerInitial;

    private String workType;

    private boolean ventsProtected;
    private boolean freeFromFlame;
    private boolean hotGuards;
    private boolean valvesChecked;
    private boolean floorProtected;
    private boolean fireWatchAssigned;
    private boolean fireEquipmentInspected;
    private boolean atmosphereSafe;
    private boolean exchangeInitiated;

    private boolean lineIdentified;
    private boolean lineDrained;
    private boolean lineCleaned;
    private boolean jumperRequired;
    private boolean blindsInPlace;
    private boolean outOfServiceNotice;
    private String personOfNotice;
    private String noticeTime;

    private String equipmentName;
    private String personInitial;
    private String equipmentOutTime;
    private boolean outAllNotified;
    private String removePersonInitial;
    private String equipmentInTime;
    private boolean inAllNotified;











}
