package com.enservsolutions.dig.dto.WorkPermit;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@AllArgsConstructor
public class WorkPermitReq {

    private Integer digId;

    private String permitCompletedBy;
    private String dateFrom;
    private String dateTo;
    private String confinedSpace;
    private String entryPurpose;

    private String isolated;
    private String atmosphereTested;
    private String otherPermits;
    private String testEquipmentRequired;
    private String signsUsed;
    private String meetingDone;

    private String ventilationMethod;
    private String communicationMethod;
    private String retrievalEquipment;
    private String airMonitoring;
    private String lightingRequired;

    private List<String> physicalHazards;

    private String supervisorName;
    private String safetyAttendentName;
    private String safetyAttendentNameAlt;
    private String entrantName;
    private String clockIn;
    private String clockOut;

    private String initialOxygen;
    private String finalOxygen;
    private String initialFlammability;
    private String finalFlammability;
    private String initialH2S;
    private String finalH2S;
    private String initialCO;
    private String finalCO;
    private String initialBenzene;
    private String finalBenzene;
    private String testerInitial;

    private String workType;

    private String ventsProtected;
    private String freeFromFlame;
    private String hotGuards;
    private String valvesChecked;
    private String floorProtected;
    private String fireWatchAssigned;
    private String fireEquipmentInspected;
    private String atmosphereSafe;
    private String exchangeInitiated;

    private String lineIdentified;
    private String lineDrained;
    private String lineCleaned;
    private String jumperRequired;
    private String blindsInPlace;
    private String outOfServiceNotice;
    private String personOfNotice;
    private String noticeTime;

    private String equipmentName;
    private String personInitial;
    private String equipmentOutTime;
    private String outAllNotified;
    private String removePersonInitial;
    private String equipmentInTime;
    private String inAllNotified;

}
