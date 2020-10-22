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

//    @OneToMany(mappedBy = "dig")
//    private List<Dig> digs;
}
