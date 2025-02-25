package com.dev.rapidticket.sectorseat.service;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.sectorseat.dto.SectorSeatDTO;
import com.dev.rapidticket.sectorseat.model.SectorSeatResponse;
import com.dev.rapidticket.commons.repository.SectorSeatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SectorSeatServiceImplTest {
    @InjectMocks
    private SectorSeatServiceImpl sectorSeatService;

    @Mock
    private SectorSeatRepository sectorSeatRepository;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a SectorSeatResponse in method getAvailableSeats")
    void returnSectorSeatResponseInGetAvailableSeats() {
        int eventId = 1;
        List<SectorSeatDTO> sectorSeatDTOList = Collections.singletonList(injectDataTest.buildSectorSeatDTO());
        SectorSeatResponse expectedResponse = injectDataTest.buildSectorSeatResponse(200);

        when(sectorSeatRepository.getAvailableSeats(eventId)).thenReturn(sectorSeatDTOList);

        assertEquals(expectedResponse, sectorSeatService.getAvailableSeats(eventId));
    }
}
