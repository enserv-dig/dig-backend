package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.PipeInspection.PipeInspectionReq;
import com.enservsolutions.dig.entity.PipeInspection;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.PipeInspectionRepository;
import com.enservsolutions.dig.repository.UploadRepository;
import com.enservsolutions.dig.repository.WorkPermitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.channels.Pipe;

@Service
@AllArgsConstructor
@Slf4j
public class PipeInspectionService {
    private final PipeInspectionRepository pipeInspectionRepository;
    private final UploadRepository uploadRepository;
    private final DigRepository digRepository;

    public PipeInspection createPipeInspection(PipeInspectionReq pipeInspectionReq){
        PipeInspection pipeInspection = new PipeInspection();
        pipeInspection.setInspectionDate(pipeInspectionReq.getInspectionDate());
        pipeInspection.setLocation(pipeInspectionReq.getLocation());
        pipeInspection.setInspectionName(pipeInspectionReq.getInspectionName());
        pipeInspection.setExposeReason(pipeInspectionReq.getExposeReason());

        pipeInspection.setInspectorQualified(pipeInspectionReq.getInspectorQualified().equalsIgnoreCase("yes"));
        pipeInspection.setCathodicProtection(pipeInspectionReq.getCathodicProtection().equalsIgnoreCase("yes"));
        pipeInspection.setPipeReading(pipeInspectionReq.getPipeReading());
        pipeInspection.setBareOrCoated(pipeInspectionReq.getBareOrCoated());
        pipeInspection.setCoatingType(pipeInspectionReq.getCoatingType());
        pipeInspection.setCoatingCondition(pipeInspectionReq.getCoatingCondition());
        pipeInspection.setPipelineCondition(pipeInspectionReq.getPipelineCondition());
        pipeInspection.setInternalPipelineCondition(pipeInspectionReq.getInternalPipelineCondition());

        pipeInspection.setSignature(pipeInspectionReq.getSignature());
        pipeInspection.setCompany(pipeInspectionReq.getCompany());
        pipeInspection.setTitle(pipeInspectionReq.getTitle());

        pipeInspectionRepository.save(pipeInspection);

        Upload upload = new Upload();
        upload.setTag("Exposed Pipe Report");
        upload.setFileName("na");
        upload.setDig(digRepository.findById(pipeInspectionReq.getDigId()).get());
        uploadRepository.save(upload);

        return pipeInspection;

    }
}
