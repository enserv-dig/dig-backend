package com.enservsolutions.dig.entity;

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
@Table(name="pptype")
public class PaperworkType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paperworkTypeId;

    private String paperworkTypeTitle;

    private boolean paperworkTypeRepair;


}
