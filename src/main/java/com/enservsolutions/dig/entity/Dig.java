package com.enservsolutions.dig.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    private Integer digId;

//    @ManyToMany(mappedBy = "digs")
//    private Workflow workflow;

    private Integer anomalyId;
    private Integer inspectionYear;
    private String feature;
    private double wheelCount;
    private double stationNumber;
    private String depthPct;
    private double wtNom;
    private double asCalledLengthIn;
    private double asCalledWidthIn;
    private String orientation;
    private double pPrimeMod831g;
    private double erfMod831g;
    private double pPrimeB31g;
    private double erfB31g;
    private double pPrimeRstreng;
    private double erfRstreng;
    private String pctMaxOpPress;

    private double distUsWeld;
    private double distDsWeld;
    private String usAgm;
    private double distUsAgm;
    private String dsAgm;
//    private double distDsAgm;

    private double jointLength;
    private String seamOrientation;
    private boolean adjacentLongSeam;
    private boolean longSeamInteraction;
    private String comments;
    private double latitude;
    private double longitude;
    private double altitude;

}
