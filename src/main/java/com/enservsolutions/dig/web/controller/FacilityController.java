package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.UpdateClientReq;
import com.enservsolutions.dig.dto.UpdateFacilityReq;
import com.enservsolutions.dig.dto.facility.CreateFacilityReq;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Facility;
import com.enservsolutions.dig.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/facility")
public class FacilityController {

    private FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping()
    public ResponseEntity<List<Facility>> getAllFacilities() {
        List<Facility> facilities = facilityService.getFaciities();
        return new ResponseEntity<List<Facility>>(facilities, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Facility> createFacility(@RequestBody CreateFacilityReq createFacilityReq) {
        Facility facility = facilityService.createFacility(createFacilityReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(facility);
    }

    @PostMapping("update")
    public ResponseEntity<Facility> updateFacilityStatus(@RequestBody UpdateFacilityReq updateFacilityReq) {
        Optional<Facility> facility = facilityService.getFacility(updateFacilityReq.getFacilityId());
        if(facility.isPresent()) {
            facilityService.switchStatus(facility.get());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(facility.get());
    }


}
