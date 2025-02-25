package com.dev.rapidticket.filterreservation.controller;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.filterreservation.model.FilterReservationRequest;
import com.dev.rapidticket.filterreservation.model.FilterReservationResponse;
import com.dev.rapidticket.filterreservation.service.FilterReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

public class FilterReservationControllerTest {
    @InjectMocks
    private FilterReservationController filterReservationController;
    @Mock
    private FilterReservationService filterReservationService;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnFilterReservationResponseInGetFilterReservation() {
        FilterReservationRequest filterReservationRequest = injectDataTest.buildFilterReservationRequest(0);
        FilterReservationResponse filterReservationResponse = injectDataTest.buildFilterReservationResponse(0);
        ResponseEntity<FilterReservationResponse> expectedResponse = ResponseEntity.ok(filterReservationResponse);

        when(filterReservationService.getFilterReservation(filterReservationRequest)).thenReturn(filterReservationResponse);

        ResponseEntity<FilterReservationResponse> receivedResponse = filterReservationController.getFilterReservation(filterReservationRequest);
        Assertions.assertEquals(expectedResponse.getStatusCode(), receivedResponse.getStatusCode());
    }
}
