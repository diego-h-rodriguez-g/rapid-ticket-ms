package com.dev.rapidticket.sectorseat.model;

import com.dev.rapidticket.sectorseat.dto.SectorSeatDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorSeatResponse {
    private Integer rowCount;
    private String message;
    private List<SectorSeatDTO> availableSeats;
}
