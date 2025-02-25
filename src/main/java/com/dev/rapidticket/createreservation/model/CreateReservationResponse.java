package com.dev.rapidticket.createreservation.model;

import com.dev.rapidticket.createreservation.dto.CreateReservationDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CreateReservationResponse {
    private Integer rowCount;
    private String message;
    private String reservationOwnerName;
    private Long reservationOwnerDocumentNumber;
    private List<CreateReservationDTO> reservationData;
}
