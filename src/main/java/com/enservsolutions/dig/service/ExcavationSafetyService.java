package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.ExcavationSafety.ExcavationSafetyReq;
import com.enservsolutions.dig.entity.ExcavationSafety;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.mapper.Mapper;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.ExcavationSafetyRepository;
import com.enservsolutions.dig.repository.UploadRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ExcavationSafetyService {

    private final ExcavationSafetyRepository excavationSafetyRepository;
    private final UploadRepository uploadRepository;
    private final DigRepository digRepository;

    public ExcavationSafety createExcavationSafety(ExcavationSafetyReq excavationSafetyReq) {
        log.info(String.valueOf(excavationSafetyReq));
        ExcavationSafety excavationSafety = new ExcavationSafety();
        excavationSafety.setDateFrom(excavationSafetyReq.getDateFrom());
        excavationSafety.setDateTo(excavationSafetyReq.getDateTo());
        excavationSafety.setDescription(excavationSafetyReq.getDescription());
        excavationSafety.setCompetentPerson(excavationSafetyReq.getCompetentPerson());
        excavationSafety.setSiteSupervisor(excavationSafetyReq.getSiteSupervisor());
        excavationSafety.setSiteForman(excavationSafetyReq.getSiteForman());
        excavationSafety.setContractorCompetentPerson(excavationSafetyReq.getContractorCompetentPerson());
        excavationSafety.setProtectiveSystem(excavationSafetyReq.getProtectiveSystem());
        if(excavationSafetyReq.getReviewStatus().equalsIgnoreCase("yes")){
            excavationSafety.setReviewStatus(true);
        }
        excavationSafety.setObstructions(excavationSafetyReq.getObstructions());
        excavationSafety.setLandOwners(excavationSafetyReq.getLandOwners().equalsIgnoreCase("yes"));


//        excavationSafety.setUtilities(excavationSafetyReq.getUtilities().equalsIgnoreCase("yes"));
        excavationSafety.setWater(excavationSafetyReq.getWater().equalsIgnoreCase("yes"));
        excavationSafety.setSewer(excavationSafetyReq.getSewer().equalsIgnoreCase("yes"));

        List<String> safetyEquipments = new ArrayList<>();
        if(excavationSafetyReq.getBlackHoe().equalsIgnoreCase("yes")){
            safetyEquipments.add("BlackHoe");
        }
        if(excavationSafetyReq.getExcavator().equalsIgnoreCase("yes")) {
            safetyEquipments.add("Excavator");
        }
        if(excavationSafetyReq.getTrenchBox().equalsIgnoreCase("yes")) {
            safetyEquipments.add("TrenchBox");
        }
        if(excavationSafetyReq.getTrenchShields().equalsIgnoreCase("yes")) {
            safetyEquipments.add("Trench Shields");
        }
        if(excavationSafetyReq.getSigns().equalsIgnoreCase("yes")) {
            safetyEquipments.add("Signs");
        }
        if(excavationSafetyReq.getBarricades().equalsIgnoreCase("yes")){
            safetyEquipments.add("Barricades");
        }
        if(excavationSafetyReq.getWaterRemovalEquipment().equalsIgnoreCase("yes")){
            safetyEquipments.add("Water Removal Equipment");
        }
        if(excavationSafetyReq.getSafetyObserver().equalsIgnoreCase("yes")) {
            safetyEquipments.add("Safety Observer");
        }

        excavationSafety.setProtectiveEquipments(safetyEquipments);

//        excavationSafety.setExacavationMonitored(excavationSafetyReq.getExacavationMonitored().equalsIgnoreCase("yes"));
//        excavationSafety.setHazardCondition(excavationSafetyReq.getHazardCondition().equalsIgnoreCase("yes"));
//        excavationSafety.setExcavation20(excavationSafetyReq.getExcavation20().equalsIgnoreCase("yes"));
//        excavationSafety.setContractorsAware(excavationSafetyReq.getContractorsAware().equalsIgnoreCase("yes"));
        excavationSafety.setChecklistPriorProvided(excavationSafetyReq.getChecklistPriorProvided().equalsIgnoreCase("yes"));
        excavationSafety.setContractorAdvised(excavationSafetyReq.getContractorAdvised().equalsIgnoreCase("yes"));
        excavationSafety.setComments(excavationSafetyReq.getComments());




        excavationSafetyRepository.save(excavationSafety);
        Upload upload = new Upload();
        upload.setTag("Excavation procedure");
        upload.setFileName("na");
        upload.setDig(digRepository.findById(excavationSafetyReq.getDigId()).get());
        uploadRepository.save(upload);
        return excavationSafety;
    }
}
