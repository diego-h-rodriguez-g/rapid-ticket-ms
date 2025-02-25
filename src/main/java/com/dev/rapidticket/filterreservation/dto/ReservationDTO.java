package com.dev.rapidticket.filterreservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Integer reservationId;

    private Long customerDocumentNumber;

    private String customerName;

    private Integer eventId;

    private Integer experienceId;

    private String experienceName;

    private Integer placeId;

    private String placeName;

    private Integer sectorId;

    private String sectorName;

    private BigDecimal sectorPrice;

    private Integer sectorsSeatsId;

    private Integer seatId;

    private Integer seatRow;

    private Integer seatColumn;

    private Integer seatNumber;

    private LocalDateTime createdAt;
}
