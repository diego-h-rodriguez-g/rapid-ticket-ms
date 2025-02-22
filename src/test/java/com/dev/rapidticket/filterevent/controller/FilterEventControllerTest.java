package com.dev.rapidticket.filterevent.controller;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.filterevent.service.FilterEventService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

public class FilterEventControllerTest {
    @InjectMocks
    private FilterEventController filterEventController;
    @Mock
    private FilterEventService filterEventService;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnFilterEventResponseInFilterEventResponse() {
        FilterEventRequest filterEventRequest = injectDataTest.buildFilterEventRequest(200);
        FilterEventResponse filterEventResponse = injectDataTest.buildFilterEventResponse(200);
        ResponseEntity<FilterEventResponse> expectedResponse = ResponseEntity.ok(filterEventResponse);

        when(filterEventService.getFilterEvents(filterEventRequest)).thenReturn(filterEventResponse);

        ResponseEntity<FilterEventResponse> receivedResponse = filterEventController.getFilterEvents(filterEventRequest);
        Assertions.assertEquals(expectedResponse, receivedResponse);
    }
}
