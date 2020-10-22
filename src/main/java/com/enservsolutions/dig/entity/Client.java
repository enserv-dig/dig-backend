package com.enservsolutions.dig.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientId;

    private String clientName;
    private boolean activeClient;

//    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Facility> facilitySet;

    public Client(String clientName, boolean activeClient) {
        this.clientName = clientName;
        this.activeClient = activeClient;
    }
}
