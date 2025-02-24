package com.dev.rapidticket.createreservation.service;


import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.repository.SectorSeatRepository;
import com.dev.rapidticket.createreservation.mapper.CreateReservationMapper;
import com.dev.rapidticket.createreservation.model.CreateReservationRequest;
import com.dev.rapidticket.createreservation.model.CreateReservationResponse;
import com.dev.rapidticket.createreservation.repository.CreateReservationRepository;
import com.dev.rapidticket.createreservation.utilities.CreateReservationUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class CreateReservationServiceImplTest {

    @InjectMocks
    private CreateReservationServiceImpl createReservationService;
    @Mock
    private SectorSeatRepository sectorSeatRepository;
    @Mock
    private CreateReservationRepository createReservationRepository;
    @Mock
    private CreateReservationMapper createReservationMapper;
    @Mock
    private CreateReservationUtilities createReservationUtilities;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of Objects in method reservationObjectToCustomerReservationObject")
    public void returnListObjectInReservationObjectToCustomerReservationObject() {
        CreateReservationRequest createReservationRequest = injectDataTest.buildCreateReservationRequest(200);
        CreateReservationResponse createReservationResponse = injectDataTest.buildCreateReservationResponse(200);
        List<Integer> sectorSeatIds = createReservationRequest.getSectorSeatIds();
        Integer totalSectorSeatIds = sectorSeatIds.size();
        Object[] object = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        List<Object[]> reservationDTOList = Collections.singletonList(object);
        int[] rowCount = new int[1];

        when(sectorSeatRepository.updateSectorsSeats(createReservationRequest.getSectorSeatIds())).thenReturn(totalSectorSeatIds);
        when(sectorSeatRepository.getInfoReservation(createReservationRequest.getSectorSeatIds())).thenReturn(reservationDTOList);
        when(createReservationMapper.reservationObjectToCustomerReservationObject(reservationDTOList, createReservationRequest.getCustomerDocumentNumber(), createReservationRequest.getCustomerName())).thenReturn(reservationDTOList);
        when(createReservationRepository.createReservations(reservationDTOList)).thenReturn(rowCount);

        Assertions.assertEquals(createReservationResponse.getMessage(), createReservationService.createReservation(createReservationRequest).getMessage());
    }
}
