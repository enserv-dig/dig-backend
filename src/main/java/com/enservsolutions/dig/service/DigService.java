package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.DigCreateRequest;
import com.enservsolutions.dig.entity.Dig;
import com.enservsolutions.dig.entity.Paperwork;
import com.enservsolutions.dig.entity.Workflow;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.WorkflowRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Paper;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DigService {

    private DigRepository digRepository;
    private WorkflowRepository workflowRepository;

    @Autowired
    public DigService(DigRepository digRepository, WorkflowRepository workflowRepository) {
        this.digRepository = digRepository;
        this.workflowRepository = workflowRepository;
    }


    public List<Dig> createDigsFromCsv(DigCreateRequest digCreateRequest) {

            for (int i = 0; i < digCreateRequest.getData().length; i++) {
                String[] data = digCreateRequest.getData()[i].split(",");
                for(String datum : data) {
                    if (datum.length() < 1){
                        datum = "-999";
                    }
                }
                int anamolyId = Integer.parseInt(data[0]);
                if (digRepository.getDigsByAnomalyId(anamolyId) == null) {

                    Dig dig = new Dig();

                    dig.setAnomalyId(Integer.valueOf( data[0].isEmpty() ? "-999" : data[0]));
                    dig.setInspectionYear(Integer.valueOf(data[1].isEmpty() ? "-999" :data[1]));
                    dig.setFeature(data[2].isEmpty() ? "NA" :data[2]);
                    dig.setWheelCount(Double.parseDouble(data[3].isEmpty() ? "-999" :data[3]));

                    dig.setStationNumber(1.11);

                    dig.setDepthPct(data[5].isEmpty() ? "NA" : data[5]);
                    dig.setWtNom(Double.parseDouble(data[6].isEmpty() ? "-999" :data[6]));
                    dig.setAsCalledLengthIn(Double.parseDouble(data[7].isEmpty() ? "-999" :data[7]));
                    dig.setAsCalledWidthIn(Double.parseDouble(data[8].isEmpty() ? "-999" :data[8]));

                    dig.setOrientation((data[9].isEmpty() ? "00:00" :data[9]));
                    dig.setPPrimeMod831g(Double.parseDouble(data[10].isEmpty() ? "-999" :data[10]));
                    dig.setErfMod831g(Double.parseDouble(data[11].isEmpty() ? "-999" :data[11]));
                    dig.setPPrimeB31g(Double.parseDouble(data[12].isEmpty() ? "-999" :data[12]));
                    dig.setErfB31g(Double.parseDouble(data[13].isEmpty() ? "-999" :data[13]));
                    dig.setPPrimeRstreng(Double.parseDouble(data[14].isEmpty() ? "-999" :data[14]));
                    dig.setErfRstreng(Double.parseDouble(data[15].isEmpty() ? "-999" :data[15]));
                    dig.setPctMaxOpPress((data[16].isEmpty() ? "NA" :data[16]));

                    dig.setDistUsWeld(Double.parseDouble(data[17].isEmpty() ? "-999" :data[17]));
                    dig.setDistDsWeld(Double.parseDouble(data[18].isEmpty() ? "-999" :data[18]));
                    dig.setUsAgm(data[19].isEmpty() ? "NA" :data[19]);
                    dig.setDistUsAgm(Double.parseDouble(data[20].isEmpty() ? "-999" :data[20]));
                    dig.setDsAgm(data[21].isEmpty() ? "NA" :data[21]);
//                    dig.setDistDsAgm(Double.parseDouble(data[22].isEmpty() ? "-999" :data[22]));

                    log.info(data[23]);
                    dig.setJointLength(Double.parseDouble(data[23].isEmpty() ? "-999" :data[23]));
                    dig.setSeamOrientation((data[24].isEmpty() ? "00:00" :data[24]));

                    boolean als = data[25].equalsIgnoreCase("Y") || data[25].equalsIgnoreCase("yes") ? true : false;
                    dig.setAdjacentLongSeam(als);

                    boolean lsi = data[26].equalsIgnoreCase("Y") || data[25].equalsIgnoreCase("yes") ? true : false;
                    dig.setLongSeamInteraction(lsi);

                    dig.setComments(data[27].isEmpty() ? "NA" :data[27]);
                    dig.setLatitude(Double.parseDouble(data[28].isEmpty() ? "-999" :data[28]));
                    dig.setLongitude(Double.parseDouble(data[29].isEmpty() ? "-999" :data[29]));
                    dig.setAltitude(Double.parseDouble(data[30].isEmpty() ? "-999" :data[30]));

                    digRepository.save(dig);
                }
            }

        return (List<Dig>) digRepository.findAll();
    }

    public List<Dig> getAllDigs() {
        return (List<Dig>) digRepository.findAll();
    }

    public Dig getDig(Integer digId) {
        return this.digRepository.findById(digId).get();
    }

    public String getAllDigsJson() throws JsonProcessingException {
        List<Dig> digs = (List<Dig>) digRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(digs);
        return jsonString;
    }

    public List<Paperwork> getPaperworks(Integer digId) {
        List<Paperwork> paperworks = null;
        Dig dig = digRepository.findById(digId).get();
        log.info(String.valueOf(dig));
        if(dig != null) {
            List<Workflow> workflows = (List<Workflow>) workflowRepository.findAll();
            log.info(String.valueOf(workflows));
            for (Workflow workflow : workflows) {
                if(workflow.getDigs().contains(dig)) {
                    paperworks = workflow.getPaperworks();
                }
            }
        }
        log.info(String.valueOf(paperworks));
        return paperworks;
    }
}
