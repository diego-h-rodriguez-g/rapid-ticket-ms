package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Seats")
@Data
public class Seat {

    @Id
    @Column(name = "seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "seat_row")
    private Integer seatRow;

    @Column(name = "seat_column")
    private Integer seatColumn;
}
