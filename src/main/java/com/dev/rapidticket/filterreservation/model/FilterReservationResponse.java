package com.dev.rapidticket.filterreservation.model;

import com.dev.rapidticket.filterreservation.dto.ReservationDTO;
import lombok.Builder;
import lombok.Data;
import java.util.List;


@Builder
@Data
public class FilterReservationResponse {
    private Integer rowCount;
    private String message;
    private List<ReservationDTO> reservationList;
}
