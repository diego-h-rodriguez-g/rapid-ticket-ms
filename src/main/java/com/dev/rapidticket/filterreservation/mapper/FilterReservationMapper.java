package com.dev.rapidticket.filterreservation.mapper;

import com.dev.rapidticket.commons.entity.Reservation;
import com.dev.rapidticket.filterreservation.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FilterReservationMapper {

    private final ModelMapper modelMapper;

    public FilterReservationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<ReservationDTO> entitiesToDtoList(List<Reservation> entities) {
        return Arrays.asList(modelMapper.map(entities, ReservationDTO[].class));
    }
}
