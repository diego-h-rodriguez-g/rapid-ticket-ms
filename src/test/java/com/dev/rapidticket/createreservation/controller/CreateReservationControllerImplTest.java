
package com.dev.rapidticket.createreservation.controller;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.createreservation.model.CreateReservationRequest;
import com.dev.rapidticket.createreservation.model.CreateReservationResponse;
import com.dev.rapidticket.createreservation.service.CreateReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

public class CreateReservationControllerImplTest {

    @InjectMocks
    private CreateReservationController createReservationController;

    @Mock
    private CreateReservationService createReservationService;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnCreateReservationResponseInCreateReservation() {
        CreateReservationRequest createReservationRequest = injectDataTest.buildCreateReservationRequest(0);
        CreateReservationResponse createReservationResponse = injectDataTest.buildCreateReservationResponse(0);
        ResponseEntity<CreateReservationResponse> expectedResponse = ResponseEntity.ok(createReservationResponse);

        when(createReservationService.createReservation(createReservationRequest)).thenReturn(createReservationResponse);

        ResponseEntity<CreateReservationResponse> receivedResponse = createReservationController.createReservation(createReservationRequest);
        Assertions.assertEquals(expectedResponse.getStatusCode(), receivedResponse.getStatusCode());
    }
}

