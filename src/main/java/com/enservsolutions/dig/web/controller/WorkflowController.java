package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.workflow.AssignDigToWorkflowReq;
import com.enservsolutions.dig.dto.workflow.CreateWorkflowReq;
import com.enservsolutions.dig.dto.workflow.UpdateWorkflowReq;
import com.enservsolutions.dig.entity.Workflow;
import com.enservsolutions.dig.service.WorkflowService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("workflow")
@CrossOrigin
public class WorkflowController {

    private final WorkflowService workflowService;

    @PostMapping
    public ResponseEntity<Workflow> createWorkflow(@RequestBody CreateWorkflowReq createWorkflowReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workflowService.createWorkflow(createWorkflowReq));
    }

    @PostMapping("/set")
    public ResponseEntity<Workflow> assignDigsToExistingWorkflow(@RequestBody AssignDigToWorkflowReq assignDigToWorkflowReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workflowService.setDigsToExistingWorkflow(assignDigToWorkflowReq));
    }

    @GetMapping
    public ResponseEntity<List<Workflow>> getAllWorkflows() {
        return ResponseEntity.status(HttpStatus.OK).body(workflowService.getAllWorkflows());
    }

    @GetMapping("{id}")
    public ResponseEntity<Workflow> getWorkflow(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(workflowService.getWorkflow(id));
    }

    @PatchMapping()
    public ResponseEntity<Workflow> updateWorkflow(@RequestBody UpdateWorkflowReq updateWorkflowReq) {
        return ResponseEntity.status(HttpStatus.OK).body(workflowService.setRepairStatus(updateWorkflowReq));
    }
}
