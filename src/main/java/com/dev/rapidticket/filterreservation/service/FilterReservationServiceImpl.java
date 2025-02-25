package com.dev.rapidticket.filterreservation.service;

import com.dev.rapidticket.commons.entity.Reservation;
import com.dev.rapidticket.filterreservation.dto.ReservationDTO;
import com.dev.rapidticket.filterreservation.mapper.FilterReservationMapper;
import com.dev.rapidticket.filterreservation.model.FilterReservationRequest;
import com.dev.rapidticket.filterreservation.model.FilterReservationResponse;
import com.dev.rapidticket.filterreservation.repository.FilterReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_FILTER_RESERVATION;

@Service
public class FilterReservationServiceImpl implements FilterReservationService {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(FilterReservationServiceImpl.class));

    private final FilterReservationRepository filterReservationRepository;

    private final FilterReservationMapper filterReservationMapper;

    public FilterReservationServiceImpl(FilterReservationRepository filterReservationRepository, FilterReservationMapper filterReservationMapper) {
        this.filterReservationRepository = filterReservationRepository;
        this.filterReservationMapper = filterReservationMapper;
    }

    @Override
    public FilterReservationResponse getFilterReservation(FilterReservationRequest filterReservationRequest) {
        log.log(Level.INFO, "A new filter reservation has been initiated");
        List<Reservation> reservationList = filterReservationRepository.findByCustomerDocumentNumber(filterReservationRequest.getCustomerDocumentNumber());
        List<ReservationDTO> reservationDTOList = filterReservationMapper.entitiesToDtoList(reservationList);
        return FilterReservationResponse.builder()
                .rowCount(reservationDTOList.size())
                .message(RESPONSE_MESSAGE_FILTER_RESERVATION)
                .reservationList(reservationDTOList)
                .build();
    }
}
