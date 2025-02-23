package com.dev.rapidticket.sectorseat.repository;

import com.dev.rapidticket.commons.entity.SectorSeat;
import com.dev.rapidticket.sectorseat.dto.SectorSeatDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorSeatRepository extends JpaRepository<SectorSeat, Integer> {

    @Query(value = "SELECT ss.sectors_seats_id, ss.seat_id, e.event_id, s.sector_id, s.sector_name, s.sector_price, ss.seat_number " +
            "FROM rapid_ticket.sectors s " +
            "JOIN rapid_ticket.sectors_seats ss ON s.sector_id = ss.sector_id " +
            "JOIN rapid_ticket.events e ON s.event_id = e.event_id " +
            "WHERE s.event_id = :eventId AND ss.available_seat = TRUE", nativeQuery = true)
    List<SectorSeatDTO> getAvailableSeats(Integer eventId);
}
