package com.enservsolutions.dig.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pipeline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pipelineId;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "facility_id", nullable=false)
    @JsonIgnore
    private Facility facility;

    private String pipelineName;
    private boolean activePipeline;



}
