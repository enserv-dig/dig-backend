package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.pipeline.CreatePipelineReq;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Facility;
import com.enservsolutions.dig.entity.Pipeline;
import com.enservsolutions.dig.repository.FacilityRepository;
import com.enservsolutions.dig.repository.PipelineRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.channels.Pipe;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Data
public class PipelineService {
    private final PipelineRepository pipelineRepository;
    private final FacilityRepository facilityRepository;

    public List<Pipeline> getAllPipelines() {
        return (List<Pipeline>) pipelineRepository.findAll();
    }

    public Pipeline createPipeline(CreatePipelineReq createPipelineReq) {
        log.info(String.valueOf(createPipelineReq));
        int facilityId = createPipelineReq.getFacilityId();
        log.info(String.valueOf(facilityId));
        boolean status = false;
        String active = createPipelineReq.getActivePipeline();
        if(active.equalsIgnoreCase("active")){
            status = true;
        }
        log.info(String.valueOf(status));

        Pipeline pipeline = new Pipeline();
        Optional<Facility> facility = facilityRepository.findById(facilityId);
        if(facility.isPresent()) {
            pipeline.setActivePipeline(status);
            pipeline.setPipelineName(createPipelineReq.getPipelineName());
            pipeline.setFacility(facility.get());

            log.info(String.valueOf(pipeline));

            pipelineRepository.save(pipeline);
        }
        return pipeline;
    }

    public Optional<Pipeline> getPipeline(Integer pipelineId) {
        return pipelineRepository.findById(pipelineId);
    }

    public Pipeline switchStatus(Pipeline pipeline) {
        pipeline.setActivePipeline(!pipeline.isActivePipeline());
        pipelineRepository.save(pipeline);
        return pipeline;
    }


}
