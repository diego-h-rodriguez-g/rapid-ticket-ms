package com.dev.rapidticket.filterreservation.mapper;

import com.dev.rapidticket.InjectDataTest;
import com.dev.rapidticket.commons.entity.Reservation;
import com.dev.rapidticket.filterreservation.dto.ReservationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;

public class FilterReservationMapperTest {

    @InjectMocks
    private FilterReservationMapper filterReservationMapper;

    @Mock
    private ModelMapper modelMapper;

    private final InjectDataTest injectDataTest = new InjectDataTest();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return a List of ReservationDTO in method entitiesToDtoList")
    public void returnReservationDTOListInEntitiesToDtoList() {
        List<Reservation> entities = Collections.singletonList(injectDataTest.buildReservation());

        when(modelMapper.map(entities, ReservationDTO[].class)).thenReturn(new ReservationDTO[]{});

        assertThat(filterReservationMapper.entitiesToDtoList(entities), instanceOf(List.class));
    }
}
