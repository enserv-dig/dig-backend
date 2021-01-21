package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.UpdateClientReq;
import com.enservsolutions.dig.dto.UpdatePipelineReq;
import com.enservsolutions.dig.dto.pipeline.CreatePipelineReq;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Pipeline;
import com.enservsolutions.dig.service.PipelineService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.Pipe;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("pipeline")
@CrossOrigin
public class PipelineController {

    private final PipelineService pipelineService;

    @GetMapping()
    public ResponseEntity<List<Pipeline>> getAllPipelines() {
        return ResponseEntity.status(HttpStatus.OK).body(pipelineService.getAllPipelines());
    }

    @PostMapping()
    public ResponseEntity<Pipeline> createPipeline(@RequestBody CreatePipelineReq createPipelineReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pipelineService.createPipeline(createPipelineReq));
    }


    @PostMapping("update")
    public ResponseEntity<Pipeline> updatePipelineStatus(@RequestBody UpdatePipelineReq updatePipelineReq) {
        Optional<Pipeline> pipeline = pipelineService.getPipeline(updatePipelineReq.getPipelineId());
        if(pipeline.isPresent()) {
            pipelineService.switchStatus(pipeline.get());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pipeline.get());
    }
}
