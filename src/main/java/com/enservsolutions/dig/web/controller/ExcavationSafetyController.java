package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.ExcavationSafety.ExcavationSafetyReq;
import com.enservsolutions.dig.entity.ExcavationSafety;
import com.enservsolutions.dig.service.ExcavationSafetyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("sec")
public class ExcavationSafetyController {
    private final ExcavationSafetyService excavationSafetyService;

    @PostMapping
    public ResponseEntity<ExcavationSafety> createExcavationSafety(@RequestBody ExcavationSafetyReq excavationSafetyReq) {
        log.info(String.valueOf(excavationSafetyReq));
        return ResponseEntity.status(HttpStatus.CREATED).body(this.excavationSafetyService.createExcavationSafety(excavationSafetyReq));
    }
}
