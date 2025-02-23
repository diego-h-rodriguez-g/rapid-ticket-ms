package com.dev.rapidticket.sectorseat.controller;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.sectorseat.model.SectorSeatResponse;
import com.dev.rapidticket.sectorseat.service.SectorSeatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

public class SectorSeatControllerTest {
    @InjectMocks
    private SectorSeatController sectorSeatController;
    @Mock
    private SectorSeatService sectorSeatService;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnGetJavaStackResponseInGetJavaStack() {
        int eventId=1;
        SectorSeatResponse sectorSeatResponse = injectDataTest.buildSectorSeatResponse(0);
        ResponseEntity<SectorSeatResponse> expectedResponse = ResponseEntity.ok(sectorSeatResponse);

        when(sectorSeatService.getAvailableSeats(eventId)).thenReturn(sectorSeatResponse);

        ResponseEntity<SectorSeatResponse> receivedResponse = sectorSeatController.getAvailableSeat(eventId);
        Assertions.assertEquals(expectedResponse.getStatusCode(), receivedResponse.getStatusCode());
    }
}
