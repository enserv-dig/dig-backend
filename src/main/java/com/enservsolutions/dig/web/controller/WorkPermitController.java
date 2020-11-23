package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.WorkPermit.WorkPermitReq;
import com.enservsolutions.dig.entity.WorkPermit;
import com.enservsolutions.dig.service.WorkPermitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("wpf")
public class WorkPermitController {
    private final WorkPermitService workPermitService;

    @PostMapping
    public ResponseEntity<WorkPermit> createWorkPermit(@RequestBody WorkPermitReq workPermitReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.workPermitService.createWorkPermit(workPermitReq));
    }

}
