package com.dev.rapidticket.createreservation.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dev.rapidticket.createreservation.utilities.Constants.INSERT_VALUES_RESERVATION;

@Repository
public class CreateReservationRepositoryImpl implements CreateReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public CreateReservationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] createReservations(List<Object[]> reservationDTOList){
       return jdbcTemplate.batchUpdate(INSERT_VALUES_RESERVATION,reservationDTOList);
    }
}
