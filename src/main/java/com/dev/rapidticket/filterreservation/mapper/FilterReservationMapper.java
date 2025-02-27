package com.dev.rapidticket.filterreservation.mapper;

import com.dev.rapidticket.commons.entity.Reservation;
import com.dev.rapidticket.filterreservation.dto.ReservationDTO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FilterReservationMapper {

    public List<ReservationDTO> entitiesToDtoList(List<Reservation> entities) {
        return entities.stream()
                .map(entity -> ReservationDTO.builder()
                        .reservationId(entity.getReservationId())
                        .customerDocumentNumber(entity.getCustomerDocumentNumber())
                        .customerName(entity.getCustomerName())
                        .eventId(entity.getEvent().getEventId())
                        .experienceId(entity.getExperience().getExperienceId())
                        .experienceName(entity.getExperienceName())
                        .placeId(entity.getPlace().getPlaceId())
                        .placeName(entity.getPlaceName())
                        .sectorId(entity.getSector().getSectorId())
                        .sectorName(entity.getSectorName())
                        .sectorPrice(entity.getSectorPrice())
                        .sectorsSeatsId(entity.getSectorSeat().getSectorsSeatsId())
                        .seatId(entity.getSeat().getSeatId())
                        .seatRow(entity.getSeatRow())
                        .seatColumn(entity.getSeatColumn())
                        .seatNumber(entity.getSeatNumber())
                        .createdAt(entity.getCreatedAt())
                        .build()
                )
                .toList();
    }
}
