package com.dev.rapidticket.filterreservation.mapper;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.entity.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class FilterReservationMapperTest {

    @InjectMocks
    private FilterReservationMapper filterReservationMapper;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of ReservationDTO in method entitiesToDtoList")
    public void returnReservationDTOListInEntitiesToDtoList() {
        List<Reservation> entities = Collections.singletonList(injectDataTest.buildReservation());

        assertThat(filterReservationMapper.entitiesToDtoList(entities), instanceOf(List.class));
    }
}
