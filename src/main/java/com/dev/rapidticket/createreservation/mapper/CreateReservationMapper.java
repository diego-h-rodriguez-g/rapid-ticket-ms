package com.dev.rapidticket.createreservation.mapper;

import com.dev.rapidticket.createreservation.dto.CreateReservationDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateReservationMapper {

    public List<Object[]> reservationDTOToCustomerReservationObject(List<CreateReservationDTO> createReservationDTOList, Long customerDocumentNumber, String customerName) {
        return  createReservationDTOList.stream()
                .map(createReservationDTO -> new Object[]{
                        customerDocumentNumber,
                        customerName,
                        createReservationDTO.getEventId(),
                        createReservationDTO.getExperienceId(),
                        createReservationDTO.getExperienceName(),
                        createReservationDTO.getPlaceId(),
                        createReservationDTO.getPlaceName(),
                        createReservationDTO.getSectorId(),
                        createReservationDTO.getSectorName(),
                        createReservationDTO.getSectorPrice(),
                        createReservationDTO.getSectorsSeatsId(),
                        createReservationDTO.getSeatId(),
                        createReservationDTO.getSeatRow(),
                        createReservationDTO.getSeatColumn(),
                        createReservationDTO.getSeatNumber()
                })
                .collect(Collectors.toList());
    }
}
