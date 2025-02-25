package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "customer_document_number")
    private Long customerDocumentNumber;

    @Column(name = "customer_name")
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @Column(name = "experience_name")
    private String experienceName;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "place_name")
    private String placeName;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @Column(name = "sector_name")
    private String sectorName;

    @Column(name = "sector_price")
    private BigDecimal sectorPrice;

    @ManyToOne
    @JoinColumn(name = "sectors_seats_id")
    private SectorSeat sectorSeat;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Column(name = "seat_row")
    private Integer seatRow;

    @Column(name = "seat_column")
    private Integer seatColumn;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime createdAt;
}