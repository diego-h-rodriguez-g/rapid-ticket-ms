package com.dev.rapidticket.createreservation.utilities;

import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component
public class CreateReservationUtilitiesImpl implements CreateReservationUtilities {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(CreateReservationUtilitiesImpl.class));

    @Override
    public void validateRequestConsistency(Integer amountExpected, Integer amountReceived) throws IllegalStateException {
        log.log(Level.INFO, "A data consistency validation has been initiated. amount expected: {0}, amount received {1}", new Object[]{amountExpected, amountReceived});
        if (Boolean.FALSE.equals(amountReceived.equals(amountExpected))) {
            throw new IllegalStateException("Consistency validation on request failed, expected amount differs from received amount");
        }
        log.log(Level.INFO, "Data consistency looks good and the transaction is still valid");
    }
}
