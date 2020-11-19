package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.paperwork.AssignPaperworkReq;
import com.enservsolutions.dig.dto.paperwork.FilterPaperworkReq;
import com.enservsolutions.dig.dto.paperwork.RemovePaperworkFromWorkflow;
import com.enservsolutions.dig.entity.Paperwork;
import com.enservsolutions.dig.entity.Workflow;
import com.enservsolutions.dig.service.PaperworkService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("paperwork")
public class PaperworkController {
    private final PaperworkService paperworkService;

    @GetMapping
    public ResponseEntity<List<Paperwork>> getAllPaperWorks() {
        return ResponseEntity.status(HttpStatus.OK).body(paperworkService.getAllPaperworks());
    }

    @PostMapping("name")
    public ResponseEntity<Paperwork> getPaperwork(@RequestBody String paperworkName) {
        return ResponseEntity.status(HttpStatus.OK).body(paperworkService.getPaperwork(paperworkName));
    }

    @PostMapping("type")
    public ResponseEntity<List<Paperwork>> getPaperworksByType(@RequestBody FilterPaperworkReq filterPaperworkReq) {
        log.info(String.valueOf(filterPaperworkReq));
        return ResponseEntity.status(HttpStatus.OK).body(paperworkService.getPaperworksByType(filterPaperworkReq.getPaperworkTypeId()));
    }

    @PostMapping
    public ResponseEntity<Workflow> assignPaperworkToWorkflow(@RequestBody AssignPaperworkReq assignPaperworkReq) {
        return ResponseEntity.status(HttpStatus.OK).body(paperworkService.assignPaperworkToWorkflow(assignPaperworkReq));
    }

    @PostMapping("/remove")
    public ResponseEntity<Workflow> deletePaperworkFromWorkflow(@RequestBody RemovePaperworkFromWorkflow removePaperworkFromWorkflow) {
        return ResponseEntity.status(HttpStatus.OK).body(paperworkService.removePaperworkFromWorkflow(removePaperworkFromWorkflow));
    }
}
