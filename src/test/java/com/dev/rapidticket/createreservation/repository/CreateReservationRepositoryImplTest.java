package com.dev.rapidticket.createreservation.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

import static com.dev.rapidticket.createreservation.utilities.Constants.INSERT_VALUES_RESERVATION;
import static org.mockito.Mockito.when;

public class CreateReservationRepositoryImplTest {
    @InjectMocks
    private CreateReservationRepositoryImpl createReservationRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnArrayIntInCreateReservations() {
        Object[] object = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        List<Object[]> objects = Collections.singletonList(object);
        int[] expectedResponse= new int[1];
        when(jdbcTemplate.batchUpdate(INSERT_VALUES_RESERVATION,objects)).thenReturn(expectedResponse);
        Assertions.assertEquals(expectedResponse, createReservationRepository.createReservations(objects));
    }
}
