package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.DigCreateRequest;
import com.enservsolutions.dig.dto.dig.DigWorkspaceRes;
import com.enservsolutions.dig.entity.Dig;
import com.enservsolutions.dig.service.DigService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/dig")
public class DigController {

    private final DigService digService;

    @PostMapping()
    public ResponseEntity<List<Dig>> createDigsFromCsv(@RequestBody DigCreateRequest digCreateRequest) {
        ArrayList<Dig> digs = (ArrayList<Dig>) digService.createDigsFromCsv(digCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(digs);
    }

    @GetMapping()
    public ResponseEntity<List<Dig>> getAllDigs() {
        return ResponseEntity.status(HttpStatus.OK).body(digService.getAllDigs());
    }

    @GetMapping("{id}")
    public ResponseEntity<DigWorkspaceRes> getDig(@PathVariable Integer id) {
        DigWorkspaceRes response = new DigWorkspaceRes(digService.getDig(id), digService.getPaperworks(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("json")
    public ResponseEntity<String> getAllDigsJson() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(digService.getAllDigsJson());
    }

}
