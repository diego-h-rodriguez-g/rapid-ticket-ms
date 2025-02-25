package com.dev.rapidticket.filterreservation.controller;

import com.dev.rapidticket.filterreservation.model.FilterReservationRequest;
import com.dev.rapidticket.filterreservation.model.FilterReservationResponse;
import com.dev.rapidticket.filterreservation.service.FilterReservationService;
import com.dev.rapidticket.sectorseat.model.SectorSeatResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FilterReservationController {

    private final FilterReservationService filterReservationService;

    public FilterReservationController(FilterReservationService filterReservationService) {
        this.filterReservationService = filterReservationService;
    }

    @PostMapping(path = "/reservation-list", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilterReservationResponse> getFilterReservation(@RequestBody @Valid FilterReservationRequest filterReservationRequest) {
        return ResponseEntity.ok(filterReservationService.getFilterReservation(filterReservationRequest));
    }
}
