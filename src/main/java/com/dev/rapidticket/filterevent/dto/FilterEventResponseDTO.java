package com.dev.rapidticket.filterevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FilterEventResponseDTO {
    private Integer eventId;
    private Integer experienceId;
    private String experienceName;
    private String eventDateTime;
    private Integer placeId;
    private String placeName;
    private Integer sectorId;
    private String sectorName;
    private BigDecimal sectorPrice;
    private Long availableSeats;
}
