package com.dev.rapidticket.createreservation.service;

import com.dev.rapidticket.commons.repository.SectorSeatRepository;
import com.dev.rapidticket.createreservation.mapper.CreateReservationMapper;
import com.dev.rapidticket.createreservation.model.CreateReservationRequest;
import com.dev.rapidticket.createreservation.model.CreateReservationResponse;
import com.dev.rapidticket.createreservation.repository.CreateReservationRepository;
import com.dev.rapidticket.createreservation.utilities.CreateReservationUtilities;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;

import static com.dev.rapidticket.createreservation.utilities.Constants.RESPONSE_MESSAGE_RESERVATION;

@Service
public class CreateReservationServiceImpl implements CreateReservationService {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(CreateReservationServiceImpl.class));

    private final SectorSeatRepository sectorSeatRepository;
    private final CreateReservationRepository createReservationRepository;
    private final CreateReservationMapper createReservationMapper;
    private final CreateReservationUtilities createReservationUtilities;

    public CreateReservationServiceImpl(SectorSeatRepository sectorSeatRepository, CreateReservationRepository createReservationRepository, CreateReservationMapper createReservationMapper, CreateReservationUtilities createReservationUtilities) {
        this.sectorSeatRepository = sectorSeatRepository;
        this.createReservationRepository = createReservationRepository;
        this.createReservationMapper = createReservationMapper;
        this.createReservationUtilities = createReservationUtilities;
    }

    @Transactional
    @Override
    public CreateReservationResponse createReservation(CreateReservationRequest createReservationRequest) {
        log.log(Level.INFO, "A new reservation has been initiated for customer name : {0}. Number of tickets to reserve: {1}", new Object[]{createReservationRequest.getCustomerName(), createReservationRequest.getSectorSeatIds().size()});
        Integer totalSectorSeatIds = sectorSeatRepository.updateSectorsSeats(createReservationRequest.getSectorSeatIds());
        log.log(Level.INFO, "The reservation process has been generated successfully. Number of reserved seats: {0}", totalSectorSeatIds);
        createReservationUtilities.validateRequestConsistency(createReservationRequest.getSectorSeatIds().size(), totalSectorSeatIds);
        List<Object[]> reservationDTOList = sectorSeatRepository.getInfoReservation(createReservationRequest.getSectorSeatIds());
        log.log(Level.INFO, "All the information for generating the reservation ticket has been obtained for {0} tickets", reservationDTOList.size());
        createReservationUtilities.validateRequestConsistency(createReservationRequest.getSectorSeatIds().size(), reservationDTOList.size());
        List<Object[]> customerReservationObjectList = createReservationMapper.reservationObjectToCustomerReservationObject(reservationDTOList, createReservationRequest.getCustomerDocumentNumber(), createReservationRequest.getCustomerName());
        int[] rowCount = createReservationRepository.createReservations(customerReservationObjectList);
        createReservationUtilities.validateRequestConsistency(createReservationRequest.getSectorSeatIds().size(), rowCount.length);
        log.log(Level.INFO, "The reservation process has been completed for a total of registrations of: {0}", new Object[]{rowCount.length});
        return CreateReservationResponse.builder()
                .rowCount(rowCount.length)
                .message(RESPONSE_MESSAGE_RESERVATION)
                .build();
    }
}
