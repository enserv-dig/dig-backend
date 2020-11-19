package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.entity.PaperworkType;
import com.enservsolutions.dig.repository.PaperworkTypeRepository;
import com.enservsolutions.dig.service.PaperworkTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("paperworkType")
public class PaperworkTypeController {
    private final PaperworkTypeService paperworkTypeService;

    @GetMapping
    public ResponseEntity<List<PaperworkType>> getAllPaperworkTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(paperworkTypeService.getAllPaperworkType());
    }
}
