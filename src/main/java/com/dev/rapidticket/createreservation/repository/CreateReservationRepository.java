
package com.dev.rapidticket.createreservation.repository;

import java.util.List;

public interface CreateReservationRepository {
    int[] createReservations(List<Object[]> reservationDTOList);

}