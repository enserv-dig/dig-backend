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
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer facilityId;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable=false)
    @JsonIgnore
    private Client client;

    private String facilityName;
    private boolean activeFacility;

    public Facility(String facilityName, boolean activeFacility) {
        this.facilityName  = facilityName;
        this.activeFacility = activeFacility;
    }
}
