package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.EncroachmentAgree.EncroachmentAgreeReq;
import com.enservsolutions.dig.entity.EncroachmentAgree;
import com.enservsolutions.dig.service.EncroachmentAgreeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("eaf")
public class EncroachmentAgreeController {
    private final EncroachmentAgreeService encroachmentAgreeService;

    @PostMapping
    public ResponseEntity<EncroachmentAgree> createEncroachmentAgree(@RequestBody EncroachmentAgreeReq encroachmentAgreeReq) {
        log.info(String.valueOf(encroachmentAgreeReq));
        return ResponseEntity.status(HttpStatus.CREATED).body(encroachmentAgreeService.createEncroachmentAgree(encroachmentAgreeReq));
    }
}
