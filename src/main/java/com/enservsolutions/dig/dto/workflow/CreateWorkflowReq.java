package com.enservsolutions.dig.dto.workflow;

import com.enservsolutions.dig.entity.Dig;
import lombok.Data;

import java.util.List;

@Data
public class CreateWorkflowReq {
    private String workflowName;
    private List<Integer> digIds;
}
