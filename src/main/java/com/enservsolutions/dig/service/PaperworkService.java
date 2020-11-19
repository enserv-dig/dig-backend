package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.paperwork.AssignPaperworkReq;
import com.enservsolutions.dig.dto.paperwork.RemovePaperworkFromWorkflow;
import com.enservsolutions.dig.entity.Paperwork;
import com.enservsolutions.dig.entity.PaperworkType;
import com.enservsolutions.dig.entity.Workflow;
import com.enservsolutions.dig.repository.PaperworkRepository;
import com.enservsolutions.dig.repository.PaperworkTypeRepository;
import com.enservsolutions.dig.repository.WorkflowRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PaperworkService {

    private final PaperworkRepository paperworkRepository;
    private final WorkflowRepository workflowRepository;
    private final PaperworkTypeRepository paperworkTypeRepository;

    public List<Paperwork> getAllPaperworks() {
        return (List<Paperwork>) this.paperworkRepository.findAll();
    }

    public List<Paperwork> getPaperworksByType(Integer paperworkType) {
        log.info(String.valueOf(paperworkType));
        List<Paperwork> res = getAllPaperworks();
        List<Paperwork> response = new ArrayList<>();
        PaperworkType paperworkType1 = paperworkTypeRepository.findById(paperworkType).get();
        log.info(String.valueOf(paperworkType1));
        if(paperworkType1 != null) {
            res.forEach(data -> {
                log.info(String.valueOf(data));
                if(data.getPaperworkType() == paperworkType1) {
                    log.info(String.valueOf(data.getPaperworkType()));
                    response.add(data);
                }
            });
        }
        return response;
    }

    public Workflow assignPaperworkToWorkflow(AssignPaperworkReq assignPaperworkReq) {
        Workflow workflow = this.workflowRepository.findById(assignPaperworkReq.getWorkflowId()).get();
        if(workflow != null) {
            Paperwork paperwork = paperworkRepository.findById(assignPaperworkReq.getPaperworkId()).get();
            if(!workflow.getPaperworks().contains(paperwork)){
                List<Paperwork> pws = workflow.getPaperworks();
                pws.add(paperwork);
                workflow.setPaperworks(pws);
            }
            workflowRepository.save(workflow);
        }
        return workflow;
    }

    public Workflow removePaperworkFromWorkflow(RemovePaperworkFromWorkflow removePaperworkFromWorkflow) {
        Workflow workflow = this.workflowRepository.findById(removePaperworkFromWorkflow.getWorkflowId()).get();
        if(workflow != null) {
            Paperwork paperwork = paperworkRepository.findById(removePaperworkFromWorkflow.getPaperworkId()).get();
            if(workflow.getPaperworks().contains(paperwork)){
                List<Paperwork> pws = workflow.getPaperworks();
                pws.remove(paperwork);
                workflow.setPaperworks(pws);
            }
            workflowRepository.save(workflow);
        }
        return workflow;
    }

    public Paperwork getPaperwork(String paperworkName) {
        return this.paperworkRepository.findPaperworkByPaperworkName(paperworkName);
    }
}
