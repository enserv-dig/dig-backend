package com.enservsolutions.dig.dto.workflow;

import lombok.Data;

@Data
public class UpdateWorkflowReq {
    private String repairStatus;
    private Integer workflowId;
}
