package com.enservsolutions.dig.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer workflowId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "workflow_dig",
            joinColumns = @JoinColumn(name = "workflow_id"),
            inverseJoinColumns = @JoinColumn(name = "dig_id"))
    private List<Dig> digs;

    private String workflowName;
    private boolean repairRequired;

    public Workflow(String workflowName) {
        this.workflowName = workflowName;
    }
}
