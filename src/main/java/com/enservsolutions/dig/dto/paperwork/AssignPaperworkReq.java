package com.enservsolutions.dig.dto.paperwork;

import lombok.Data;

@Data
public class AssignPaperworkReq {
    private Integer workflowId;
    private Integer paperworkId;
}
