package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.WorkPermit.WorkPermitReq;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.entity.WorkPermit;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.UploadRepository;
import com.enservsolutions.dig.repository.WorkPermitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class WorkPermitService {
    private final WorkPermitRepository workPermitRepository;
    private final UploadRepository uploadRepository;
    private final DigRepository digRepository;


    public WorkPermit createWorkPermit(WorkPermitReq workPermitReq) {
        WorkPermit workPermit = new WorkPermit();
        workPermit.setPermitCompletedBy(workPermitReq.getPermitCompletedBy());
        workPermit.setDateFrom(workPermitReq.getDateFrom());
        workPermit.setDateTo(workPermitReq.getDateTo());
        workPermit.setConfinedSpace(workPermitReq.getConfinedSpace());
        workPermit.setEntryPurpose(workPermitReq.getEntryPurpose());

        workPermit.setIsolated(workPermitReq.getIsolated().equalsIgnoreCase("yes"));
        workPermit.setAtmosphereTested(workPermitReq.getAtmosphereTested().equalsIgnoreCase("yes"));
        workPermit.setOtherPermits(workPermitReq.getOtherPermits().equalsIgnoreCase("yes"));
        workPermit.setTestEquipmentRequired(workPermitReq.getTestEquipmentRequired().equalsIgnoreCase("yes"));
        workPermit.setSignsUsed(workPermitReq.getSignsUsed().equalsIgnoreCase("yes"));
        workPermit.setMeetingDone(workPermitReq.getMeetingDone().equalsIgnoreCase("yes"));

        workPermit.setVentilationMethod(workPermitReq.getVentilationMethod());
        workPermit.setCommunicationMethod(workPermitReq.getCommunicationMethod());
        workPermit.setRetrievalEquipment(workPermitReq.getRetrievalEquipment());
        workPermit.setAirMonitoring(workPermitReq.getAirMonitoring());
        workPermit.setLightingRequired(workPermitReq.getLightingRequired());

        workPermit.setPhysicalHazards(workPermitReq.getPhysicalHazards());

        workPermit.setSupervisorName(workPermitReq.getSupervisorName());
        workPermit.setSafetyAttendentName(workPermitReq.getSafetyAttendentName());
        workPermit.setSafetyAttendentNameAlt(workPermitReq.getSafetyAttendentNameAlt());
        workPermit.setEntrantName(workPermitReq.getEntrantName());
        workPermit.setClockIn(workPermitReq.getClockIn());
        workPermit.setClockOut(workPermitReq.getClockOut());

        List<Integer> oxReadings = new ArrayList<>();
        oxReadings.add(Integer.valueOf(workPermitReq.getInitialOxygen()));
        oxReadings.add(Integer.valueOf(workPermitReq.getFinalOxygen()));
        workPermit.setOxygenReadings(oxReadings);

        List<Integer> flaReadings = new ArrayList<>();
        flaReadings.add(Integer.valueOf(workPermitReq.getInitialFlammability()));
        flaReadings.add(Integer.valueOf(workPermitReq.getFinalFlammability()));
        workPermit.setFlammabilityReadings(flaReadings);

        List<Integer> h2sReadings = new ArrayList<>();
        h2sReadings.add(Integer.valueOf(workPermitReq.getInitialH2S()));
        h2sReadings.add(Integer.valueOf(workPermitReq.getFinalH2S()));
        workPermit.setH2sReadings(h2sReadings);

        List<Integer> coReadings = new ArrayList<>();
        coReadings.add(Integer.valueOf(workPermitReq.getInitialCO()));
        coReadings.add(Integer.valueOf(workPermitReq.getFinalCO()));
        workPermit.setCoReadings(coReadings);

        List<Integer> benzeneReadings = new ArrayList<>();
        benzeneReadings.add(Integer.valueOf(workPermitReq.getInitialBenzene()));
        benzeneReadings.add(Integer.valueOf(workPermitReq.getFinalBenzene()));
        workPermit.setBenzeneReadings(benzeneReadings);
        workPermit.setTesterInitial(workPermitReq.getTesterInitial());

        workPermit.setWorkType(workPermitReq.getWorkType());
        workPermit.setVentsProtected(workPermitReq.getVentsProtected().equalsIgnoreCase("yes"));
        workPermit.setFreeFromFlame(workPermitReq.getFreeFromFlame().equalsIgnoreCase("yes"));
        workPermit.setHotGuards(workPermitReq.getHotGuards().equalsIgnoreCase("yes"));
        workPermit.setValvesChecked(workPermitReq.getValvesChecked().equalsIgnoreCase("yes"));
        workPermit.setFloorProtected(workPermitReq.getFloorProtected().equalsIgnoreCase("yes"));
        workPermit.setFireWatchAssigned(workPermitReq.getFireWatchAssigned().equalsIgnoreCase("yes"));
        workPermit.setFireEquipmentInspected(workPermitReq.getFireEquipmentInspected().equalsIgnoreCase("yes"));
        workPermit.setAtmosphereSafe(workPermitReq.getAtmosphereSafe().equalsIgnoreCase("yes"));
        workPermit.setExchangeInitiated(workPermitReq.getExchangeInitiated().equalsIgnoreCase("yes"));

        workPermit.setLineIdentified(workPermitReq.getLineIdentified().equalsIgnoreCase("yes"));
        workPermit.setLineDrained(workPermitReq.getLineDrained().equalsIgnoreCase("yes"));
        workPermit.setLineCleaned(workPermitReq.getLineCleaned().equalsIgnoreCase("yes"));
        workPermit.setJumperRequired(workPermitReq.getJumperRequired().equalsIgnoreCase("yes"));
        workPermit.setBlindsInPlace(workPermitReq.getBlindsInPlace().equalsIgnoreCase("yes"));
        workPermit.setOutOfServiceNotice(workPermitReq.getOutOfServiceNotice().equalsIgnoreCase("yes"));

        workPermit.setPersonOfNotice(workPermitReq.getPersonOfNotice());
        workPermit.setNoticeTime(workPermitReq.getNoticeTime());

        workPermit.setEquipmentName(workPermitReq.getEquipmentName());
        workPermit.setPersonInitial(workPermitReq.getPersonInitial());
        workPermit.setEquipmentOutTime(workPermitReq.getEquipmentOutTime());
        workPermit.setOutAllNotified(workPermitReq.getOutAllNotified().equalsIgnoreCase("yes"));
        workPermit.setRemovePersonInitial(workPermitReq.getRemovePersonInitial());
        workPermit.setEquipmentInTime(workPermitReq.getEquipmentInTime());
        workPermit.setInAllNotified(workPermitReq.getInAllNotified().equalsIgnoreCase("yes"));

        workPermitRepository.save(workPermit);

        Upload upload = new Upload();
        upload.setTag("Work permit");
        upload.setFileName("na");
        upload.setDig(digRepository.findById(workPermitReq.getDigId()).get());
        uploadRepository.save(upload);



        return workPermit;
    }
}
