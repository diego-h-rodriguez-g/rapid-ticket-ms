package com.dev.rapidticket.sectorseat.service;

import com.dev.rapidticket.sectorseat.dto.SectorSeatDTO;
import com.dev.rapidticket.sectorseat.model.SectorSeatResponse;
import com.dev.rapidticket.commons.repository.SectorSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

import static com.dev.rapidticket.sectorseat.utilities.Constants.RESPONSE_MESSAGE_SECTOR_SEAT;

@Service
public class SectorSeatServiceImpl implements SectorSeatService {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(SectorSeatServiceImpl.class));

    private final SectorSeatRepository sectorSeatRepository;

    public SectorSeatServiceImpl(SectorSeatRepository sectorSeatRepository) {
        this.sectorSeatRepository = sectorSeatRepository;
    }

    @Override
    public SectorSeatResponse getAvailableSeats(Integer eventId) {
        log.log(Level.INFO, "A new get available seats list request has been started with the following data: {0}", new Object[]{eventId});
        List<SectorSeatDTO> availableSeats = sectorSeatRepository.getAvailableSeats(eventId);
        log.log(Level.INFO, "A new get available seats list response has been completed with a total of records obtained: {0}", availableSeats.size());
        return SectorSeatResponse.builder()
                .rowCount(availableSeats.size())
                .message(RESPONSE_MESSAGE_SECTOR_SEAT)
                .availableSeats(availableSeats)
                .build();
    }
}
