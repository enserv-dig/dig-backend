package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.CorrosionInspection.CorrosionInspectionReq;
import com.enservsolutions.dig.entity.CorrosionInspection;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.repository.CorrosionInspectionRepository;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.UploadRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CorrosionInspectionService {

    private final CorrosionInspectionRepository corrosionInspectionRepository;
    private final UploadRepository uploadRepository;
    private final DigRepository digRepository;

    public CorrosionInspection createCorrosionInspection(CorrosionInspectionReq req) {
        CorrosionInspection corrosionInspection = new CorrosionInspection();
        corrosionInspection.setDateFrom(req.getDateFrom());
        corrosionInspection.setSegmentName(req.getSegmentName());
        corrosionInspection.setInspectorQualified(req.getInspectorQualified().equalsIgnoreCase("yes"));
        corrosionInspection.setSupervisorApproved(req.getSupervisorApproved().equalsIgnoreCase("yes"));
        corrosionInspection.setRemoveReason(req.getRemoveReason());
        corrosionInspection.setLocation(req.getLocation());
        corrosionInspection.setLocationName(req.getLocationName());
        corrosionInspection.setInWayOf(req.getInWayOf());
        corrosionInspection.setCity(req.getCity());
        corrosionInspection.setCounty(req.getCounty());
        corrosionInspection.setState(req.getState());
        corrosionInspection.setCathodicProtection(req.getCathodicProtection().equalsIgnoreCase("yes"));
        corrosionInspection.setPipeReading(req.getPipeReading());
        corrosionInspection.setBareOrCoated(req.getBareOrCoated());
        corrosionInspection.setCoatingType(req.getCoatingType());
        corrosionInspection.setCoatingCondition(req.getCoatingCondition());
        corrosionInspection.setPipelineCondition(req.getPipelineCondition());
        corrosionInspection.setOuterDiameter(req.getOuterDiameter());
        corrosionInspection.setWallThickness(req.getWallThickness());
        corrosionInspection.setLengthFrom(req.getLengthFrom());
        corrosionInspection.setLengthTo(req.getLengthTo());
        corrosionInspection.setGrade(req.getGrade());
        corrosionInspection.setInternalCondition(req.getInternalCondition());
        corrosionInspection.setInternalConditionDesc(req.getInternalConditionDesc());
        corrosionInspection.setCorrLength(req.getCorrLength());
        corrosionInspection.setDeepestDefect(req.getDeepestDefect());
        corrosionInspection.setWallThicknessLossPercentage((req.getWallThicknessLossPercentage()));
        corrosionInspection.setLargestCorrPitDiameter(req.getLargestCorrPitDiameter());
        corrosionInspection.setSentToLab(req.getSentToLab().equalsIgnoreCase("yes"));
        corrosionInspection.setLabName(req.getLabName());
        corrosionInspection.setLabAddress(req.getLabAddress());
        corrosionInspection.setCompletedBy(req.getCompletedBy());

        corrosionInspectionRepository.save(corrosionInspection);

        Upload upload = new Upload();
        upload.setTag("Internal Corrosion Inspection");
        upload.setFileName("na");
        upload.setDig(digRepository.findById(req.getDigId()).get());
        uploadRepository.save(upload);

        return corrosionInspection;
    }
}
