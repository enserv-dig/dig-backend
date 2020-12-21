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
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer photoId;

    private String name;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] picByte;

    public Photo(String name, byte[] decompressBytes) {
        this.name = name;
        this.picByte = decompressBytes;
    }
}
