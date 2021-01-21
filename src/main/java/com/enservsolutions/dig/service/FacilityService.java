package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.facility.CreateFacilityReq;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Facility;
import com.enservsolutions.dig.repository.ClientRepository;
import com.enservsolutions.dig.repository.FacilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FacilityService {
    private FacilityRepository facilityRepository;
    private ClientRepository clientRepository;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository, ClientRepository clientRepository) {
        this.facilityRepository = facilityRepository;
        this.clientRepository = clientRepository;
    }

    public List<Facility> getFaciities() {return (List<Facility>) facilityRepository.findAll();}

    public Facility createFacility(CreateFacilityReq createFacilityReq) {
        boolean status = false;
        String active = createFacilityReq.getFacilityStatus();
        if(active.equalsIgnoreCase("active")){
            status = true;
        }
        Client client = clientRepository.getClientByClientName(createFacilityReq.getClient());
        Facility facility = null;
        if(client != null) {
           facility = new Facility(createFacilityReq.getFacilityName(), status);
           facility.setClient(client);
           facilityRepository.save(facility);
        }
        return facility;
    }

    public Optional<Facility> getFacility(Integer facilityId) {
        return facilityRepository.findById(facilityId);
    }

    public Facility switchStatus(Facility facility) {
        facility.setActiveFacility(!facility.isActiveFacility());
        facilityRepository.save(facility);
        return facility;
    }

}
