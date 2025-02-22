package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "places")
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer placeId;

    @Column(name = "place_name")
    private String placeName;
}
