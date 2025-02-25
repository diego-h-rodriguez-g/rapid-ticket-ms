package com.dev.rapidticket.filterreservation.repository;

import com.dev.rapidticket.commons.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilterReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE " +
            "(:customerDocumentNumber IS NULL OR r.customerDocumentNumber = :customerDocumentNumber)")
    List<Reservation> findByCustomerDocumentNumber(@Param("customerDocumentNumber") Long customerDocumentNumber);

}
