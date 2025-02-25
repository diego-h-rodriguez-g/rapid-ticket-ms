package com.dev.rapidticket.createreservation.controller;

import com.dev.rapidticket.createreservation.model.CreateReservationRequest;
import com.dev.rapidticket.createreservation.model.CreateReservationResponse;
import com.dev.rapidticket.createreservation.service.CreateReservationService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreateReservationController {

    private final CreateReservationService createReservationService;

    public CreateReservationController(CreateReservationService createReservationService) {
        this.createReservationService = createReservationService;
    }

    @PostMapping(path = "/reservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateReservationResponse> createReservation(@RequestBody @Valid CreateReservationRequest createReservationRequest) {
        return ResponseEntity.ok(createReservationService.createReservation(createReservationRequest));
    }
}
