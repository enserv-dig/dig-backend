package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.CorrosionInspection.CorrosionInspectionReq;
import com.enservsolutions.dig.entity.CorrosionInspection;
import com.enservsolutions.dig.service.CorrosionInspectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("cif")
public class CorrosionInspectionController {

    private final CorrosionInspectionService corrosionInspectionService;

    @PostMapping
    public ResponseEntity<CorrosionInspection> createCorrosionInspection(@RequestBody CorrosionInspectionReq corrosionInspectionReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                corrosionInspectionService.createCorrosionInspection(corrosionInspectionReq)
        );
    }
}
