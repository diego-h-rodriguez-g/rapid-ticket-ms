package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "sectors")
@Data
public class Sector {

    @Id
    @Column(name = "sector_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectorId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "sector_name")
    private String sectorName;

    @Column(name = "sector_price")
    private BigDecimal sectorPrice;
}
