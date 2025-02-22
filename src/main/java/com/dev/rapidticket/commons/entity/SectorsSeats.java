package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sectors_seats")
@Data
public class SectorsSeats {

    @Id
    @Column(name = "sectors_seats_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectorsSeatsId;

    @Id
    @Column(name = "sector_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectorId;

    @Column(name = "seat_id")
    private Integer seatId;

    @Column(name = "available_seat")
    private Boolean availableSeat;

    @Column(name = "version")
    private Integer version;

    @Column(name = "seat_number")
    private Integer seatNumber;

}
