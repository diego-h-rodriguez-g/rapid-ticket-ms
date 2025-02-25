package com.dev.rapidticket.createreservation.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CreateReservationUtilitiesImplTest {
    @InjectMocks
    private CreateReservationUtilitiesImpl createReservationUtilitiesImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("not throw in validateRequestConsistency ")
    public void notThrowInValidateRequestConsistency() {
        Integer amountExpected = 1;
        Integer amountReceived = 1;

        assertDoesNotThrow(() -> createReservationUtilitiesImpl.validateRequestConsistency(amountExpected, amountReceived));
    }

    @Test
    @DisplayName("throw IllegalStateException in validateRequestConsistency ")
    public void throwIllegalStateExceptionInValidateRequestConsistency() {
        Integer amountExpected = 1;
        Integer amountReceived = 2;

        Assertions.assertThrows(IllegalStateException.class, () -> createReservationUtilitiesImpl.validateRequestConsistency(amountExpected, amountReceived));
    }
}
