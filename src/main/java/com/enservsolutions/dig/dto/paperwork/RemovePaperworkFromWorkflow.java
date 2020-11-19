package com.enservsolutions.dig.dto.paperwork;

import lombok.Data;

@Data
public class RemovePaperworkFromWorkflow {
    private Integer workflowId;
    private Integer paperworkId;
}
