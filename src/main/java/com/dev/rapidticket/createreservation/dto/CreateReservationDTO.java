package com.dev.rapidticket.createreservation.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateReservationDTO {
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
}
