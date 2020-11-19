package com.enservsolutions.dig.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pp")
public class Paperwork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paperworkId;

    private String paperworkName;

    private boolean done;

    private String action;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paperwork_type_id")
    private PaperworkType paperworkType;

}
