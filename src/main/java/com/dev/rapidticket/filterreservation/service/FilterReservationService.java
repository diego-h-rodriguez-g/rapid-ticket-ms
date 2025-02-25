package com.dev.rapidticket.filterreservation.service;

import com.dev.rapidticket.filterreservation.model.FilterReservationRequest;
import com.dev.rapidticket.filterreservation.model.FilterReservationResponse;
import jakarta.validation.Valid;

public interface FilterReservationService {
    FilterReservationResponse getFilterReservation(@Valid FilterReservationRequest filterReservationRequest);
}
