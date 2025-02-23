package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sectors_seats")
@Data
public class SectorSeat {

    @Id
    @Column(name = "sectors_seats_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectorsSeatsId;

    @ManyToOne
    @JoinColumn(name = "sector_id", referencedColumnName = "sector_id", insertable = false, updatable = false)
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id", insertable = false, updatable = false)
    private Seat seat;

    @Column(name = "available_seat")
    private Boolean availableSeat;

    @Column(name = "seat_number")
    private Integer seatNumber;
}
