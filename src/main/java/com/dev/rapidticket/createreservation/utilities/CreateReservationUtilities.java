package com.dev.rapidticket.createreservation.utilities;

public interface CreateReservationUtilities {
    void validateRequestConsistency(Integer amountExpected, Integer amountReceived) throws IllegalStateException;
}
