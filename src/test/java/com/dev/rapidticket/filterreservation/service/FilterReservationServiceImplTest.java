package com.dev.rapidticket.filterreservation.service;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.entity.Reservation;
import com.dev.rapidticket.filterreservation.dto.ReservationDTO;
import com.dev.rapidticket.filterreservation.mapper.FilterReservationMapper;
import com.dev.rapidticket.filterreservation.model.FilterReservationRequest;
import com.dev.rapidticket.filterreservation.model.FilterReservationResponse;
import com.dev.rapidticket.filterreservation.repository.FilterReservationRepository;
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

public class FilterReservationServiceImplTest {

    @InjectMocks
    private FilterReservationServiceImpl filterReservationServiceImpl;

    @Mock
    private FilterReservationRepository filterReservationRepository;

    @Mock
    private FilterReservationMapper filterReservationMapper;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of FilterReservationResponse in method getFilterReservation")
    public void returnFilterReservationResponseListInGetFilterReservation() {
        FilterReservationRequest filterReservationRequest = injectDataTest.buildFilterReservationRequest(200);
        List<Reservation> reservationList = Collections.singletonList(injectDataTest.buildReservation());
        List<ReservationDTO> reservationDTOList = Collections.singletonList(injectDataTest.buildReservationDTO());
        FilterReservationResponse filterReservationResponse =injectDataTest.buildFilterReservationResponse(200);
        filterReservationResponse.setRowCount(reservationDTOList.size());
        filterReservationResponse.setReservationList(reservationDTOList);

        when(filterReservationRepository.findByCustomerDocumentNumber(filterReservationRequest.getCustomerDocumentNumber())).thenReturn(reservationList);
        when(filterReservationMapper.entitiesToDtoList(reservationList)).thenReturn(reservationDTOList);

        Assertions.assertEquals(filterReservationResponse, filterReservationServiceImpl.getFilterReservation(filterReservationRequest));
    }
}
