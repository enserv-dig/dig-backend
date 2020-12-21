package com.enservsolutions.dig.dto.workflow;

import lombok.Data;

import java.util.List;

@Data
public class AssignDigToWorkflowReq {
    private Integer workflowId;
    private List<Integer> digIds;
}
