package com.dev.rapidticket.createreservation.mapper;

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

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of Objects in method reservationObjectToCustomerReservationObject")
    public void returnListObjectInReservationObjectToCustomerReservationObject() {
        Object[] object = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        List<Object[]> objects = Collections.singletonList(object);
        Long customerDocumentNumber = 10331234567L;
        String customerName = "customerName";

        List<Object[]> receivedResponse = createReservationMapper.reservationObjectToCustomerReservationObject(objects, customerDocumentNumber, customerName);
        Assertions.assertEquals(customerDocumentNumber, receivedResponse.getFirst()[0]);
        Assertions.assertEquals(customerName, receivedResponse.getFirst()[1]);
        Assertions.assertEquals(objects.getLast()[12], receivedResponse.getLast()[14]);

    }
}
