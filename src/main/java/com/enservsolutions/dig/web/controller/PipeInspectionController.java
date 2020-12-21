package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.PipeInspection.PipeInspectionReq;
import com.enservsolutions.dig.entity.PipeInspection;
import com.enservsolutions.dig.service.PipeInspectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("pif")
public class PipeInspectionController {
    private final PipeInspectionService pipeInspectionService;

    @PostMapping
    public ResponseEntity<PipeInspection> createPipeInspection(@RequestBody PipeInspectionReq pipeInspectionReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pipeInspectionService.createPipeInspection(pipeInspectionReq));
    }
}
