package com.enservsolutions.dig.dto.pipeline;

import lombok.Data;

@Data
public class CreatePipelineReq {
    private String pipelineName;
    private String activePipeline;
    private int facilityId;
}
