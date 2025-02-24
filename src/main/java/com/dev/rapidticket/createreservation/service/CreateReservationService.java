package com.dev.rapidticket.createreservation.service;

import com.dev.rapidticket.createreservation.model.CreateReservationRequest;
import com.dev.rapidticket.createreservation.model.CreateReservationResponse;
import jakarta.validation.Valid;

public interface CreateReservationService {

    CreateReservationResponse createReservation(@Valid CreateReservationRequest createReservationRequest);
}
