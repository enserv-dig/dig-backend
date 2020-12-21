package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.workflow.AssignDigToWorkflowReq;
import com.enservsolutions.dig.dto.workflow.CreateWorkflowReq;
import com.enservsolutions.dig.dto.workflow.UpdateWorkflowReq;
import com.enservsolutions.dig.entity.Dig;
import com.enservsolutions.dig.entity.Workflow;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.WorkflowRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@Slf4j
public class WorkflowService {

    private final WorkflowRepository workflowRepository;
    private final DigRepository digRepository;

    public List<Workflow> getAllWorkflows() {
        return (List<Workflow>) this.workflowRepository.findAll();
    }

    public Workflow createWorkflow(CreateWorkflowReq createWorkflowReq) {
        List<Dig> digs = new ArrayList<>();
        Workflow workflow = new Workflow(createWorkflowReq.getWorkflowName());
        List<Integer> ids  = createWorkflowReq.getDigIds();
        log.info(String.valueOf(ids));
        ids.forEach(data -> {
            digs.add(this.digRepository.findById(data).get());
        });
        workflow.setDigs(digs);
        workflowRepository.save(workflow);

        return workflow;
    }

    public Workflow getWorkflow(Integer id) {
        return workflowRepository.findById(id).get();
    }

    public Workflow setRepairStatus(UpdateWorkflowReq updateWorkflowReq) {
        Workflow workflow = this.workflowRepository.findById(updateWorkflowReq.getWorkflowId()).get();
        if(updateWorkflowReq.getRepairStatus().equalsIgnoreCase("yes")){
            workflow.setRepairRequired(true);
        } else {
            workflow.setRepairRequired(false);
        }
        workflowRepository.save(workflow);
        return workflow;
    }

    public Workflow setDigsToExistingWorkflow(AssignDigToWorkflowReq assignDigToWorkflowReq) {
        Workflow workflow = workflowRepository.findById(assignDigToWorkflowReq.getWorkflowId()).get();
        if(workflow != null) {
            List<Dig> digs = workflow.getDigs();
            List<Integer> ids  = assignDigToWorkflowReq.getDigIds();
            ids.forEach(data -> {
                digs.add(this.digRepository.findById(data).get());
            });
            workflow.setDigs(digs);
            workflowRepository.save(workflow);
        }
        return workflow;
    }

}
