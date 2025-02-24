package com.dev.rapidticket.createreservation.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateReservationResponse {
    private Integer rowCount;
    private String message;
}
