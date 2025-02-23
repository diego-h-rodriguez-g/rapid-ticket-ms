package com.dev.rapidticket.sectorseat.controller;

import com.dev.rapidticket.sectorseat.model.SectorSeatResponse;
import com.dev.rapidticket.sectorseat.service.SectorSeatService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SectorSeatController {

    private final SectorSeatService sectorSeatService;

    public SectorSeatController(SectorSeatService sectorSeatService) {
        this.sectorSeatService = sectorSeatService;
    }

    @GetMapping(path = "/{eventId}/seats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectorSeatResponse> getAvailableSeat(@PathVariable(name = "eventId")  int eventId) {
        return ResponseEntity.ok(sectorSeatService.getAvailableSeats(eventId));
    }
}
