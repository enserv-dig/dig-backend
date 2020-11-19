package com.enservsolutions.dig.entity;

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
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uploadId;

    private String tag;

    private String fileName;

    @OneToOne
    private Dig dig;
}
