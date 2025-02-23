package com.dev.rapidticket.filterevent.controller;

import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.filterevent.service.FilterEventService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class FilterEventController {

    private final FilterEventService filterEventService;

    public FilterEventController(FilterEventService filterEventService) {
        this.filterEventService = filterEventService;
    }

    @PostMapping(path = "/events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilterEventResponse> getFilterEvents(@RequestBody @Valid FilterEventRequest filterEventRequest) {
        return ResponseEntity.ok(filterEventService.getFilterEvents(filterEventRequest));
    }
}
