package com.dev.rapidticket.sectorseat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class SectorSeatDTO {
    private Integer sectorsSeatsId;
    private Integer seatId;
    private Integer eventId;
    private Integer sectorId;
    private String sectorName;
    private BigDecimal sectorPrice;
    private Integer seatNumber;
}
