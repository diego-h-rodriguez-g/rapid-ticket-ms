package com.dev.rapidticket.commons.repository;

import com.dev.rapidticket.commons.entity.SectorSeat;
import com.dev.rapidticket.createreservation.dto.CreateReservationDTO;
import com.dev.rapidticket.sectorseat.dto.SectorSeatDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("UPDATE SectorSeat ss SET ss.availableSeat = FALSE WHERE ss.id IN :sectorSeatIds AND ss.availableSeat = TRUE")
    Integer updateSectorsSeats(List<Integer> sectorSeatIds);

    @Query(value = "SELECT e.event_id, e.experience_id, exp.experience_name, e.place_id, p.place_name, s.sector_id, " +
            " s.sector_name, s.sector_price, ss.sectors_seats_id, ss.seat_id, st.seat_row, st.seat_column, ss.seat_number " +
            "FROM rapid_ticket.sectors_seats ss " +
            "JOIN rapid_ticket.sectors s ON ss.sector_id = s.sector_id " +
            "JOIN rapid_ticket.events e ON s.event_id = e.event_id " +
            "JOIN rapid_ticket.experiences exp ON e.experience_id = exp.experience_id " +
            "JOIN rapid_ticket.places p ON e.place_id = p.place_id " +
            "JOIN rapid_ticket.seats st ON ss.seat_id = st.seat_id " +
            "WHERE ss.sectors_seats_id IN (:sectorSeatIds)", nativeQuery = true)
    List<CreateReservationDTO> getInfoReservation(List<Integer> sectorSeatIds);
}
