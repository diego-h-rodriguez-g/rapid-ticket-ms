package com.dev.rapidticket.createreservation.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateReservationMapper {

    public List<Object[]> reservationObjectToCustomerReservationObject(List<Object[]> objects, Long customerDocumentNumber, String customerName) {
        return  objects.stream()
                .map(row -> new Object[]{
                        customerDocumentNumber,
                        customerName,
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        row[4],
                        row[5],
                        row[6],
                        row[7],
                        row[8],
                        row[9],
                        row[10],
                        row[11],
                        row[12]
                })
                .collect(Collectors.toList());
    }
}
