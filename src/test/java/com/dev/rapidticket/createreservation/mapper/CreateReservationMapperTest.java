package com.dev.rapidticket.createreservation.mapper;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.createreservation.dto.CreateReservationDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class CreateReservationMapperTest {

    @InjectMocks
    private CreateReservationMapper createReservationMapper;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of CreateReservationDTO in method reservationObjectToCustomerReservationObject")
    public void returnCreateReservationDTOListInReservationDTOToCustomerReservationObject() {
        List<CreateReservationDTO> createReservationDTOList = Collections.singletonList(injectDataTest.buildCreateReservationDTO());
        Long customerDocumentNumber = 10331234567L;
        String customerName = "customerName";

        List<Object[]> receivedResponse = createReservationMapper.reservationDTOToCustomerReservationObject(createReservationDTOList, customerDocumentNumber, customerName);
        Assertions.assertEquals(customerDocumentNumber, receivedResponse.getFirst()[0]);
        Assertions.assertEquals(customerName, receivedResponse.getFirst()[1]);
        Assertions.assertEquals(createReservationDTOList.getLast().getSeatNumber(), receivedResponse.getLast()[14]);

    }
}
